// Looking for implicits

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

object FuturesApp extends App {

  val futureComp = Future {
    1 + 1
  }

  println(s"futureComp: $futureComp")

  futureComp.map(result => println(s"futureComp: $result"))
}


// futureComp: Future(Success(2))
// futureComp: 2


import scala.concurrent.ExecutionContext.Implicits._


import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

object FuturesApp extends App {

  implicit val ctx = scala.concurrent.ExecutionContext.Implicits.global

  val futureComp = Future {
    1 + 1
  }

  println(s"futureComp: $futureComp")

  futureComp.map(result => println(s"futureComp: $result"))
}


// <console>:20: error: ambiguous implicit values:
//  both value global in object Implicits of type => scala.concurrent.ExecutionContextExecutor
//  and value ctx in object FuturesApp of type => scala.concurrent.ExecutionContextExecutor
//  match expected type scala.concurrent.ExecutionContext
//          val futureComp = Future {
//                                  ^
