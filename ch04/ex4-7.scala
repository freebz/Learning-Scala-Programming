// Evaluation strategies

// Call by name

def printPages(doc: Document, lastIndex: Int, print: (Int) => Unit, isPrinterOn: () => Boolean) = {

  if(lastIndex <= doc.numOfPages && isPrinterOn()) for(i <- 1 to lastIndex) print(i)

}


printPages(Document(15, "DOCX"), 16, colorPrint, () => !printerSwitch)


object ColorPrinter extends App {

  val printerSwitch = false

  def printPages(doc: Document, lastIndex: Int, print: (Int) => Unit, isPrinterOn: => Boolean) = {

    if(lastIndex <= doc.numOfPages && isPrinterOn) for (i <- 1 to lastIndex) print(i)

  }

  val colorPrint = (index: Int) => {
    println(s"Printing Color Page $index.")
  }

  println("----------Method V1----------")
  printPages(Document(15, "DOCX"), 2, colorPrint, !printerSwitch)
}

case class Document(numOfPages: Int, typeOfDoc: String)


// ----------Method V1----------
// Printing Color Page 1.
// Printing Color Page 2.


printPages(Document(15, "DOCX"), 16, colorPrint, !printerSwitch)
