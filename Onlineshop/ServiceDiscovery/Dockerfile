FROM openjdk:8
COPY target/*.jar docker-service-discovery.jar
EXPOSE 8761
ENTRYPOINT ["java", "-jar", "docker-service-discovery.jar"]