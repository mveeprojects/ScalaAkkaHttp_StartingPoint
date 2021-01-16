package config

import com.typesafe.config.ConfigFactory

trait PerformanceConfig {
  val host: String           = config.getString("app.host")
  val port: Int              = config.getInt("app.port")
  val maxResponseTime: Int   = config.getInt("performance.maxResponsetime")
  val numberOfUsers: Int     = config.getInt("performance.numberOfUsers")
  val rampUpUsersPerSec: Int = config.getInt("performance.rampUpUsersPerSec")
  val rampUpDuration: Int    = config.getInt("performance.rampUpDuration")
  private val config         = ConfigFactory.load()
}
