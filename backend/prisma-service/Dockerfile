FROM amazoncorretto:17-alpine-jdk
COPY ./prisma-service-0.0.1-SNAPSHOT.jar prisma-service-0.0.1-SNAPSHOT.jar
COPY ./dd-java-agent.jar dd-java-agent.jar
EXPOSE 7000
ENTRYPOINT ["java","-javaagent:/dd-java-agent.jar","-jar","/prisma-service-0.0.1-SNAPSHOT.jar"]