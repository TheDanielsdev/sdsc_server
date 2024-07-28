FROM eclipse-temurin:17-jdk-alpine
VOLUME /tmp
COPY target/segundaniels-0.0.1-SNAPSHOT.jar segundaniels.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/segundaniels.jar"]