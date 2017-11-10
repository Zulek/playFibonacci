package org.play.embedded

import akka.actor.ActorSystem
import org.play.test.helpers.Tools._
import play.api.test.{FakeHeaders, FakeRequest, PlaySpecification}

class MyServiceSpec extends PlaySpecification {

  implicit val system = ActorSystem("test")

  "MyService" should {
    "return a 0 for GET requests to the fib path" in {
      val requestHeader = FakeRequest(method = "GET", path = "/fib")

      MyService.routes.apply(requestHeader).body must beEqualTo("Fibonacci numbers: \n0!")
    }

    "return a Fibonacci numbers for GET requests to the fib path with index parameter" in {
      val requestHeader = FakeRequest(method = "GET", uri = "/fib?index=8", headers = FakeHeaders(), body = "")

      MyService.routes.apply(requestHeader).body must beEqualTo("Fibonacci numbers: \n0,1,1,2,3,5,8,13,21!")

    }

    "leave GET requests to other paths unhandled" in {
      MyService.routes.isDefinedAt(FakeRequest(method = "GET", path = "/kermit")) must beFalse
    }

    "leave PUT request to greeting unhandled" in {
      MyService.routes.isDefinedAt(FakeRequest(method = "PUT", path = "/fib")) must beFalse
    }
  }
}



