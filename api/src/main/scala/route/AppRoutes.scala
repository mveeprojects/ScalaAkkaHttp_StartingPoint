package route

import akka.actor.ActorSystem
import akka.http.scaladsl.model.StatusCodes
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route

import scala.concurrent.ExecutionContext

trait AppRoutes {
  implicit val system: ActorSystem = ActorSystem("my-mega-actor-system")
  implicit val executor: ExecutionContext = system.dispatcher

  def route: Route = concat(
    get {
      pathSingleSlash {
        complete(StatusCodes.OK -> "Hello, World!")
      }
    }, get {
      path("randomdelay") {
        def randomDurationToWait: Long = Math.floor(Math.random() * 10 * 100).toLong
        Thread.sleep(randomDurationToWait)
        complete(StatusCodes.OK -> "Waited for a bit then responded")
      }
    }
  )
}