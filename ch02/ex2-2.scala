// Vals and vars

val a = 10
// a: Int = 10


a = 12
// <console>:11: error: reassignment to val
//        a = 12
//          ^


var b = 10
// b: Int = 10


b = 12
// b: Int = 12


val a: String = "I can be inferred."
// a: String = I can be inferred.


val a: Int = "12"
// <console>:10: error: type mismatch;
//  found   : String("12")
//  required: Int
//        val a: Int = "12"
//                     ^
