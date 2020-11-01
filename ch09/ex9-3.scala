// Diferrent ways we can pattern match

// Matching a variable

import scala.util.control.NonFatal

def safeToInt(canBeNumber: String): Option[Int] = {
  try {
    Some(canBeNumber.toInt)
  } catch {
    case NonFatal(e) => None
  }
}

safeToInt("20") match {
  case None => println("Got nothing")
  case someValue => println(s"Got ${someValue.get}")
}


// Got 20
