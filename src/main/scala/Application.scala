import Route.AppRoutes
import akka.http.scaladsl.Http
import com.typesafe.config.ConfigFactory
import com.typesafe.scalalogging.LazyLogging

import scala.util.{Failure, Success}

object Application extends App with AppRoutes with LazyLogging {
  private val config = ConfigFactory.load()
  private val host = config.getString("app.host")
  private val port = config.getInt("app.port")

  Http().bindAndHandle(route, host, port).onComplete{
    case Success(_) =>
      logger.info(s"App running ($host:$port)")
    case Failure(exception) =>
      logger.info(s"App failed to start:\n${exception.getMessage}")
  }
}