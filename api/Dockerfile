FROM openjdk:8-jre-alpine

COPY target/scala-**/api-assembly-0.1.0-SNAPSHOT.jar api.jar
COPY bin/kanela-agent-1.0.5.jar kanela.jar

RUN apk add eudev

ENTRYPOINT ["java", "-javaagent:kanela.jar", "-jar", "api.jar"]