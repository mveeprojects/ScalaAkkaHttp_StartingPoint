package util

import config.AppConfig
import io.restassured.RestAssured
import io.restassured.response.Response

trait RestAssuredUtils extends AppConfig {

  def apiGetRequest: Response =
    RestAssured.when().get(s"http://$host:$port")

  def metricsGetRequest: Response =
    RestAssured.when().get(s"http://$host:9095")
}
