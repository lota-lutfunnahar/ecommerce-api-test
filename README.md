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
- **Spring Boot:** 3.3.2
- **Docker:** 24.0.7
- **Database:** PostgreSQL 14
- **IDE:** IntelliJ IDEA
- **Maven** Project

## Getting Started

### Prerequisites

- Install JDK 17
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
PostgreSQL: For structured data
MongoDB: For flexibility with unstructured or semi-structured data.

### Containerization
Docker 

### Graylog: For centralized log management.
Prometheus & Grafana: For monitoring application performance and health metrics.


### API
RESTfull API

### Testing
JUnit: For unit tests.
Mockito: For mocking dependencies in tests.
Postman: For API testing.

## API Endpoints

### Wishlist API
#### GET /api/wishlist/{customerId}
- Returns the wish list of a customer.
- Example: GET /api/wishlist/1
  
### Sales API
#### GET /api/sales/today

- Returns the total sales amount for the current day.
- Example: GET /api/sales/today

#### GET /api/sales/max

- Returns the day with the maximum sales within a specific date range.
- Parameters: startDate, endDate
- Example: GET /api/sales/max?startDate=2024-01-01&endDate=2024-07-31

#### GET /api/sales/top5/all-time

- Returns the top 5 selling items of all time based on total sales amount.
- Example: GET /api/sales/top5/all-time

#### GET /api/sales/top5/last-month

- Returns the top 5 selling items of the last month based on the number of sales.
- Example: GET /api/sales/top5/last-month

## Log management running from docker image

### Set Password Secret and Root Password

Replace somepasswordpepper with a random string for GRAYLOG_PASSWORD_SECRET. Replace <your_sha2_password> with the SHA-256 hash.


### Run Docker compose for Graylog
```
docker-compose up
```
## Docker Image for Application

### Docker Image build

```
docker build -t ecommerce-api-test .
```

### Docker Image Run
```
docker run -p 8080:8080 ecommerce-api-test
```
