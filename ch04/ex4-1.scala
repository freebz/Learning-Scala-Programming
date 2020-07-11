// Function syntax

modifiers...
def function_name(arg1: arg1_type, arg2: arg2_type,...): return_type = ???


def compareIntegers(value1: Int, value2: Int): Int = if (value1 == value2) 0 else if (value1 > value2) 1 else -1


def compareIntegers(value1: Int, value2: Int): Int =
  if (value1 == value2) 0 else if (value1 > value2) 1 else -1


def compareIntegers(value1: Int, value2: Int): Int = {
  println(s" Executing V2")
  if (value1 == value2) 0 else if (value1 > value2) 1 else -1
}


object FunctionSyntax extends App{
  /*
   * Function compare two Integer numbers
   * @param value1 Int
   * @param value2 Int
   * return Int
   * 1  if value1 > value2
   * 0  if value1 = value2
   * -1 if value1 < value2
   */
  def compareIntegers(value1: Int, value2: Int): Int = if (value1 == value2) 0 else if (value1 > value2) 1 else -1

  def compareIntegersV1(value1: Int, value2: Int): Int = {
    if (value1 == value2) 0 else if (value1 > value2) 1 else -1
  }

  def compareIntegersV2(value1: Int, value2: Int): Int =
    if (value1 == value2) 0 else if (value1 > value2) 1 else -1

  println(compareIntegers(1, 2))
  println(compareIntegersV1(2, 1))
  println(compareIntegersV2(2, 2))

}


// -1
// 1
// 0
