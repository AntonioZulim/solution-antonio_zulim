package com.zulim_antonio.abysalto_test.service;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;

import com.zulim_antonio.abysalto_test.client.ProductClient;
import com.zulim_antonio.abysalto_test.dto.CategoryDto;
import com.zulim_antonio.abysalto_test.dto.ProductDto;
import com.zulim_antonio.abysalto_test.dto.ProductSummaryDto;

@Service
public class ProductService {
    private final ProductClient productClient;

    public ProductService(ProductClient productClient) {
        this.productClient = productClient;
    }
    
    public ProductDto getProductById(Long id){
        return productClient.getProduct(id);
    }

    public Optional<List<ProductSummaryDto>> getProducts(String category, Double minPrice, Double maxPrice){
        Stream<ProductDto> prods;
        if(category!=null){
            Optional<CategoryDto> foundCategory = productClient.getCategories().stream().filter(c -> c.slug().equals(category)).findFirst();
            if(!foundCategory.isPresent()){
                return Optional.empty();
            }
            prods = productClient.getProductsByAbsoluteUrl(URI.create(foundCategory.get().url())).products().stream();
        }
        else{
            prods = productClient.getAllProducts().products().stream();
        }

        if(minPrice!=null){
            prods = prods.filter(p -> p.price()>=minPrice);
        }
        if(maxPrice!=null){
            prods = prods.filter(p -> p.price()<=maxPrice);
        }
        
        return Optional.of(prods.map(p -> new ProductSummaryDto(p.thumbnail(), p.title(), p.price(), shorten(p.description()))).toList());
    }

    public List<ProductSummaryDto> searchProducts(String name){
        return productClient.getAllProducts()
                            .products()
                            .stream()
                            .filter(p -> p.title().toLowerCase().contains(name.toLowerCase()))
                            .map(p -> new ProductSummaryDto(p.thumbnail(), p.title(), p.price(), shorten(p.description())))
                            .toList();
    }

    private String shorten(String desc){
        return desc.length()>100 ? desc.substring(0, 100) + "..." : desc;
    }
}
