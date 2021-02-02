package util

import config.AppConfig
import io.restassured.RestAssured
import io.restassured.response.Response

trait RestAssuredUtils extends AppConfig {

  def apiGetRequest(route: String = "/"): Response =
    RestAssured.when().get(s"http://$host:$port$route")

  def metricsGetRequest: Response =
    RestAssured.when().get(s"http://$host:9095")
}
