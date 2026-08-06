# Etapa 1: Build con Gradle y JDK 25
FROM gradle:9.4.1-jdk25 AS build
WORKDIR /app
COPY --chown=gradle:gradle . /app
RUN gradle bootJar --no-daemon

# Etapa 2: Runtime con Amazon Corretto 25
FROM amazoncorretto:25-alpine
WORKDIR /app
COPY --from=build /app/build/libs/*.jar platziplay.jar
EXPOSE 8080
ENTRYPOINT ["java", "-Dspring.profiles.active=prod", "-jar", "Cine-1.0.0.jar"]