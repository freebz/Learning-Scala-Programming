// Ranges

val oneTo10 = 1 to 10
// oneTo10: scala.collection.immutable.Range.Inclusive = Range(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

val oneTo10By2 = 1 to 10 by 2
// oneTo10By2: scala.collection.immutable.Range = Range(1, 3, 5, 7, 9)

oneTo10 foreach println
// 1
// 2
// 3
// 4
// ... remaining elements

oneTo10By2 foreach println
// 1
// 3
// 5
// 7
// 9


val oneUntil5 = 1 until 5
// oneUntil5: scala.collection.immutable.Range = Range(1, 2, 3, 4)

oneUntil5 foreach println
// 1
// 2
// 3
// 4
