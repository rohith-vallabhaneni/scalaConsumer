name := "scala_pact_consumer"

organization := "com.example"

version := "0.0.2"

scalaVersion := "2.12.1"

pactBrokerAddress := "http://54.207.30.143:8081"

libraryDependencies ++= Seq(
  "org.scalaj"     %% "scalaj-http"         % "2.3.0",
  "org.slf4j"      % "slf4j-simple"         % "1.6.4",
  "org.json4s"     %% "json4s-native"       % "3.5.0",
  "org.scalatest"  %% "scalatest"           % "3.0.0" % "test",
  "com.itv"        %% "scalapact-scalatest" % "2.1.3" % "test",
  "org.http4s"     %% "http4s-blaze-server" % "0.15.0a",
  "org.http4s"     %% "http4s-dsl"          % "0.15.0a",
  "org.http4s"     %% "http4s-argonaut"     % "0.15.0a"
)
