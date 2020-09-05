// Traits as stackable modifications

new Service with BasicPackage


new Service with BasicPackage with DiamondPackage


abstract class CreditCard {
  val ccType = "Default"
  def creditLimit(x: Double) : Amount

  //legacy creditCardNumberGeneratorLogic
  val ccNum = scala.util.Random.nextInt(1000000000).toString

  //other methods
}


class BasicCreditCard extends CreditCard {
  override def creditLimit(x: Double): Amount = Amount(x, "USD")
}


trait GoldSubscription extends CreditCard {
  abstract override def creditLimit(x: Double): Amount = super.creditLimit(x * 1.10)
}

trait PlatinumSubscription extends CreditCard {
  abstract override def creditLimit(x: Double): Amount = super.creditLimit(x * 1.25)
}


object CCApp extends App {
  val basicCreditCard = new BasicCreditCard()
  println(basicCreditCard.creditLimit(15000))

  val goldCreditCard = new BasicCreditCard() with GoldSubscription
  println(goldCreditCard.creditLimit(15000))

  val platinumCreditCard = new BasicCreditCard() with PlatinumSubscription
  println(platinumCreditCard.creditLimit(15000))

  val gplusCreditCard = new BasicCreditCard() with GoldSubscription with PlatinumSubscription
  println(gplusCreditCard.creditLimit(15000))
}


// 15000.0 USD
// 16500.0 USD
// 18750.0 USD
// 20625.0 USD
