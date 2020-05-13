import io.gatling.app.Gatling
import io.gatling.core.config.GatlingPropertiesBuilder

object PerformanceMain extends App {
  val props = new GatlingPropertiesBuilder
  props.simulationClass("simulations.SimpleSimulation")
  Gatling.fromMap(props.build)
}
