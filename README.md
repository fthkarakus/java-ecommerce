# Java Spring E-commerce API

Bu proje, Java Spring ile geliştirilmiş bir e-commerce API'sini içerir. Bu API, ürün yönetimi, kullanıcı yönetimi, sipariş işleme ve daha fazlasını destekler.

## Başlangıç

Projeyi yerel ortamınızda çalıştırmak için aşağıdaki adımları izleyin:

```bash
# Proje bağımlılıklarını yükleme
mvn clean install

# Uygulamayı başlatma
mvn spring-boot:run

```
## Kullanım

API'yi kullanmak için aşağıdaki temel API çağrılarına örnekler:

- Kategori ekleme : POST /category/create
- Kategori Listeleme : GET /category/list
- Kategori güncelelem : POST /category/update/{categoryID}
- Ürün ekleme: POST /product/add
- Ürünleri listeleme: GET /product/list
- Ürün güncelleme : POST /product/update/{productId}
- Kullanıcı oluşturma: POST /user/signup 
- Kullanıcı girişi: POST /user/signin

Daha fazla API çağrısı ve parametreleri için http://projetname/swagger-ui/index.html#/ göz atın.

## Bağımlılıklar

Proje, aşağıdaki bağımlılıkları içerir:

- **javax.servlet:javax.servlet-api:3.1.0:** Servlet API'sini içerir.
- **com.mysql:mysql-connector-j:8.0.31:** MySQL veritabanı bağlantısı için kullanılır.
- **org.springframework.boot:spring-boot-starter-data-jpa:** Spring Data JPA için gerekli bağımlılıkları içerir.
- **org.springframework.boot:spring-boot-starter-web:** Spring Boot web uygulama geliştirmek için gerekli bağımlılıkları içerir.
- **org.springframework.boot:spring-boot-starter-test:** Testler için Spring Boot bağımlılığıdır.
- **jakarta.validation:jakarta.validation-api:3.0.2:** Jakarta Validation API'sini içerir.
- **io.springfox:springfox-bean-validators:3.0.0:** Springfox ile birlikte kullanılan Bean Validatörlerini içerir.
- **io.springfox:springfox-swagger2:3.0.0:** Swagger 2 ile belgeleri otomatik olarak oluşturmak için kullanılır.
- **org.springdoc:springdoc-openapi-starter-webmvc-ui:2.0.2:** OpenAPI belgelerini görüntülemek için kullanılır.

Bu bağımlılıklar, projenin temel işlevselliğini destekler ve farklı alanlarda kullanılabilecek çeşitli özellikleri ekler.

## Veritabanı Konfigürasyonu

Bu projede MySQL veritabanı kullanılmaktadır. Veritabanı bağlantı ayarları için application.properties dosyasını düzenleyebilirsiniz.


## Katmanlar ve Paketleme

Bu proje, MVC (Model-View-Controller) tasarım deseni kullanılarak organize edilmiştir. Bazı paketleme yapıları şunlardır:

com.fatihkarakus.ecommerce.controller: API kontrolleri
com.fatihkarakus.ecommerce.service: İş mantığı hizmetleri
com.fatihkarakus.ecommerce.repository: Veritabanı erişimi için repository sınıfları
com.fatihkarakus.ecommerce.model: Veritabanı tabloları, diğer veri yapıları

## Katkıda Bulunma

Bu projeyi fork edin.
Yeni bir özellik ekleyin veya hata düzeltin.
Değişikliklerinizi bir branch'te yapın: git checkout -b yeni-ozellik
Değişikliklerinizi commit edin: git commit -m 'Yeni özellik eklendi'
Değişikliklerinizi kendi fork'unuza gönderin: git push origin yeni-ozellik
Bir Pull Request gönderin.

## Lisans

Bu proje MIT lisansı altında dağıtılmaktadır.


## Java Spring E-commerce API

This project contains an e-commerce API developed using Java Spring. This API supports product management, user management, order processing, and more.

## Getting Started

To run the project locally, follow the steps below:

```bash
Copy code
# Install project dependencies
mvn clean install


# Run the application
mvn spring-boot:run
```
## Usage

To use the API, here are some example API calls:

- Add a Category: POST /category/create 
- List Categories: GET /category/list 
- Update a Category: POST /category/update/{categoryID} 
- Add a Product: POST /product/add 
- List Products: GET /product/list 
- Update a Product: POST /product/update/{productId} 
- Create a User: POST /user/signup 
- User Login: POST /user/signin

For more API calls and parameters, check out http://projetname/swagger-ui/index.html#/.

## Dependencies

The project includes the following dependencies:

- javax.servlet:javax.servlet-api:3.1.0: Contains the Servlet API. 
- com.mysql:mysql-connector-j:8.0.31: Used for MySQL database connectivity. 
- org.springframework.boot:spring-boot-starter-data-jpa: Includes necessary dependencies for Spring Data JPA. 
- org.springframework.boot:spring-boot-starter-web: Includes necessary dependencies for developing Spring Boot web applications. 
- org.springframework.boot:spring-boot-starter-test: Dependency for testing with Spring Boot. 
- jakarta.validation:jakarta.validation-api:3.0.2: Includes the Jakarta Validation API. 
- io.springfox:springfox-bean-validators:3.0.0: Includes Bean Validators used with Springfox. 
- io.springfox:springfox-swagger2:3.0.0: Used for automatically generating Swagger 2 documentation. 
- org.springdoc:springdoc-openapi-starter-webmvc-ui:2.0.2: Used for viewing OpenAPI documentation.

These dependencies support the core functionality of the project and add various features that can be used in different areas.

## Database Configuration

This project uses MySQL as the database. You can edit the database connection settings in the application.properties file.

## Layers and Packaging

This project is organized using the MVC (Model-View-Controller) design pattern. Some of the packaging structures are as follows:

- com.fatihkarakus.ecommerce.controller: API controllers 
- com.fatihkarakus.ecommerce.service: Business logic services 
- com.fatihkarakus.ecommerce.repository: Repository classes for database access 
- com.fatihkarakus.ecommerce.model: Database tables and other data structures

## Contribution

- Fork this project. 
- Add new features or fix bugs. 
- Make your changes in a branch: git checkout -b new-feature 
- Commit your changes: git commit -m 'Added new feature' 
- Push your changes to your fork: git push origin new-feature 
- Submit a Pull Request.
## License

This project is distributed under the MIT license.