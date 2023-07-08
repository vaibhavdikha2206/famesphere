FROM openjdk:8
COPY f2amesphere-0.0.1-SNAPSHOT f2amesphere-0.0.1-SNAPSHOT
ENTRYPOINT ["java","-jar","f2amesphere-0.0.1-SNAPSHOT.jar"]
