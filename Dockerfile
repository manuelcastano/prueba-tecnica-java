FROM openjdk:21-jdk

COPY javademo.json /javademo.json

ENV GOOGLE_APPLICATION_CREDENTIALS=/javademo.json

COPY build/libs/java-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-jar", "/app.jar"]