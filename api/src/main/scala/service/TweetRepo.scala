package service

import akka.NotUsed
import akka.stream.scaladsl.Source
import model.Tweet

trait TweetRepo {
  val tweets: List[Tweet]
  def getTweets: Source[Tweet, NotUsed]
}

object TweetRepo extends TweetRepo {

  val tweets: List[Tweet] = List(
    Tweet(1, "a"),
    Tweet(2, "b"),
    Tweet(3, "c")
  )
  
  override def getTweets: Source[Tweet, NotUsed] = {
    Source(tweets)
  }
}
