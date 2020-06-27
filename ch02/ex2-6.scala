// Character literals

val aChar = '\'
// <console>:1: error: unclosed character literal
//        val aChar = '\'
//                    ^


val doublequotes = "\""
// doublequotes: String = "
val aString = doublequotes + "treatme a string" + doublequotes
// aString: String = "treatme a string"


val c = '\u0101'
// c: Char = ā
