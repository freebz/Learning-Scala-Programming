// Integer literals

val num = 002
// <console>:1: error: Decimal integer literals may not have a leading zero. (Octal syntax is obsolete.)
//        val num = 002
//                  ^


0xFF
// res0: Int = 255


val aByte: Byte = 12
// aByte: Byte = 12


val aByte: Byte = 123456
// <console>:10: error: type mismatch;
//  found   : Int(123456)
//  required: Byte
//        val aByte: Byte = 123456
//                          ^


val outOfRange = 12345678901112131415
// <console>:1: error: integer number too large
//       val outOfRange = 12345678901112131415
//                        ^


val aLong = 909L
// aLong: Long = 909

val aLong = 909l
// aLong: Long = 909

val anotherLong: Long = 1
// anotherLong: Long = 1


val aByte: Byte = 1
// aByte: Byte = 1

val aShort: Short = 1
// aShort: Short = 1
