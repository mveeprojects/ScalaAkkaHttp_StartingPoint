import io.gatling.app.Gatling
import io.gatling.core.config.GatlingPropertiesBuilder

object PerformanceMain extends App {
  val props = new GatlingPropertiesBuilder
  props.simulationClass("simulations.BasicSimulations")
  Gatling.fromMap(props.build)
}
