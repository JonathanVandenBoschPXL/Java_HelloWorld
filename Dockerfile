FROM openjdk:17-alpine
COPY target/HelloWorld-0.0.1-SNAPSHOT.jar HelloWorld-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/HelloWorld-0.0.1-SNAPSHOT.jar"]
