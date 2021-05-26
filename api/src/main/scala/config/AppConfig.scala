package config

import pureconfig.ConfigSource
import pureconfig.generic.auto._

object AppConfig {
  case class HttpConfig(host: String, port: Int)
  case class AppConfig(http: HttpConfig)
  val appConfig: AppConfig = ConfigSource.default.loadOrThrow[AppConfig]
}
