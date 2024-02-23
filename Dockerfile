FROM amazoncorretto:17-alpine-jdk

COPY target/aprendiendo-0.0.1-SNAPSHOT.jar app.war

ENTRYPOINT ["java","-jar","/app.war"]