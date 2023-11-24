FROM openjdk:8-jdk
ARG JAR_FILE=target/*.jar
COPY target/ob-spring-security-jwt-0.0.1.jar ob-spring-security-jwt.jar
ENTRYPOINT ["java","-jar","/ob-spring-security-jwt.jar"]