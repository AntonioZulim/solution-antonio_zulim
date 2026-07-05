# solution-antonio_zulim
 
REST API backend za dohvaćanje i filtriranje proizvoda. Podaci se dohvaćaju s vanjskog izvora ([dummyjson.com](https://dummyjson.com)).
 
## Preduvjeti
 
- Java 21
- Maven 3.9+ (ili koristite `./mvnw` ako je Maven Wrapper uključen u repozitorij)
- Internetska veza (aplikacija u pozadini poziva `https://dummyjson.com`)
## Pokretanje lokalno
 
1. Klonirajte repozitorij:
```bash
   git clone <url-repozitorija>
   cd solution-antonio_zulim/backend
```
 
2. Pokrenite aplikaciju na jedan od sljedećih načina:

   **Putem IDE-a (IntelliJ IDEA, Eclipse, VS Code...):**
   - Otvorite projekt u svom IDE-u
   - Pronađite glavnu klasu aplikacije (datoteka s `@SpringBootApplication` anotacijom, npr. `AbysaltoTestApplication.java`)
   - Pokrenite je (Run/Debug gumb, ili `F5` u VS Codeu, `Shift+F10` u IntelliJ-u)

   **Putem terminala (ako imate Maven instaliran globalno):**
```bash
   mvn spring-boot:run
```
 
3. Aplikacija je dostupna na:
```
   http://localhost:8080
```
 
## Konfiguracija
 
Svi podaci o proizvodima dohvaćaju se uživo s `https://dummyjson.com` putem `ProductClient` (deklarativni HTTP klijent baziran na `RestClient`). Base URL vanjskog servisa definiran je u konfiguracijskoj klasi gdje se kreira `ProductClient` bean.
 
Nema dodatnih varijabli okoline ili `application.properties` vrijednosti koje je potrebno ručno postaviti za pokretanje projekta.
 
## Testiranje aplikacije
 
### 1. Swagger UI (preporučeno)
 
Nakon pokretanja aplikacije, otvorite:
```
http://localhost:8080/swagger-ui.html
```
Ovdje su svi endpointi dokumentirani i mogu se testirati direktno iz browsera pomoću gumba "Try it out".
 
### 2. Ručno putem curl-a
 
```bash
# Dohvatite sve proizvode
curl http://localhost:8080/products

# Dohvatite proizvod po ID-u
curl http://localhost:8080/products/1
 
# Dohvatite proizvode s filterima
curl "http://localhost:8080/products?category=beauty&minPrice=5&maxPrice=50"
 
# Pretražite proizvode po nazivu
curl "http://localhost:8080/products/search?name=mascara"
```
 
### 3. Postman / Insomnia
 
Sirovi OpenAPI opis API-ja (koji se može uvesti u Postman kao kolekcija) dostupan je na:
```
http://localhost:8080/v3/api-docs
```
 
## Endpointi
 
| Metoda | Putanja | Opis |
|--------|---------|------|
| GET | `/products/{id}` | Dohvaća proizvod po ID-u |
| GET | `/products` | Dohvaća proizvode uz opcionalne filtere (`category`, `minPrice`, `maxPrice`) |
| GET | `/products/search?name=` | Pretražuje proizvode po nazivu |
 
Detaljan opis svakog endpointa, mogućih odgovora i primjera dostupan je u Swagger UI dokumentaciji.

## Korištenje AI alata
 
Tijekom izrade dokumentacije za ovaj projekt korišteni su AI alati kao pomoć pri sljedećim zadacima:
 
- **Swagger/OpenAPI anotacije** - generiranje `@Operation`, `@ApiResponses` i `@Schema` anotacija za `ProductController` i sve DTO-ove (`ProductDto`, `ProductSummaryDto`, `ErrorResponse`, `CategoryDto`, `ProductListDto`), uključujući nested recorde (`Dimensions`, `Review`, `Meta`).
- **ProductClientConfig klasa** - generiranje sadržaja datoteke ProductClientConfig.java
- **GlobalExceptionHandler klasa** - pomoć pri oblikovanju exception handler funkcija
- **Otkrivanje i popravak bugova**
- **Stvaranje kostura README datoteke**