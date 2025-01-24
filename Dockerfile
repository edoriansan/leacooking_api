FROM openjdk:21-jdk

COPY target/LeaCooking-0.0.1-SNAPSHOT.jar /app/LeaCooking-0.0.1-SNAPSHOT.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app/LeaCooking-0.0.1-SNAPSHOT.jar"]
