// Why not compose two or more Futures?

object FutureComposition extends App {

  def firstFuture: Future[String] = Future { "1" }

  def secondFuture(str: String): Future[Int] = Future { str.toInt }

  firstFuture flatMap( secondFuture(_) ) map(result => println(s"Converted int: $result"))

  Thread.sleep(5000)
}


// Converted int: 1


def flatMap[S](f: T => Future[S])(implicit executor: ExecutionContext): Future[S]


for {
  value1 <- firstFuture
  value2 <- secondFuture(value1)
} yield println(s"Converted int: $value2")
