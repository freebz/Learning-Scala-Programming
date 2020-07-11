// Calling a function with a default parameter value

def compareIntegersV6(value1: Int, value2: Int = 10): String = {
  println("Executing V6")

  def giveAMeaningFullResult(result: Int) = result match {
    case 0 => "Values are equal"
    case -1 => s"$value1 is smaller than $value2"
    case 1 => s"$value1 is greater than $value2"
    case _ => "Could not perform the operation"
  }

  val result = if (value1 == value2) 0 else if (value1 > value2) 1 else -1
  giveAMeaningFullResult(result)
}

println(compareIntegersV6(12))


// Executing V6
// 12 is greater than 10


compareIntegersV6(12)


def compareIntegersV6(value1: Int = 10, value2: Int) = ???


println(compareIntegersV6(12)) // Compiler won't allow
