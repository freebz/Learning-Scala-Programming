// Type inference

val treatMeAString = "Invisible"
// treatMeAString: String = Invisible


def checkMeImaString(x: Boolean) = if(x) "True" else "False"


def recursiveFactorial(n: Int) = if(n == 0) 1 else recursiveFactorial(n-1)
// Recursive method recursiveFactorial needs result type


val x = x => x
// <console>:11: error: missing parameter type
//        val x = x => x
//                ^


List(1,4,6,7,9).filter(_+1 > 5)
// res0: List[Int] = List(6, 7, 9)
