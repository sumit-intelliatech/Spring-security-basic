# Use a base image with Java pre-installed
FROM openjdk:17

# Expose the port your Spring Boot application will listen on
EXPOSE 8080

# Create a directory in the container
RUN mkdir /app

# Copy the JAR file from the local 'target' directory to the container

ADD target/basicsecurity-0.0.1-SNAPSHOT.jar app.jar

# Define the command to run your Spring Boot application when the container starts
CMD ["java", "-jar", "app.jar"]