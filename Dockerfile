FROM openjdk:17-alpine
WORKDIR /app
COPY target/HelloWorld-0.0.1-SNAPSHOT.jar /app/HelloWorld.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","HelloWorld.jar"]
