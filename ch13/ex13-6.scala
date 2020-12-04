// Working with Promises

import scala.concurrent._
import scala.concurrent.ExecutionContext.Implicits.global

object ItsAPromise extends App {

  val firstPromise = Promise[String]

  for {
    value1 <- firstPromise.future
  } yield println(s"Value1: $value1")

  firstPromise.success("1")

  Thread.sleep(500)
}


// Value1: 1


def apply[T](): Promise[T]
