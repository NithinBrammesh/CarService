# Stage 1: Build the application with Maven
FROM maven:3.9.4-eclipse-temurin-21 AS build

WORKDIR /app/CarService

COPY . .

RUN mvn clean package
# Stage 2: Create the runtime image
FROM maven:3.9.4-eclipse-temurin-21

WORKDIR /app

COPY --from=build /app/CarService/target/CarService-0.0.1-SNAPSHOT.jar application.jar

# Run the application
ENTRYPOINT ["java", "-jar", "application.jar"]
