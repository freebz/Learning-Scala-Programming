// Traits as mix-ins

// Traits as composable mix-ins

case class Amount(amt: Double, currency: String){
  override def toString: String = s"$amt ${currency.toUpperCase}"
}

abstract class CreditCard {
  val ccType = "Default"
  def creditLimit(x: Double): Amount

  //legacy creditCartNumberGeneratorLogic
  val ccNum = scala.util.Random.nextInt(1000000000).toString

  //other methods

}

object CCApp extends App {
  val basicCreditCard = new CreditCard {
    override def creditLimit(x: Double): Amount = Amount(x, "USD")
  }

  val limit = basicCreditCard.creditLimit(1000)
  println(s"CreditCardNumber ${basicCreditCard.ccNum} with limit: $limit")
}


// CreditCardNumber 581560622 with limit: 1000.0 USD


trait CreditCardOps {
  self: CreditCart =>
  val ccNumber: String = ccType match {
    case "BASIC" => "BC" + ccNum
    case _ => "DC" + ccNum
  }
}

object CCApp extends App {
  val basicCreditCard = new CreditCart with CreditCardOps {
    override def creditLimit(x: Double): Amount = Amount(x, "USD")
  }

  val limit = basicCreditCard.creditLimit(1000)
  println(s"CreditCardNumber ${basicCreditCard.ccNumber} with limit: $limit")
}


class DebitCard

val someDibitCard = new DebitCard with CreditCardOps


trait CreditCardOps {

  self: CreditCard =>
  val ccNumber: String = ccType match {
    case "BASIC" => "BC" + ccNum
    case _ => "DC" + ccNum
  }

  override val ccNum = ccNumber // will be null
}
