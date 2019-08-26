FROM maven:3.6-jdk-8-alpine as build
ADD ./ app/
WORKDIR /app
RUN mvn clean install

FROM openjdk:8-jdk-alpine
COPY --from=build /app/target/order-management-service-0.0.1-SNAPSHOT.jar order-management-service.jar
EXPOSE 8081
ENTRYPOINT ["java","-jar","order-management-service.jar"]