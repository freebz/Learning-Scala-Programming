// Calling a function

// Passing a variable number of arguments

/*
 * Prints pages with given Indexes for doc
 */
def printPages(doc: Document, indexes: Int*) = for(index <- indexes if index <= doc.numOfPages) print(index)


def average(numbers: Int*): Double = ???


object FunctionCalls extends App {

  def average(numbers: Int*) : Double = numbers.foldLeft(0)((a, c) => a + c) / numbers.length

  def averageV1(numbers: Int*) : Double = numbers.sum / numbers.length

  println(average(2,2))
  println(average(1,2,3))
  println(averageV1(1,2,3))

}

// 2.0
// 2.0
// 2.0


def averageV1(numbers: Int*, wrongArgument: Int): Double = numbers.sum / numbers.length
