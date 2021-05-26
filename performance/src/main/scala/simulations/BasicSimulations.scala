package simulations

import config.PerformanceConfig.perfTestConfig._
import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.http.protocol.HttpProtocolBuilder
import scenarios._

import scala.concurrent.duration._
import scala.language.postfixOps

class BasicSimulations extends Simulation {

  val httpConf: HttpProtocolBuilder = http.baseUrl(s"http://${app.host}:${app.port}")
  val varianceOf4xx                 = 4

  val basicEndpointCheckScenarios = List(
    Endpoint200Scenario.getHomeEndpointScenario.inject(
      atOnceUsers(12),
      rampUsersPerSec(gatling.rampUpUsersPerSec) to gatling.numberOfUsers during (gatling.rampUpDuration seconds)
    ),
    Endpoint404Scenario.getNonExistentEndpointScenario.inject(
      atOnceUsers(3),
      rampUsersPerSec(
        gatling.rampUpUsersPerSec / varianceOf4xx
      ) to gatling.numberOfUsers / varianceOf4xx during (gatling.rampUpDuration seconds)
    ),
    Endpoint200DelayScenario.getRandomDelayEndpointScenario.inject(
      atOnceUsers(10),
      rampUsersPerSec(gatling.rampUpUsersPerSec) to gatling.numberOfUsers during (gatling.rampUpDuration seconds)
    )
  )

  setUp(basicEndpointCheckScenarios)
    .protocols(httpConf)
    .maxDuration(1 minutes)
    .assertions(
      global.responseTime.max.lt(gatling.maxResponseTime)
    )
}
