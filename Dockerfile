FROM maven:3.9.9-eclipse-temurin-21-alpine AS build
WORKDIR /app

COPY pom.xml .

COPY open-ai-integration ./open-ai-integration
COPY ai-service-core ./ai-service-core
COPY ai-service-controller ./ai-service-controller

RUN --mount=type=cache,target=/root/.m2 \
     mvn clean install -DskipTests -T 1C -Dmaven.javadoc.skip=true


FROM eclipse-temurin:21-jre-alpine
WORKDIR /app
COPY --from=build /app/ai-service-controller/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "./app.jar"]