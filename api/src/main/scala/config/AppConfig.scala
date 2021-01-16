package config

import com.typesafe.config.ConfigFactory

trait AppConfig {
  private val config = ConfigFactory.load()
  val host: String   = config.getString("app.host")
  val port: Int      = config.getInt("app.port")
}
