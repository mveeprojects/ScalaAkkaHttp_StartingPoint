FROM openjdk:8-jre-alpine

COPY target/scala-**/performance-assembly-0.1.0-SNAPSHOT.jar performance.jar

ENTRYPOINT ["java", "-jar", "performance.jar"]