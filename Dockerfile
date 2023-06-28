FROM openjdk:17-alpine
ARG JAR_FILE=*.jar
COPY ./target/${JAR_FILE} application.jar
ENTRYPOINT ["java", "-jar", "application.jar"]