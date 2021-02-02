package model

import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport
import spray.json.{DefaultJsonProtocol, RootJsonFormat}

object TweetJsonProtocol extends SprayJsonSupport with DefaultJsonProtocol {
  implicit val tweetFormat: RootJsonFormat[Tweet] = jsonFormat2(Tweet.apply)
}
