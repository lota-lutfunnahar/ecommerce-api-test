FROM openjdk:17-jdk-alpine
MAINTAINER java-service.com
COPY target/ecommerce-api-0.0.1-SNAPSHOT.jar ecommerce-api-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/ecommerce-api-0.0.1-SNAPSHOT.jar"]
