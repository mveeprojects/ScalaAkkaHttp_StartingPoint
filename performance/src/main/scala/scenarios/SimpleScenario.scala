package scenarios

import io.gatling.core.Predef._
import io.gatling.core.structure.ScenarioBuilder
import io.gatling.http.Predef._
import io.gatling.http.request.builder.HttpRequestBuilder

object SimpleScenario {
  val getHelloWorldEndpoint: HttpRequestBuilder = http("Hello world endpoint check")
    .get("/")
    .check(status is 200)

  val getHomeEndpoint: ScenarioBuilder = scenario("Checking root url returns OK under load")
    .exec(getHelloWorldEndpoint)
}
