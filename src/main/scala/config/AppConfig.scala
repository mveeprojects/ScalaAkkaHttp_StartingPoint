package config

import com.typesafe.config.ConfigFactory

trait AppConfig {
  val host: String = config.getString("app.host")
  val port: Int = config.getInt("app.port")
  private val config = ConfigFactory.load()
}
