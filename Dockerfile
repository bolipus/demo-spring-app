# Copy angular build from separate build stage
FROM node:18-alpine as frontend-angular
WORKDIR /app
COPY ./src/webapp .
RUN npm install && npm run build --production

FROM maven:3.8-openjdk-17-slim as build-spring
WORKDIR /app
COPY ./pom.xml .
COPY ./src ./src
COPY --from=frontend-angular /app/dist/demo-client ./src/main/resources/static
RUN mvn clean package -DskipTests

FROM openjdk:17-alpine
COPY --from=build-spring /app/target/*.jar app.jar
EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app.jar"]
