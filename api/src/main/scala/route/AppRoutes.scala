package route

import akka.actor.ActorSystem
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route
import akka.http.scaladsl.model.StatusCodes

import scala.concurrent.ExecutionContext

trait AppRoutes {
  implicit val system: ActorSystem = ActorSystem("my-mega-actor-system")
  implicit val executor: ExecutionContext = system.dispatcher

  def route: Route = get {
    pathSingleSlash {
      complete(StatusCodes.OK -> "Hello, World!")
    }
  }
}