import sbt.Keys.libraryDependencies
import sbt._

object Dependencies {
  val pekkoVersion        = "1.1.0"
  val scalaLoggingVersion = "3.9.2"
  val logbackVersion      = "1.2.3"
  val kamonVersion        = "2.7.5"
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
    "org.apache.pekko"           %% "pekko-actor"             % pekkoVersion,
    "org.apache.pekko"           %% "pekko-stream"            % pekkoVersion,
    "org.apache.pekko"           %% "pekko-http"              % pekkoVersion,
    "com.typesafe.scala-logging" %% "scala-logging"           % scalaLoggingVersion,
    "ch.qos.logback"              % "logback-classic"         % logbackVersion,
    "io.kamon"                   %% "kamon-core"              % kamonVersion,
    "io.kamon"                   %% "kamon-pekko-http"        % kamonVersion,
    "io.kamon"                   %% "kamon-system-metrics"    % kamonVersion exclude ("org.slf4j", "slf4j-api"),
    "io.kamon"                   %% "kamon-prometheus"        % kamonVersion,
    "org.apache.pekko"           %% "pekko-http-spray-json"   % pekkoVersion,
    "org.apache.pekko"           %% "pekko-http-testkit"      % pekkoVersion,
    "org.apache.pekko"           %% "pekko-stream-testkit"    % pekkoVersion,
    "io.spray"                   %% "spray-json"              % sprayJsonVersion,
    "org.mockito"                %% "mockito-scala-scalatest" % mockitoVersion
  ) ++ testingDependencies ++ configDependencies

  val performanceDependencies: Def.Setting[Seq[ModuleID]] = libraryDependencies ++= Seq(
    "io.gatling"            % "gatling-core"              % gatlingVersion,
    "io.gatling"            % "gatling-app"               % gatlingVersion,
    "io.gatling.highcharts" % "gatling-charts-highcharts" % gatlingVersion
  ) ++ configDependencies
}
