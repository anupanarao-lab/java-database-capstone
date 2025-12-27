# -------------------- BUILD STAGE --------------------
FROM maven:3.9.6-eclipse-temurin-17 AS build

WORKDIR /app

# Copy pom.xml and download dependencies (better layer caching)
COPY app/pom.xml .
RUN mvn dependency:go-offline

# Copy source code and build the application
COPY app/src ./src
RUN mvn clean package -DskipTests


# -------------------- RUNTIME STAGE --------------------
FROM eclipse-temurin:17-jre-alpine

WORKDIR /app

# Copy only the built JAR from the build stage
COPY --from=build /app/target/*.jar app.jar

# Expose application port
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
