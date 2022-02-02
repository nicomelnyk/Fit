# Carrito

Api encargada de gestionar los carritos de compras

## Tecnologia
Java 11

## Servicios
- Acceder a la url http://localhost:8081/carrito/swagger-ui/index.html?configUrl=/carrito/fit/swagger.html/swagger-config#/
para ver la documentacion de los servicios, se muestra cada url con los objetos que recibe y devuelve
- Carrito -> url.compras=http://localhost:8080/compras

### Configuración del Ambiente

### Configuracion de la app
server.port=8081
server.servlet.contextPath=/carrito

## Base de Datos
Base de datos:

spring.datasource.url=jdbc:mysql://MYSQL5047.site4now.net:3306/db_a82464_fit?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrival=true
spring.datasource.username=a82464_fit
spring.datasource.password=Password01
spring.datasource.testWhileIdle=true
spring.datasource.validationQuery=SELECT 1
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.database-platform=org.hibernate.dialect.MySQL8Dialect

Para comunicarse con la base de datos se utiliza el framework JPA
