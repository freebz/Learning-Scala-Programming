// Container types

sealed abstract class Option[+A] extends Product
    with Serializable


sealed abstract class Either[+A, +B] extends Product with Serializable


object TypeErausre extends App {
  val strings: List[String] = List("First", "Second", "Third")
  val noStringsAttached: List[Int] = List(1, 2, 3)

  def listOf[A](value: List[A]) = value match {
    case listOfString: List[String] => println("Strings Attached!")
    case listOfNumbers: List[Int] => println("No Strings Attached!")
  }

  listOf(strings)
  listOf(noStringsAttached)
}


// Strings Attached!
// Strings Attached!
