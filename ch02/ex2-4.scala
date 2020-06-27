// Floating point literals

val a = 1. //Not possible!


val aDoubleByDefault = 1.0
// aDoubleByDefault: Double = 1.0


val aFloat: Float = 1.0 //Compile Error;
val aFloat: Float = 1.0F //Works
val aFloat: Float = 1.0f //Works


val aFloat: Float = 1.0
// <console>:10: error: type mismatch;
//  found   : Double(1.0)
//  required: Float
//        val aFloat: Float = 1.0
//                            ^
