package config

import pureconfig.ConfigSource
import pureconfig.generic.auto._

object PerformanceConfig {

  case class AppConfig(host: String, port: Int)

  case class GatlingConfig(
      maxResponseTime: Int,
      numberOfUsers: Int,
      rampUpUsersPerSec: Int,
      rampUpDuration: Int
  )

  case class Config(app: AppConfig, gatling: GatlingConfig)

  val perfTestConfig: Config = ConfigSource.default.loadOrThrow[Config]
}
