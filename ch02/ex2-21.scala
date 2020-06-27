// Wrapper classes

val x = 10
// x: Int = 10

x.isValidByte
// res1: Boolean = true


val x = 260
// x: Int = 260

x.isValidByte
// res2: Boolean = false

val x = 127
// x: Int = 127

x.isValidByte
// res3: Boolean = true


val x = "I am a String"
// x: String = I am a String
x.charAt(5)
// res13: Char = a


x.capitalize
// res14: String = I am a String

x.toUpperCase
// res15: String = I AM A STRING

x.toLowerCase
// res16: String = i am a string


val rangeOfNumbers = 1 to 199
// rangeOfNumbers: scala.collection.immutable.Range.Inclusive = Range 1 to 199

val rangeOfNumbersUntil = 1 until 199
// rangeOfNumbersUntil: scala.collection.immutable.Range = Range 1 until 199

rangeOfNumbers contains 1
// res18: Boolean = true

rangeOfNumbersUntil contains 199
// res19: Boolean = false

rangeOfNumbers contains 199
// res20: Boolean = true


1 to 10 by 2 foreach println
// 1
// 3
// 5
// 7
// 9
