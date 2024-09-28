FROM maven:3.6.3-openjdk-17-slim AS build 
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:17.0.1-jdk-slim

COPY --form=build /target/pharmacy-service-0.0.1-SNAPSHOT.jar  pharmacy-service.jar
EXPOSE 8080
ENTRYPOINT ["jva","-jar", "pharmacy-service.jar"]