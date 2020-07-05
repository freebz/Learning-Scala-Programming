// Pattern matching

object PatternMatching extends App {

  def matchAgainst(i: Int) = i match {
    case 1 => println("One")
    case 2 => println("Two")
    case 3 => println("Three")
    case 4 => println("Four")
  }

  matchAgainst(5)
}


// Exception in thread "main" scala.MatchError: 5 (of class java.lang.Integer)
//             at PatternMatching$.matchAgainst(PatternMatching.scala:6)
//             at PatternMatching$.delayedEndpoint$PatternMatching$1(PatternMatching.scala:13)
//             at PatternMatching$delayedInit$body.apply(PatternMatching.scala:4)
//             at scala.Function0$class.apply$mcV$sp(Function0.scala:34)
//             at scala.runtime.AbstractFunction0.apply$mcV$sp(AbstractFunction0.scala:12)


object PatternMatching extends App {

  def matchAgainst(i: Int) = i match {
    case 1 => println("One")
    case 2 => println("Two")
    case 3 => println("Three")
    case 4 => println("Four")
    case _ => println("Not in Range 1 to 4")
  }

  matchAgainst(1)
  matchAgainst(5)
}


// One
// Not in Range 1 to 4
