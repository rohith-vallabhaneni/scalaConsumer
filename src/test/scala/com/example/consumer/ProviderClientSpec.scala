package com.example.consumer

import org.json4s.DefaultFormats
import org.json4s.native.Serialization._
import org.scalatest.{FunSpec, Matchers}

class ConsumerClientSpec extends FunSpec with Matchers {

  import com.itv.scalapact.ScalaPactForger._

  implicit val formats = DefaultFormats

  describe("Connecting to the Consumer service") {

    it("should be able to fetch User"){

      val body = write(
        User(
          id = 1,
          name = "John"
        )
      )

      forgePact
        .between("scala_pact_Consumer")
        .and("scala_pact_Provider")
        .addInteraction(
          interaction
            .description("Fetching User")
            .uponReceiving("/user")
            .willRespondWith(200, body)
        )
        .runConsumerTest { mockConfig =>

          val results = ConsumerClient.fetchUser(mockConfig.baseUrl)

          results.isDefined shouldEqual true
          results.get.id shouldEqual 1
          results.get.name shouldEqual "John"
        }
      
    }
  }
  
}
