import akka.http.scaladsl.Http
import com.typesafe.scalalogging.LazyLogging
import config.AppConfig
import kamon.Kamon
import route.AppRoutes

import scala.util.{Failure, Success}

object Application extends App with AppRoutes with AppConfig with LazyLogging {

  Http().bindAndHandle(route, host, port).onComplete {
    case Success(_) =>
      Kamon.init
      logger.info(s"App running ($host:$port)")
    case Failure(exception) =>
      logger.info(s"App failed to start:\n${exception.getMessage}")
  }
}
