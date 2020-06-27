// Operators in Scala

val x = 1 + 10
// x: Int = 11


val y = 1 + 'a'
// y: Int = 98


class Amount(val amt: Double) {

  def taxApplied(tax: Double) = this.amt * tax/100 + this.amt

}

object Order extends App {

  val tax = 10
  val firstOrderAmount = 130

  def amountAfterTax(amount: Amount) = amount taxApplied tax

  println(s"Total Amount for order:: ${amountAfterTax(new Amount(firstOrderAmount))}")
}


// Total Amount for order:: 143.0


val firstString = "I am a String"
// firstString: String = I am a String

firstString indexOf 'a'
// res1: Int = 2


def truthTeller(lie: Boolean) = !lie
// truthTeller: (lie: Boolean)Boolean

truthTeller(false)
// res2: Boolean = true


def truthTeller(lie: Boolean) = lie.unary_!
// truthTeller: (lie: Boolean)Boolean


1.toString
// res4: String = 1

"1".toInt
// res5: Int = 1

"ABC".toLowerCase
// res7: String = abc
