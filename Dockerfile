FROM openjdk:8
COPY f2amesphere-0.0.1-SNAPSHOT.jar f2amesphere-0.0.1-SNAPSHOT.jar
COPY famesphere_profile.sql /tmp/famesphere_profile.sql
CMD [ "mysqld", "--init-file=/tmp/famesphere_profile.sql" ]
ENTRYPOINT ["java","-jar","f2amesphere-0.0.1-SNAPSHOT.jar"]
