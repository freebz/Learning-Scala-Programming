// Implicit parameters

import java.time.{LocalDateTime}

object ImplicitParameter extends App {

  implicit val dateNow = LocalDateTime.now()

  def showDateTime(implicit date: LocalDateTime) = println(date)

  //Calling functions!
  showDateTime
}


// 2017-11-17T10:06:12.321
