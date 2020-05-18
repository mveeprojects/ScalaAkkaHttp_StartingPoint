package route

import org.scalatest.{FeatureSpec, GivenWhenThen, Matchers}
import util.RestAssuredUtils

class AppRouteSpec extends FeatureSpec with GivenWhenThen with Matchers with RestAssuredUtils {

  feature("API hello world route should return 200") {
    scenario("/ endpoint should return 200") {
      When("I send a request to the / endpoint")
      val response = apiGetRequest
      Then("I should receive a 200 response with message body \"Hello, World!\"")
      response.statusCode() shouldBe 200
      response.body().print() shouldBe "Hello, World!"
    }
  }

  feature("Metrics route should return 200 and be non empty") {
    scenario("metrics endpoint should return 200") {
      When("I send a request to the metrics endpoint")
      val response = metricsGetRequest
      Then("I should receive a 200 response with a non-empty message body")
      response.statusCode() shouldBe 200
      response.body().print() shouldNot be (empty)
    }
  }
}
