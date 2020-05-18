FROM openjdk:8-jre-alpine

COPY target/scala-**/starting-point-app-assembly-0.1.0-SNAPSHOT.jar app.jar
COPY bin/kanela-agent-1.0.5.jar kanela.jar

ENTRYPOINT ["java", "-javaagent:kanela.jar", "-jar","app.jar"]