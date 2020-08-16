// Seq

trait Seq[+A] extends PartialFunction[Int, A] with Iterable[A] with GenSeq[A] with GenericTraversableTemplate[A, Seq] with SeqLike[A, Seq[A]]


val aSeq = scala.collection.LinearSeq[Int](1,2,3,4)
// aSeq: scala.collection.LinearSeq[Int] = List(1, 2, 3, 4)

aSeq(1)
// res0: Int = 2


aSeq(5)
// java.lang.IndexOutOfBoundsException: 5
// at scala.collection.LinearSeqOptimized$class.apply(LinearSeqOptimized.scala:65)
// at scala.collection.immutable.List.apply(List.scala:84)
//   ... 33 elided
