# Start with a base image containing Java runtime
FROM openjdk:8-jdk-alpine

# Add Maintainer Info
# LABEL maintainer="sanchi.goyal.sg@gmail.com"

# Add a volume pointing to /tmp
# VOLUME /tmp

# Make port 8080 available to the world outside this container
EXPOSE 8080

# The application's jar file
ARG JAR_FILE=./build/libs/data-api-stable-1.0.0.jar

# Add the application's jar to the container
ADD ${JAR_FILE} data-api-stable.jar

# Run the jar file
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/data-api-stable.jar"]

# run with:
# sudo docker build -f Dockerfile -t data-api:latest .
# sudo docker run -p 8086:8080 data-api -d
# sudo docker-compose up --scale data-api=5