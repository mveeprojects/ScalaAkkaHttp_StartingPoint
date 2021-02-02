package route

import akka.NotUsed
import akka.actor.ActorSystem
import akka.http.scaladsl.common.{EntityStreamingSupport, JsonEntityStreamingSupport}
import akka.http.scaladsl.model.StatusCodes
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route
import akka.stream.scaladsl.Source
import model.Tweet
import service.TweetRepo.getTweets
import model.TweetJsonProtocol._

import scala.concurrent.ExecutionContext

trait AppRoutes {
  implicit val system: ActorSystem        = ActorSystem("my-mega-actor-system")
  implicit val executor: ExecutionContext = system.dispatcher

  implicit val jsonStreamingSupport: JsonEntityStreamingSupport = EntityStreamingSupport.json()

  def route: Route = concat(
    path("tweets") {
      val tweets: Source[Tweet, NotUsed] = getTweets
      complete(tweets)
    },
    get {
      pathSingleSlash {
        complete(StatusCodes.OK -> "Hello, World!")
      }
    },
    get {
      path("randomdelay") {
        def randomDurationToWait: Long = Math.floor(Math.random() * 10 * 100).toLong
        Thread.sleep(randomDurationToWait)
        complete(StatusCodes.OK -> "Waited for a bit then responded")
      }
    }
  )
}
