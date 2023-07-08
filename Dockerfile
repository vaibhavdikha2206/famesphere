FROM openjdk:8
COPY target/famesphere-0.0.1-SNAPSHOT.jar famesphere-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","famesphere-0.0.1-SNAPSHOT.jar"]
