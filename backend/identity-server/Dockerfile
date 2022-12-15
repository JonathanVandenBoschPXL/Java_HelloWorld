FROM amazoncorretto:17-alpine-jdk
COPY ./identity-server-0.0.1-SNAPSHOT.jar identity-server-0.0.1-SNAPSHOT.jar
EXPOSE 8888
ENTRYPOINT ["java","-jar",'/identity-server-0.0.1-SNAPSHOT.jar']