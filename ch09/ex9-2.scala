// Pattern matching

val somelist = List(1,2,3)

somelist match {
  case Nil => Nil
  case _ => ???
}


val somelist = 1 :: 2 :: 3 :: Nil

val x = somelist match {
  case Nil => Nil
  case _ => println("anything")
  case head :: tail => println("something with a head and a tail")
}


// <console>:10: warning: patterns after a variable pattern cannot match (SLS 8.1.1)
// case _ => println("anything")
//      ^
// <console>:11: warning: unreachable code due to variable pattern on line 10
// case head :: tail => println("something with a head and a tail")
//                             ^
// <console>:11: warning: unreachable code
// case head :: tail => println("something with a head and a tail")
//                             ^
// anything
// x: Any = ()
