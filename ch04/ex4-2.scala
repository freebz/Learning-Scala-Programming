// Nesting of functions

object FunctionSyntaxOne extends App {

  def compareIntegersV4(value1: Int, value2: Int): String = {
    println("Executing V4")
    val result = if (value1 == value2) 0 else if (value1 > value2) 1 else -1

    giveAMeaningFullResult(result, value1, value2)
  }

  private def giveAMeaningFullResult(result: Int, value1: Int, value2: Int) = result match {
    case 0 => "Values are equal"
    case -1 => s"$value1 is smaller than $value2"
    case 1 => s"$value1 is greater than $value2"
    case _ => "Could not perform the operation"
  }

  println(compareIntegersV4(2,1))
}


// Executing V4
// 2 is greater than 1


object FunctionSyntaxTwo extends App {

  def compareIntegersV5(value1: Int, value2: Int): String = {
    println("Executing V5")

    def giveAMeaningFullResult(result: Int) = result match {
      case 0 => "Values are equal"
      case -1 => s"$value1 is smaller than $value2"
      case 1 => s"$value1 is greater than $value2"
      case _ => "Could not perform the operation"
    }

    val result = if (value1 == value2) 0 else if (value1 > value2) 1 else -1

    giveAMeaningFullResult(result)

  }

  println(compareIntegersV5(2,1))

}


// Executing V5
// 2 is greater than 1
