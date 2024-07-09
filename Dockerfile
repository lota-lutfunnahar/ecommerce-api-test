FROM openjdk:17-jdk-alpine
MAINTAINER java-service.com
COPY jar/ecommerce-api-1.0.0.jar ecommerce-api-1.0.0.jar
ENTRYPOINT ["java","-jar","/ecommerce-api-1.0.0.jar"]
