

FROM openjdk:8
ADD target/docker-service-discovery.jar docker-service-discovery.jar
EXPOSE 8761
ENTRYPOINT ["java", "-jar", "docker-service-discovery.jar"]