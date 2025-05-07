# Use a minimal Java 21 JDK base image
FROM eclipse-temurin:21-jdk-alpine

# Set working directory inside the container
WORKDIR /app

# Copy the built JAR file into the container
COPY target/authservice-0.0.1-SNAPSHOT.jar app.jar

# Define the entrypoint command
ENTRYPOINT ["java", "-jar", "app.jar"]
