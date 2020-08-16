// ArrayBuffer

import scala.collection.mutable._

val buff = ArrayBuffer(1,2,3)
// buff: scala.collection.mutable.ArrayBuffer[Int] = ArrayBuffer(1, 2, 3)

println(buff)
// ArrayBuffer(1, 2, 3)


buff += 4
// res35: buff.type = ArrayBuffer(1, 2, 3, 4)

println(buff)
// ArrayBuffer(1, 2, 3, 4)

buff -= 4
// res36: buff.type = ArrayBuffer(1, 2, 3)

println(buff)
// ArrayBuffer(1, 2, 3)
