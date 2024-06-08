FROM openjdk:11-jre-slim
COPY target/loan_service-0.0.1-SNAPSHOT.jar loan_service.jar
CMD ["java", "-jar", "loan_service.jar"]
EXPOSE 8081
