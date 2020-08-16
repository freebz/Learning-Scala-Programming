// Immutable stack

val stack = Stack(1,2,3)
// stack: scala.collection.immutable.Stack[Int] = Stack(1, 2, 3)

stack.pop
// res24: scala.collection.immutable.Stack[Int] = Stack(2, 3)

stack.push(4)
// res26: scala.collection.immutable.Stack[Int] = Stack(4, 1, 2, 3)
