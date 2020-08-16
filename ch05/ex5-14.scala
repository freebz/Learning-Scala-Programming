// Immutable queue

val queue = Queue(1,2,3)
// queue: scala.collection.immutable.Queue[Int] = Queue(1, 2, 3)

queue.enqueue(4)
// res27: scala.collection.immutable.Queue[Int] = Queue(1, 2, 3, 4)

queue.dequeue
// res28: (Int, scala.collection.immutable.Queue[Int]) = (1,Queue(2, 3))
