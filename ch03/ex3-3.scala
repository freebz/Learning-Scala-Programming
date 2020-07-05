// The while Loop

val stocks = List("APL", "GOOG", "JLR", "TESLA")
// stocks: List[String] = List(APL, GOOG, JLR, TESLA)

val iteratorForStocks = stocks.iterator
// iteratorForStocks: Iterator[String] = non-empty iterator

while(iteratorForStocks.hasNext) println(iteratorForStocks.next())
// APL
// GOOG
// JLR
// TESLA
