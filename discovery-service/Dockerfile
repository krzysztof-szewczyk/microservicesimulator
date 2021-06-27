# Start with a base image containing Java runtime
FROM openjdk:8-jdk-alpine

# Add Maintainer Info
# LABEL maintainer="sanchi.goyal.sg@gmail.com"

# Add a volume pointing to /tmp
# VOLUME /tmp

# Make port 8080 available to the world outside this container
EXPOSE 8761

# The application's jar file
ARG JAR_FILE=./build/libs/discovery-service-0.0.1-SNAPSHOT.jar

# Add the application's jar to the container
ADD ${JAR_FILE} discovery-service.jar

# Run the jar file
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/discovery-service.jar"]

# run with:
# sudo docker build -f Dockerfile -t discovery:latest .
# sudo docker run -p 8086:8080 discovery -d