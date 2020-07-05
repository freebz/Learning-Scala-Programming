// The for loop

val stocks = List("APL", "GOOG", "JLR", "TESLA")
// stocks: List[String] = List(APL, GOOG, JLR, TESLA)

stocks.foreach(x => println(x))
// APL
// GOOG
// JLR
// TESLA


object PagePrinter extends App{

  /*
   * Prints pages page 1 to lastIndex for doc
   */
  def printPages(doc: Document, lastIndex: Int) = if(lastIndex <= doc.numOfPages) for(i <- 1 to lastIndex) print(i)

  /*
   * Prints pages page startIndex to lastIndex for doc
   */
  def printPages(doc: Document, startIndex: Int, lastIndex: Int) = if(lastIndex <= doc.numOfPages && startIndex > 0 && startIndex < lastIndex) for(i <- startIndex to lastIndex) print(i)

  /*
   * Prints pages with given Indexes for doc
   */
  def printPages(doc: Document, indexes: Int*) = for(index <- indexes if index <= doc.numOfPages && index > -1) print(index)

  /*
   * Prints pages
   */
  private def print(index: Int) = println(s"Printing Page $index.")

  println("----------Method V1----------")
  printPages(Document(15, "DOCX"), 5)

  println("----------Method V2----------")
  printPages(Document(15, "DOCX"), 2, 5)

  println("----------Method V3----------")
  printPages(Document(15, "DOCX"), 2, 5, 7, 15)

}

/*
 * Declares a Document type with two arguments numOfPages, typeOfDoc
 */
case class Document(numOfPages: Int, typeOfDoc: String)


// ----------Method V1----------
// Printing Page 1.
// Printing Page 2.
// Printing Page 3.
// Printing Page 4.
// Printing Page 5.
// ----------Method V2----------
// Printing Page 2.
// Printing Page 3.
// Printing Page 4.
// Printing Page 5.
// ----------Method V3----------
// Printing Page 2.
// Printing Page 5.
// Printing Page 7.
// Printing Page 15.
