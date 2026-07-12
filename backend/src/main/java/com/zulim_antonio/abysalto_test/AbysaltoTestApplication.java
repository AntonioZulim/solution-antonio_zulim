package com.zulim_antonio.abysalto_test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class AbysaltoTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(AbysaltoTestApplication.class, args);
	}

}
