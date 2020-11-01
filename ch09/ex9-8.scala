// Tail call optimization

import scala.annotation.tailrec

object TailRecursion {
  def main(args: Array[String]): Unit = {
    val list = List("Alex", "Bob", "Chris", "David", "Raven", "Stuart")
    someRecursiveMethod(list)
  }

  /*
   You have a sorted list of names of employees, within a company.
   print all names until the name "Raven" comes
   */
  @tailrec
  def someRecursiveMethod(list: List[String]): Unit = {
    list match {
      case Nil => println("Can't continue. Either printed all names or encountered Raven")
      case head :: tail => if(head != "Raven") {
        println(s"Name: $head")
        someRecursiveMethod(tail)
      }
      else
        someRecursiveMethod(Nil)
    }
  }
}


// Name: Alex
// Name: Bob
// Name: Chris
// Name: David
// Can't continue. Either printed all names or encountered Raven


@tailrec
def someRecursiveMethod(list: List[String]): Unit = {
  list match {
    case Nil => println(s"Can't continue. Either printed all names of encountered Raven")
    case head :: tail => if(head != "Raven") {
      println(s"Name: $head")
      someRecursiveMethod(tail)
      println("Won't happen")
    } else someRecursiveMethod(Nil)
  }
}


// <console>:16: error: could not optimize @tailrec annotated method someRecursiveMethod: it contains a recursive call not in tail position
//              someRecursiveMethod(tail)
//                                 ^
