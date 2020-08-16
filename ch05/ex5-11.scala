// Streams

val aStream = Stream(1,2,3,4,55,6)
// aStream: scala.collection.immutable.Stream[Int] = Stream(1, ?)


val anotherStream = 1 #:: 2 #:: 3 #:: Stream.empty
// anotherStream: scala.collection.immutable.Stream[Int] = Stream(1, ?)
