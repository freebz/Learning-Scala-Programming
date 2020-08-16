// Commonly used collections in Scala

// List

val aList = List(1,2,3,4)


1 :: 2 :: 3 :: 4 :: Nil


aList.::(5)
// res2: List[Int] = List(5, 1, 2, 3, 4)


5 :: aList
// res0: List[Int] = List(5, 1, 2, 3, 4)
