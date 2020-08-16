// Set

trait Set[A] extends (A) -> Boolean with Iterable[A] with GenSet[A] with GenericSetTemplate[A, Set] with SetLike[A, Set[A]]


val aSet = Set(1,2,3,4)
// aSet: scala.collection.immutable.Set[Int] = Set(1, 2, 3, 4)

aSet(2)
// res0: Boolean = true

aSet(5)
// res1: Boolean = false

aSet(0)
// res2: Boolean = false
