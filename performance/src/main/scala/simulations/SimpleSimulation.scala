package simulations

import config.PerformanceConfig
import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.http.protocol.HttpProtocolBuilder
import scenarios.SimpleScenario

import scala.concurrent.duration._

class SimpleSimulation extends Simulation with PerformanceConfig {

  val httpConf: HttpProtocolBuilder = http.baseUrl(s"http://$host:$port")

  val basicEndpointCheckScenarios = List(

    SimpleScenario.getHomeEndpoint.inject(
      atOnceUsers(1),
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
