package com.example.consumer

import org.json4s.DefaultFormats
import org.json4s.native.JsonParser._

import scalaj.http.{Http, HttpResponse}

object ConsumerClient {

  private implicit val formats = DefaultFormats
  
  def fetchUser(baseUrl: String): Option[User] = {
    Http(baseUrl + "/user").asString match {
      case r: HttpResponse[String] if r.is2xx =>
        parse(r.body).extractOpt[User]

      case _ =>
        None
    }
  }

}

case class User(id:Int, name:String)
