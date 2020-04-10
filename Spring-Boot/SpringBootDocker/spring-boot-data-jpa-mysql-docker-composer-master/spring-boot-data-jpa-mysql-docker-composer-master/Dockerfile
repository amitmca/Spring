FROM openjdk:8-jdk-alpine
FROM maven:alpine
WORKDIR /app
COPY . /app
EXPOSE 8085
ADD ./target/spring-boot-data-jpa-example-0.0.1-SNAPSHOT.jar spring-boot-data-jpa-example-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","spring-boot-data-jpa-example-0.0.1-SNAPSHOT.jar"]