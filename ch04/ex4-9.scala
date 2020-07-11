// Partial functions

val oneToFirst: PartialFunction[Int, String] = {

  case 1 => "First"

}
// oneToFirst: PartialFunction[Int,String] = <function1>
println(oneToFirst(1))
// First


println(oneToFirst(2))
// scala.MatchError: 2 (of class java.lang.Integer)
//   at scala.PartialFunction$$anon$1.apply(PartialFunction.scala:253)
//   at scala.PartialFunction$$anon$1.apply(PartialFunction.scala:251)
//   at $anonfun$1.applyOrElse(<console>:9)
//   at $anonfun$1.applyOrElse(<console>:9)
//   at scala.runtime.AbstractPartialFunction.apply(AbstractPartialFunction.scala:36)
//   ... 33 elided


oneToFirst.isDefinedAt(2)
// res4: Boolean = false


object PartialFunctions extends App {

  val isPrimeEligible: PartialFunction[Item, Boolean] = {

    case item => item.isPrimeEligible

  }

  val amountMoreThan500: PartialFunction[Item, Boolean] = {

    case item => item.price > 500.0

  }

  val freeDeliverable = isPrimeEligible orElse amountMoreThan500

  def deliveryChange(item: Item): Double = if(freeDeliverable(item)) 0 else 50

  println(deliveryChange(Item("1", "ABC Keyboard", 490.0, false)))

}

case class Item(id: String, name: String, price: Double, isPrimeEligible: Boolean)


// 50.0
