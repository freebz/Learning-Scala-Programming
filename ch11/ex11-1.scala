// Exception handling - the old way

def toInt(str: String): Int = str.toInt


println(toInt("121"))
println(toInt("-199"))


// 121
// -199


println(toInt("+ -199"))
// Exception in thread "main" java.lang.NumberFormatException: For input string: "+ -199"
//    at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)


import java.lang.Exception

object Main extends App {

  def toInt(str: String): Int =
    try{
      str.toInt
    } catch {
      case exp: Exception =>
        println("Something unexpected happened, you may want to check the string you passed for conversion.")

        println("WARN: Overriding the usual behavior, returning Zero!")
        0
    }

  println(toInt("121"))
  println(toInt("-199"))
  println(toInt("+ -199"))
}


// 121
// -199
// Something unexpected happened, you may want to check the string you passed for conversion.
// WARN: Overriding the usual behavior, returning Zero!
// 0
