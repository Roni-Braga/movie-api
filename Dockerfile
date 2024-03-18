FROM ubuntu:latest AS build

RUN apt-get update
RUN apt-get install openjdk-17-jdk -y
COPY . .

RUN apt-get install maven-4.0 -y
RUN mvn -version
RUN mvn clean install

FROM openjdk:17-jdk-slim 

EXPOSE 8080

COPY --from=build /target/api-0.0.1-SNAPSHOT.jar movie.jar

ENTRYPOINT [ "java","-jar","movie.jar" ]