# multi-stage build: build with maven then run jar
FROM maven:3.6.3-jdk-8 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn -B -DskipTests package

FROM openjdk:8-jre-alpine
WORKDIR /app
COPY --from=build /app/target/gdpr-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app/app.jar"]
