// Looping

object PagePrinter extends App {

  /*
   * Prints pages page 1 to lastIndex for doc
   */
  def printPages(doc: Document, lastIndex: Int) = ??? //Yet to be defined

  /*
   * Prints pages page startIndex to lastIndex for doc
   */
  def printPages(doc: Document, startIndex: Int, lastIndex: Int) = ???

  /*
   * Prints pages with given Indexes for doc
   */
  def printPages(doc: Document, indexes: Int*) = ???

  /*
   * Prints pages
   */
  private def print(index: Int) = println(s"Printing Page $index.")

}

/*
 * Declares a Document type with two arguments numOfPages, typeOfDoc
 */
case class Document(numOfPages: Int, typeOfDoc: String)
