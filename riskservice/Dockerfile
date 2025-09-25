# Use Maven image to build the JAR
FROM maven:3.9.5-eclipse-temurin-17 AS build

WORKDIR /app

# Copy pom.xml and source code
COPY pom.xml .
COPY src ./src

# Build the project
RUN mvn clean package -DskipTests

# Use a slim JRE image to run the JAR
FROM eclipse-temurin:17-jre

WORKDIR /app

# Copy the JAR from the build stage
COPY --from=build /app/target/riskservice-0.0.1-SNAPSHOT.jar ./riskservice.jar

# Run the JAR
ENTRYPOINT ["java", "-jar", "riskservice.jar"]
