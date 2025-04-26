FROM eclipse-temurin:21-jdk-alpine
MAINTAINER dramzlancer.com
COPY target/*jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]