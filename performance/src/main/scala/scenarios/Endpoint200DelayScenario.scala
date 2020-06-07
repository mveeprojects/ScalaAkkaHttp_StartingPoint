package scenarios

import io.gatling.core.Predef._
import io.gatling.core.structure.ScenarioBuilder
import io.gatling.http.Predef._
import io.gatling.http.request.builder.HttpRequestBuilder

object Endpoint200DelayScenario {
  val getRandomDelayEndpoint: HttpRequestBuilder = http("Randomdelay endpoint request")
    .get("/randomdelay")
    .check(status is 200)

  val getRandomDelayEndpointScenario: ScenarioBuilder = scenario("Randomdelay endpoint (200) scenario")
    .exec(getRandomDelayEndpoint)
}
