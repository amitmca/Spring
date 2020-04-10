FROM openjdk:8-jdk-alpine
EXPOSE 8085
ADD spring-boot-project1.jar .
ADD spring-boot-project2.jar .
ENTRYPOINT ["java","-jar","spring-boot-project1.jar"]
ENTRYPOINT ["java","-jar","spring-boot-project2.jar"]

