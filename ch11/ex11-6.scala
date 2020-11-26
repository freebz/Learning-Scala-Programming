// The implicitly method

def implicitly[T](implicit e: T) = e


import java.time.{LocalDateTime}

object ImplicitParameter extends App {

  implicit val dateNow = LocalDateTime.now()

  def showDateTime(implicit date: LocalDateTime) = println(date)

  val ldt = implicitly[LocalDateTime]

  println(s"ldt value from implicit scope: $ldt")
}


// ldt value from implicit scope: 2017-12-17T10:47:13.846
