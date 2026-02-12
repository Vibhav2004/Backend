FROM openjdk:17-jdk-alpine

WORKDIR /app

COPY target/swipenow-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8081

CMD ["java", "-jar", "app.jar"]
