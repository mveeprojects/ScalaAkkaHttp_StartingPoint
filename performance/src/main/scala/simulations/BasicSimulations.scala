package simulations

import config.PerformanceConfig
import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.http.protocol.HttpProtocolBuilder
import scenarios._

import scala.concurrent.duration._
import scala.language.postfixOps

class BasicSimulations extends Simulation with PerformanceConfig {

  val httpConf: HttpProtocolBuilder = http.baseUrl(s"http://$host:$port")
  val varianceOf4xx                 = 4

  val basicEndpointCheckScenarios = List(
    Endpoint200Scenario.getHomeEndpointScenario.inject(
      atOnceUsers(12),
      rampUsersPerSec(rampUpUsersPerSec) to numberOfUsers during (rampUpDuration seconds)
    ),
    Endpoint404Scenario.getNonExistentEndpointScenario.inject(
      atOnceUsers(3),
      rampUsersPerSec(
        rampUpUsersPerSec / varianceOf4xx
      ) to numberOfUsers / varianceOf4xx during (rampUpDuration seconds)
    ),
    Endpoint200DelayScenario.getRandomDelayEndpointScenario.inject(
      atOnceUsers(10),
      rampUsersPerSec(rampUpUsersPerSec) to numberOfUsers during (rampUpDuration seconds)
    )
  )

  setUp(basicEndpointCheckScenarios)
    .protocols(httpConf)
    .maxDuration(1 minutes)
    .assertions(
      global.responseTime.max.lt(maxResponseTime)
    )
}
