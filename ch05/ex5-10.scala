// SortedSet

import scala.collection.immutable.TreeSet

object TreeSetImpl extends App {

  //implicit val ordering = Ordering.fromLessThan[Int](_ > _)

  val treeSet = new TreeSet()+(1,3,12,3,5)

  println(treeSet)

}


// Error: diverging implicit expansion for type scala.math.Ordering[T1]
// starting with method Tuple9 in object Ordering
//   val treeSet = new TreeSet()+(1,3,12,3,5)
//                 ^
