FROM openjdk:17-alpine
COPY target/HelloWorld-0.0.1-SNAPSHOT.jar HelloWorld.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","HelloWorld.jar"]
