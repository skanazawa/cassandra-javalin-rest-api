FROM openjdk:11 AS build
WORKDIR /app
COPY . .
RUN ./gradlew clean build
RUN echo $(ls -la .)

FROM openjdk:17

COPY --from=build /app/build/libs/cassandra-javalin-rest-api-1.0.0.jar /app.jar

ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/app.jar"]