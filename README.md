# ScalaAkkaHttp_StartingPoint

This codebase is designed as a simple starting point for an Akka HTTP application.

## Modules:

### Api

A simple HTTP API that can be easily extended.

### Performance

Basic performance tests written using Gatling to provide a basic level of traffic and therefore sample metrics.

## Prerequisites

### Docker (inc. docker-compose)

Install this by following [the documentation on the Docker website](https://docs.docker.com/engine/install/)

### SBT

If you're using a Unix OS (MacOS/Linux), I have included a `sbtw` file under the `bin` directory at the root of this
project so you can just replace the usage of `sbt` with `./bin/sbtw` where necessary.

If you're using Windows or would prefer to download sbt regardless,
follow [the documentation on the official SBT website](https://www.scala-sbt.org/1.x/docs/Setup.html)

## Creating and running the API with monitoring containers

### Building and running the API and Performance modules along with monitoring containers

`coldstart.sh` has been added to the root of this project to easily complete the following steps on your behalf:

* clean down any API, Performance or Monitoring containers using docker-compose
* build fat JARs of both API and Performance modules
* build docker images of both API and Performance modules
* run the API, Performance and Monitoring containers using docker-compose
    * this automatically triggers the performance tests therefore generating traffic on the API, resulting in metrics
      available to our Monitoring containers immediately!

When you're finished, run the below command from the root of the project to stop the API, Performance and Monitoring
containers

`docker-compose -f ./docker/docker-compose.yml down`

### Endpoints

[API "Hello, World!" endpoint (...:8080/)](http://localhost:8080)

[API metrics endpoint (...:9095/)](http://localhost:9095)

[Prometheus (...:9090/)](http://localhost:9090)

[Grafana (...:3000/)](http://localhost:3000)

### Auth path cURL requests

cURL with Basic (base64) auth -> `curl -v --user name:password localhost:8080/authpath`

### Very basic PromQL queries for use in Grafana

Show the rate of 2xx responses per minute `rate(http_server_requests_total{http_status_code="2xx"}[1m])`

Show the rate of 4xx responses per minute `rate(http_server_requests_total{http_status_code="4xx"}[1m])`

Show the rates all status codes together `sum(rate(http_server_requests_total[1m])) by (http_status_code)`

Show the percentage of all responses that were 404s per
minute `(sum(rate(http_server_requests_total{http_status_code="4xx"}[1m])) / sum(rate(http_server_requests_total[1m]))) * 100`

### References/Sources

* https://dzone.com/articles/dockerizing-your-scala-app
* https://www.scala-sbt.org/1.x/docs/Multi-Project.html
* https://stackoverflow.com/a/58024050/3059314
* https://timber.io/blog/promql-for-humans/
* https://www.youtube.com/watch?v=hTjHuoWxsks (PromCon EU 2019: PromQL for Mere Mortals)
* https://www.youtube.com/watch?v=PDxcEzu62jk (Monitoring, the Prometheus Way)
* https://www.youtube.com/watch?v=nJMRmhbY5hY (Around 9m 30s for histogram quantile prometheus queries)
* https://www.youtube.com/watch?v=_nZSrY784sY (Good explanation of rate())
* https://www.youtube.com/watch?v=6oSlgW6EKK4 (Grafana Prometheus with Heat Maps | Grafana Heatmap Histograms)
* https://doc.akka.io/docs/akka-http/current/routing-dsl/source-streaming-support.html (Akka HTTP Source Streaming)
* https://github.com/akka/akka-http/blob/master/akka-http-tests/src/test/scala/akka/http/scaladsl/server/EntityStreamingSpec.scala (Akka HTTP Source Streaming raw code)

