FROM openjdk:8
COPY f2amesphere-0.0.1-SNAPSHOT.jar f2amesphere-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","f2amesphere-0.0.1-SNAPSHOT.jar"]
