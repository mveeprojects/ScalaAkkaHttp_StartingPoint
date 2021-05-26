import sbt.Keys.libraryDependencies
import sbt._

object Dependencies {
  val akkaVersion         = "2.6.12"
  val akkaHttpVersion     = "10.2.3"
  val scalaLoggingVersion = "3.9.2"
  val logbackVersion      = "1.2.3"
  val kamonVersion        = "2.1.9"
  val gatlingVersion      = "3.3.1"
  val scalaTestVersion    = "3.2.3"
  val restAssuredVersion  = "4.1.1"
  val sprayJsonVersion    = "1.3.6"
  val mockitoVersion      = "1.16.15"
  val pureConfig          = "0.14.0"

  val configDependencies = Seq(
    "com.github.pureconfig" %% "pureconfig" % pureConfig
  )

  val testingDependencies = Seq(
    "org.scalatest"  %% "scalatest"    % scalaTestVersion   % Test,
    "io.rest-assured" % "rest-assured" % restAssuredVersion % Test
  )

  val apiDependencies: Def.Setting[Seq[ModuleID]] = libraryDependencies ++= Seq(
    "com.typesafe.akka"          %% "akka-actor"              % akkaVersion,
    "com.typesafe.akka"          %% "akka-stream"             % akkaVersion,
    "com.typesafe.akka"          %% "akka-http"               % akkaHttpVersion,
    "com.typesafe.scala-logging" %% "scala-logging"           % scalaLoggingVersion,
    "ch.qos.logback"              % "logback-classic"         % logbackVersion,
    "io.kamon"                   %% "kamon-core"              % kamonVersion,
    "io.kamon"                   %% "kamon-akka-http"         % kamonVersion,
    "io.kamon"                   %% "kamon-system-metrics"    % kamonVersion exclude ("org.slf4j", "slf4j-api"),
    "io.kamon"                   %% "kamon-prometheus"        % kamonVersion,
    "com.typesafe.akka"          %% "akka-http-spray-json"    % akkaHttpVersion,
    "com.typesafe.akka"          %% "akka-http-testkit"       % akkaHttpVersion,
    "com.typesafe.akka"          %% "akka-stream-testkit"     % akkaVersion,
    "io.spray"                   %% "spray-json"              % sprayJsonVersion,
    "org.mockito"                %% "mockito-scala-scalatest" % mockitoVersion
  ) ++ testingDependencies ++ configDependencies

  val performanceDependencies: Def.Setting[Seq[ModuleID]] = libraryDependencies ++= Seq(
    "io.gatling"            % "gatling-core"              % gatlingVersion,
    "io.gatling"            % "gatling-app"               % gatlingVersion,
    "io.gatling.highcharts" % "gatling-charts-highcharts" % gatlingVersion
  ) ++ configDependencies
}
