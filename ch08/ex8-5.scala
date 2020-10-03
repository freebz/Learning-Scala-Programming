// What are closures?

object AClosure extends App {

  var advertisement = "Buy an IPhone7"

  val playingShow = (showName: String) => println(s"Playing $showName. Here's the advertisement: $advertisement")

  playingShow("GOT")
  advertisement = "Buy an IPhone8"

  playingShow("GOF")

}


// Playing GOT. Here's the advertisement: Buy an IPhone7
// Playing GOF. Here's the advertisement: Buy an IPhone8


val printerSwitch = false

def printPages(doc: Document, lastIndex: Int, print: (Int) => Unit) = {

  if(lastIndex <= doc.numOfPages) for(i <- 1 to lastIndex) print(i)

}

val colorPrint = (index: Int) => if(!printerSwitch) println(s"Printing Color Page $index")

val colorPrintV2 = new Function1[Int, Unit]{
  override def apply(index: Int): Unit =
    if(!printerSwitch) println(s"Printing Color Page $index.")
}


val printerSwitch = false

def printPages(doc: Document, lastIndex: Int, print: (Int) => Unit) = {

  if(lastIndex <= doc.numOfPages && !printerSwitch) for(i <- 1 to lastIndex) print(i)

}

val colorPrint = (index: Int) => println(s"Printing Color Page $index.")

val colorPrintV2 = new Function1[Int, Unit]{
  override def apply(index: Int): Unit =
    println(s"Printing Color Page $index.")
}
