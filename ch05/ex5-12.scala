// Vector

val vector = Vector(1,2,3)
// vector: scala.collection.immutable.Vector[Int] = Vector(1, 2, 3)

println(vector)
// Vector(1, 2, 3)


vector :+ 4
// res12: scala.collection.immutable.Vector[Int] = Vector(1, 2, 3, 4)

4 +: vector
// res15: scala.collection.immutable.Vector[Int] = Vector(4, 1, 2, 3)


vector(2)
// res16: Int = 3


vector.isDefinedAt(5)
// res17: Boolean = false


vector.updated(2,10)
// res19: scala.collection.immutable.Vector[Int] = Vector(1, 2, 10)
