FROM openjdk:8
COPY target/*.jar hysterix-dashboard-service.jar
EXPOSE 9010
ENTRYPOINT ["java", "-jar", "hysterix-dashboard-service.jar"]
