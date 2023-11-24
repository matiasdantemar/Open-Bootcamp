FROM openjdk:17-jdk
ARG JAR_FILE=target/*.jar
COPY target/ob-spring-security-jwt-0.0.1.jar spring-deploy.jar
ENTRYPOINT ["java","-jar","/spring-deploy.jar"]