package org.play.embedded

import play.api.mvc.{Action, AnyContent, RequestHeader, Results}
import play.api.routing.sird._


object MyService {

  val routes: PartialFunction[RequestHeader, Action[AnyContent]] = {
    case GET(p"/fib" ? q_?"index=$index") => Action {
      Results.Ok(s"Fibonacci numbers: \n${Fibonacci.compute(index.getOrElse("0").toInt).mkString(",")}!")
    }
  }

}
