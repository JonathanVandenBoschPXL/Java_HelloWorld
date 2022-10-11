FROM amazoncorretto:17-alpine-jdk
COPY ./backend/target/HelloWorld-0.0.1-SNAPSHOT.jar HelloWorld-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/HelloWorld-0.0.1-SNAPSHOT.jar"]
