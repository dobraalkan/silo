# Build the application
FROM maven:3.9.9-eclipse-temurin-21 AS build

# Copy the application source code
COPY pom.xml .
COPY src ./src

# Set working directory in container
# WORKDIR /src

# download dependencies
RUN mvn install

# Build the application
RUN mvn package -DskipTests

# Stage 2: Run the application
FROM openjdk:21-jdk-slim

# Copy the packaged jar file from the build stage
COPY --from=build target/query-0.0.1-SNAPSHOT.jar query.jar

# Expose application port
# EXPOSE 7860
EXPOSE 3000

##CMD ["./docker/dev.start.sh"]

# Run the application
ENTRYPOINT ["java", "-jar", "query.jar"]