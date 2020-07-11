// Function literals

def compareIntegersV6(value1: Int = 10, value2: Int): Int = ???
// (value1: Int, value2: Int) => Int


val compareFuncLiteral = (value1: Int, value2: Int) => if (value1 == value2) 0 else if (value1 > value2) 1 else -1


private def print(index: Int) = println(s"Printing Page $index.")
// (index: Int) => Unit


object ColorPrinter extends App {

  def printPages(doc: Document, lastIndex: Int, print: (Int) => Unit) = if(lastIndex <= doc.numOfPages) for (i <- 1 to lastIndex) print(i)

  val colorPrint = (index: Int) => println(s"Printing Color Page $index.")

  val simplePrint = (index: Int) => println(s"Printing Simple Page $index.")

  println("----------Method V1----------")
  printPages(Document(15, "DOCX"), 5, colorPrint)

  println("----------Method V2----------")
  printPages(Document(15, "DOCX"), 2, simplePrint)
}

case class Document(numOfPages: Int, typeOfDoc: String)


// ----------Method V1----------
// Printing Color Page 1.
// Printing Color Page 2.
// Printing Color Page 3.
// Printing Color Page 4.
// Printing Color Page 5.
// ----------Method V2----------
// Printing Simple Page 1.
// Printing Simple Page 2.


val names = List("Alice", "Allen", "Bob", "Catherine", "Alex")
// names: List[String] = List(Alice, Allen, Bob, Catherine, Alex)

val nameStartsWithA = names.filter((name) => name.startsWith("A"))
// nameStartsWithA: List[String] = List(Alice, Allen, Alex)


val nameStartsWithA = names.filter(_.startsWith("A"))
// nameStartsWithA: List[String] = List(Alice, Allen, Alex)
