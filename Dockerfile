#
# Build stage
#
FROM maven:3.8.5-openjdk-8-slim AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -B package -e -X --file /home/app/pom.xml

#
# Package stage
#
FROM openjdk:8-jre-alpine
COPY --from=build /home/app/target/SpringBootCalc-0.0.1-SNAPSHOT.jar /usr/local/lib/SpringBootCalc.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/usr/local/lib/SpringBootCalc.jar"]
