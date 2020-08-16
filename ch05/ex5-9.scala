// Map

val aMap = Map(1 -> "one", 2 -> "two", 3 -> "three")
// aMap: scala.collection.immutable.Map[Int,String] = Map(1 -> one, 2 -> two, 3 -> three)


aMap.+(4 -> "four")
// res5: scala.collection.immutable.Map[Int,String] = Map(1 -> one, 2 -> two, 3 -> three, 4 -> four)


println(aMap)
// Map(1 -> one, 2 -> two, 3 -> three)


aMap.isDefinedAt(4)
// res8: Boolean = false

aMap.isDefinedAt(2)
// res9: Boolean = true
