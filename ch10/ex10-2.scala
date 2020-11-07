// Why so serious about types?

Data    |    Operations


val xs: List = List("ABC")
// <console>:11: error: type List takes type parameters
//        val xs: List = List("ABC")


val xs: List[T] = List("ABC")
// <console>:11: error: not found: type T
//        val xs: List[T] = List("ABC")


val xs: List[String] = List("ABC")
// xs: List[String] = List(ABC)
