FROM openjdk:23-jdk

ARG app-dir=/app

# arg port is using the command line to set the port ..what if its -e?
ARG port=4000

WORKDIR ${app-dir}

COPY pom.xml .
COPY .mvn .mvn
COPY src src
COPY mvnw .
COPY mvnw.cmd .

RUN ./mvnw clean package -Dmaven.test.skip=true

ENV SERVER_PORT 4000

EXPOSE ${SERVER_PORT}

#ENTRYPOINT java -jar target/vttp5a-ssf-day15L-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "target/vttp5a-ssf-day15L-0.0.1-SNAPSHOT.jar"]