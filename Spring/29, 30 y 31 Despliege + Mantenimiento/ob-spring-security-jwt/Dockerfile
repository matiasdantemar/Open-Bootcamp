FROM openjdk:17-jdk
ARG JAR_FILE=target/*.jar
COPY target/spring-deploy-1.0.jar spring-deploy.jar
ENTRYPOINT ["java","-jar","/spring-deploy.jar"]