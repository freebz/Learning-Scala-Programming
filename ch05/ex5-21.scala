// Parallel collections in Scala

// ParArray

import scala.collection.parallel.mutable._
// import scala.collection.parallel.mutable._

val pararr = ParArray(1,2,3,4,5,6,7,8,9,10)
// pararr: scala.collection.parallel.mutable.ParArray[Int] = ParArray(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)


pararr.seq
// res1: scala.collection.mutable.ArraySeq[Int] = ArraySeq(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
