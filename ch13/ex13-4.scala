// What if Future computations go wrong?

listOfPlayers onComplete {
  case Success(list) => list foreach println
  case Failure(_) => println(s"listOfPlayers couldn't be fetched.")
}


def onComplete[U](f: Try[T] => U)(implicit executor: ExecutionContext): Unit


import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.{Failure, Success}

object TowardsFutureComposition extends App {

  def firstFuture: Future[String] = Future { "1" }
  def secondFuture(str : String): Future[Int] = Future { str.toInt }

  firstFuture onComplete {
    case Success(value1) =>
      secondFuture(value1) onComplete {
        case Success(value2) => println(s"Converted int: $value2")
        case Failure(exception) => println(s"Conversion failed due to ${exception.getMessage} ")
      }
    case Failure(excep) => Future.failed(excep)
  }

  Thread.sleep(5000)
}
