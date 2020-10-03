// Function literals

(value1: Int, value2: Int) => Int


def printPages(doc: Document, lastIndex: Int, print: (Int) => Unit) = if(lastIndex <= doc.numOfPages) for(i <- 1 to lastIndex) print(i)

val colorPrint = (index: Int) => println(s"Printing Color Page $index.")

val simplePrint = (index: Int) => println(s"Printing Simple Page $index.")

println("----------Method V1----------")
printPages(Document(15, "DOCX"), 5, colorPrint)

println("----------Method V2----------")
printPages(Document(15, "DOCX"), 2, simplePrint)


def printColorPages(doc: Document, lastIndex: Int, startIndex: Int) = if(lastIndex <= doc.numOfPages) for(i <- startIndex to lastIndex) colorPrint(i)

def printSimplePages(doc: Document, lastIndex: Int, startIndex: Int) = if(lastIndex <= doc.numOfPages) for(i <- startIndex to lastIndex) simplePrint(i)


def printPages(doc: Document, lastIndex: Int, print: (Int) => Unit) = if(lastIndex <= doc.numOfPages) for(i <- 1 to lastIndex) print(i)


trait Function1[-T1, +R] extends AnyRef


public static scala.Function1<java.lang.Object, scala.runtime.BoxedUnit> colorPrint()

public static void printPages(chapter4.Document, int,
  scala.Function1<java.lang.Object, scala.runtime.BoxedUnit>,
  scala.Function0<java.lang.Object>)


def andThen[A](g: (R) => A): (T1) => A
def compose[A](g: (A) => T1): (A) => R


val incrementByOne = (num: Int) => num + 1
val isEven = (num: Int) => num % 2 == 0
val incrementAndCheckForEven = incrementByOne andThen isEven
println(s"Representing andThen function ${incrementAndCheckForEven(1)}")


def andThen[A](g: (R) => A): (T1) => A
