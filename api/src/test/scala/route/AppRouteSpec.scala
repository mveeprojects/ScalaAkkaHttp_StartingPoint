package route

import akka.http.scaladsl.common.{EntityStreamingSupport, JsonEntityStreamingSupport}
import org.scalatest.GivenWhenThen
import org.scalatest.featurespec.AnyFeatureSpec
import org.scalatest.matchers.should.Matchers
import util.RestAssuredUtils

class AppRouteSpec extends AnyFeatureSpec with GivenWhenThen with Matchers with RestAssuredUtils {

  implicit val jsonStreamingSupport: JsonEntityStreamingSupport = EntityStreamingSupport.json()

  Feature("tweets")
    Scenario("/tweets endpoint should return 200") {
      When("I send a request to the /tweets endpoint")
      val response = apiGetRequest("/tweets")
      Then("I should receive a 200 response with message body \"Hello, World!\"")
      response.statusCode() shouldBe 200
      response.body().print() shouldBe "[{\"txt\":\"a\",\"uid\":1},{\"txt\":\"b\",\"uid\":2},{\"txt\":\"c\",\"uid\":3}]"
    }
  }

  Feature("root") {
    Scenario("/ endpoint should return 200") {
      When("I send a request to the / endpoint")
      val response = apiGetRequest()
      Then("I should receive a 200 response with message body \"Hello, World!\"")
      response.statusCode() shouldBe 200
      response.body().print() shouldBe "Hello, World!"
    }
  }

  Feature("metrics") {
    Scenario("metrics endpoint should return 200") {
      When("I send a request to the metrics endpoint")
      val response = metricsGetRequest
      Then("I should receive a 200 response with a non-empty message body")
      response.statusCode() shouldBe 200
      response.body().print() shouldNot be(empty)
    }
  }
}
