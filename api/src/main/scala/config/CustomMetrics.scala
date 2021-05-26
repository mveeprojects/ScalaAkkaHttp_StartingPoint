package config

import kamon.Kamon
import kamon.metric.Counter

object CustomMetrics {
  private val endpointHitCounter          = Kamon.counter("myendpointhits")
  val tweetsEndpointCounter: Counter      = endpointHitCounter.withTag("endpoint", "tweets")
  val helloWorldEndpointCounter: Counter  = endpointHitCounter.withTag("endpoint", "helloworld")
  val authPathEndpointCounter: Counter    = endpointHitCounter.withTag("endpoint", "authpath")
  val randomDelayEndpointCounter: Counter = endpointHitCounter.withTag("endpoint", "randomdelay")
}
