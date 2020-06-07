# ScalaAkkaHttp_StartingPoint

This codebase is designed as a simple starting point for an Akka HTTP application.

## Modules:

### Api

A simple HTTP API that can be easily extended.

### Performance

Basic performance tests written using Gatling to provide a basic level of traffic and therefore sample metrics.

## Creating and running the API with monitoring containers

### Creating a JAR and Docker image of the API and Performance modules

Create fat JARs for dockerising `sbt clean assembly` (if using a Unix OS and you do not have sbt installed on your machine you can replace `sbt` with `./bin/sbtw`)

Build API docker image `docker build ./api -t api`

Build Performance docker image `docker build ./performance -t performance-tests-api`

### Running the API with monitoring (Prometheus and Grafana)

_**Note:**_ Make sure you've built the api and performance docker images as shown in the section above, and you are in the root of the project before running these commands.
 
`docker-compose -f ./docker/docker-compose.yml up -d`

To stop the containers when finished, run the above commands replacing the suffix `up -d` with `down`

### Endpoints

[API "Hello, World!" endpoint](http://localhost:8080)

[API metrics endpoint](http://localhost:9095)

[Prometheus](http://localhost:9090)

[Grafana](http://localhost:3000)

### Very basic PromQL queries for use in Grafana

Show increase in 2xx responses over the last 10 minutes `increase(http_server_requests_total{http_status_code="2xx"}[1m])`

Show increase in 4xx responses over the last 10 minutes `increase(http_server_requests_total{http_status_code="4xx"}[1m])`

### Sources

* https://dzone.com/articles/dockerizing-your-scala-app
* https://www.scala-sbt.org/1.x/docs/Multi-Project.html
* https://stackoverflow.com/a/58024050/3059314
* https://timber.io/blog/promql-for-humans/