// Implicits - what and why

import scala.concurrent.Future

object FuturesApp extends App {

  val futureComp = Future {
    1 + 1
  }

  println(s"futureComp: $futureComp")

  futureComp.map(result => println(s"futureComp: $result"))
}


// <console>:13: error: Cannot find an implicit ExecutionContext. You might pass
// an (implicit ec: ExecutionContext) parameter to your method
// or import scala.concurrent.ExecutionContext.Implicits.global.
// val futureComp = Future {
//                         ^


def apply[T](body: =>T)(implicit executor: ExecutionContext): Future[T]


import scala.concurrent.Future

object FuturesApp extends App {

  implicit val ctx = scala.concurrent.ExecutionContext.Implicits.global

  val futureComp = Future {
    1 + 1
  }

  println(s"futureComp: $futureComp")

  futureComp.map(result => println(s"futureComp: $result"))
}


// futureComp: Future(Success(2))
// futureComp: 2
