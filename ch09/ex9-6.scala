// Option type

val a: Option = Some(1)
// <console>:11: error: class Option takes type parameters
//        val a: Option = Some(1)
//               ^

val a: Option[Int] = Some(1)
// a: Option[Int] = Some(1)


a map println
// 1


def safeToInt(canBeNumber: String): Int = {
  try {
    canBeNumber.toInt
  } catch {
    case NonFatal(e) => throw new Exception
  }
}
