package scenarios

import io.gatling.core.Predef._
import io.gatling.core.structure.ScenarioBuilder
import io.gatling.http.Predef._
import io.gatling.http.request.builder.HttpRequestBuilder

object Endpoint404Scenario {
  val getNonExistentEndpoint: HttpRequestBuilder = http("Nonexistent endpoint request")
    .get("/nonexistentendpoint")
    .check(status is 404)

  val getNonExistentEndpointScenario: ScenarioBuilder = scenario("Nonexistent endpoint (404) scenario")
    .exec(getNonExistentEndpoint)
}
