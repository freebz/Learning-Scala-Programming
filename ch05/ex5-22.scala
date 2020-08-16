// ParVector

val parvec = Vector(1,2,3,4,5,6,7,8,9,10)
// parvec: scala.collection.immutable.Vector[Int] = Vector(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)


parvec.filter(_ > 5)
// res0: scala.collection.immutable.Vector[Int] = Vector(6, 7, 8, 9, 10)

parvec.seq
// res1: scala.collection.immutable.IndexedSeq[Int] = Vector(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
