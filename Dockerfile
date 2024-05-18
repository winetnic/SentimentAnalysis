FROM openjdk:21-jdk-slim

# Set working directory
WORKDIR /usr/src/app

# Copy project files
COPY . .

# Run Maven build
RUN ./mvnw -Dmaven.test.skip=true package

# Expose port
EXPOSE 8080

# Command to run the application
CMD ["java", "-jar", "/usr/src/app/target/playground-0.0.1-SNAPSHOT.jar"]
