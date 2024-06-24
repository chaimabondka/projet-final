FROM openjdk:8
EXPOSE 8081
ADD /target/customerService-0.0.1-SNAPSHOT.jar customerservice.jar
ENTRYPOINT ["java", "-jar", "customerservice.jar"]