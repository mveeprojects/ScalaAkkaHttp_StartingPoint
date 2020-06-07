package scenarios

import io.gatling.core.Predef._
import io.gatling.core.structure.ScenarioBuilder
import io.gatling.http.Predef._
import io.gatling.http.request.builder.HttpRequestBuilder

object Endpoint200Scenario {
  val getHelloWorldEndpoint: HttpRequestBuilder = http("Root endpoint request")
    .get("/")
    .check(status is 200)

  val getHomeEndpointScenario: ScenarioBuilder = scenario("Root endpoint (200) scenario")
    .exec(getHelloWorldEndpoint)
}
