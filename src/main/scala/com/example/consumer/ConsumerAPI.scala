package com.example.provider

import org.http4s._
import org.http4s.dsl._
import _root_.argonaut._
import Argonaut._
import org.http4s.argonaut._
import java.io.File

import scala.io.Source
import scala.util.Random

import org.http4s.util.CaseInsensitiveString

object ConsumerAPI {

  val service = HttpService {
    case request @ GET -> Root / ".well-known" / "live" =>
      NoContent()
     
    case request @ GET -> Root / ".well-known" / "ready" =>
      NoContent()

    case request @ HEAD -> Root / ".well-known" / "live" =>
      NoContent()
     
    case request @ HEAD -> Root / ".well-known" / "ready" =>
      NoContent()
  }
} 

import org.http4s.server.blaze.BlazeBuilder

object Server extends App {
  BlazeBuilder.bindHttp(8082,"0.0.0.0")
    .mountService(ConsumerAPI.service, "/")
    .run
    .awaitShutdown()
}
