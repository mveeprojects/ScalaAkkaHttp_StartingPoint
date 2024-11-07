import Dependencies._
import sbtassembly.MergeStrategy

name := "ScalaPekkoHttp_StartingPoint"
version := "0.1"
organization := "mveeprojects"
scalaVersion := "2.13.4"

lazy val root: Project = (project in file("."))
  .aggregate(api, performance)

lazy val api: Project = (project in file("api"))
  .settings(apiDependencies: _*)
  .settings(apiAssemblySettings: _*)

lazy val performance: Project = (project in file("performance"))
  .settings(performanceDependencies: _*)
  .settings(performanceAssemblySettings: _*)

lazy val mergeStrategy = assemblyMergeStrategy in assembly := {
  case PathList("META-INF", _*)   => MergeStrategy.discard
  case PathList("reference.conf") => MergeStrategy.concat
  case _                          => MergeStrategy.first
}

lazy val apiAssemblySettings = Seq(mergeStrategy, mainClass in assembly := Some("Application"))

lazy val performanceAssemblySettings = Seq(mergeStrategy, mainClass in assembly := Some("PerformanceMain"))
