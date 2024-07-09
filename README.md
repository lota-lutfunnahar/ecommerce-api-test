# E-commerce API

This is a Spring Boot-based RESTful API for an e-commerce application. The API provides endpoints for managing wish lists, sales data, and retrieving top-selling items. It follows the Test-Driven Development (TDD) approach.

## Features

- **Wishlist API**
    - Retrieve the wish list of a customer.

- **Sales API**
    - Retrieve the total sales amount for the current day.
    - Retrieve the day with the maximum sales within a specific date range.
    - Retrieve the top 5 selling items of all time based on total sales amount.
    - Retrieve the top 5 selling items of the last month based on the number of sales.

## Requirements

- **Java Development Kit (JDK):** 21 or 17
- **Spring Boot:** 3.2.2
- **Docker:** Latest version
- **Database:** PostgreSQL (or any open-source database of your choice)
- **IDE:** Any (IntelliJ IDEA, Eclipse, VSCode, etc.)

## Getting Started

### Prerequisites

- Install JDK 21 or JDK 17
- Install Docker
- Install PostgreSQL

### Prerequisites

Ensure your PostgreSQL server is running and create a database for the project:
```
CREATE DATABASE postgres;
```
### Set up application properties:

Edit src/main/resources/application.properties and configure the database connection:
```
spring.datasource.url=jdbc:postgresql://localhost:5432/postgres
spring.datasource.username=yourusername
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=none

spring.flyway.enabled=true
spring.flyway.baseline-on-migrate=true
spring.flyway.locations=classpath:db/migration

```
### Running the Application
```
mvn spring-boot:run

```


## Architecture
### Microservices
Each API endpoint is managed by a separate microservice, allowing for independent deployment and scaling.

### API Gateway
Spring Cloud Gateway: Manages API requests, routing, and authentication.
### Database
PostgreSQL: For structured data and ACID compliance.
MongoDB: For flexibility with unstructured or semi-structured data.

### Containerization
Docker 

### Graylog: For centralized log management.
Prometheus & Grafana: For monitoring application performance and health metrics.


### API
RESTFull API

### Testing
JUnit: For unit tests.
Mockito: For mocking dependencies in tests.
Postman: For API testing.
