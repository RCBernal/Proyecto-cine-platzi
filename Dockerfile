#Etapa 1 Build con gradle  (compilacion)
FROM gradle:9.4.1-jdk25 AS build
COPY --chown=gradle:gradle . /app
WORKDIR /app
RUN gradle bootjar --no-daemmon

#Etapa 2Runtime con jdk 25 (Ejecucion)
FROM amazoncorretto:25-alpine
WORKDIR /app
COPY --from=build /app/build/libs/*.jar platzi_play.jar
EXPOSE 8080
ENTRYPOINT ["java", "-Dspring.profiles.active=prod", "-jar", "Cine-1.0.0.jar"]