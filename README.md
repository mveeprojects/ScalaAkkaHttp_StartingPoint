# ScalaAkkaHttp_StartingPoint

This codebase is designed as a simple starting point for an Akka HTTP application.

### Modules:

#### Api

A simple HTTP API that can be easily extended.

#### Performance

Basic performance tests written using Gatling.

### Useful commands

Create a fat JAR for dockerising `sbt clean assembly`

Build API docker image `cd api` then `docker build . -t starting-point-api`

Run API docker image `docker run -d -p8080:8080 --name api starting-point-api`

### Sources:
* https://dzone.com/articles/dockerizing-your-scala-app
* https://www.scala-sbt.org/1.x/docs/Multi-Project.html
* https://stackoverflow.com/a/58024050/3059314