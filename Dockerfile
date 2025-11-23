FROM eclipse-temurin:21-jdk

WORKDIR /app

# copy the built jar from target folder into the image as app.jar
COPY target/*.jar app.jar

# this must match your Spring Boot server.port
EXPOSE 8090

ENTRYPOINT ["java", "-jar", "app.jar"]
