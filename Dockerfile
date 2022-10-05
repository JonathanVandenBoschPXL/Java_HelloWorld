FROM openjdk:17-alpine
COPY target/**.jar test.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/test.jar"]
