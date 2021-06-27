FROM openjdk:8-jdk-alpine
EXPOSE 8000
ARG JAR_FILE=./build/libs/gateway-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} gateway.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/gateway.jar"]

# run with:
# sudo docker build -f Dockerfile -t gateway:latest .
# sudo docker run -p 8086:8080 gateway -d
# sudo docker-compose up