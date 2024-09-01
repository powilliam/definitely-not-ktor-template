FROM gradle:latest AS build
COPY --chown=gradle:gradle . /home/gradle
WORKDIR /home/gradle
RUN gradle buildFatJar --no-daemon

FROM openjdk:21
EXPOSE 8080:8080
COPY --from=build /home/gradle/build/libs/*.jar /app/app.jar
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
