// Higher-order functions

def sum(a: Int, b: Int) = a + b


object HOFs extends App {
  def multiplier10(x : Int): Int => Int = x => x * 10   //functionAsOutput
  def intOpPerformer(g: Int => Int) : Int = g(5)        //functionAsInput
  def multiplicator(x: Int)(g: Int => Int): Int = g(x)  //functionAsParameter
  println(s"functionAsInput Result: ${intOpPerformer(multiplier10(5))}")
  println(s"functionAsParameter Result: ${multiplicator(5)(multiplier10(5))}")
}


functionAsInput Result: 50
functionAsParameter Result: 50


def printPages(doc: Document, lastIndex: Int, print: (Int) => Unit, isPrinterOn: => Boolean) = {

  if(lastIndex <= doc.numOfPages && isPrinterOn) for(i <- 1 to lastIndex) print(i)

}


printPages(Document(15, "DOCX"), 2, colorPrint, !printerSwitch)

val colorPrint = (index: Int) => println(s"Printing Color Page $index.")


def add(a: Int, b: Int) = a + b

def multiply(a: Int, b: Int) = a * b

def subtract(a: Int, b: Int) = a - b

def modulus(a: Int, b: Int) = a % b


add(10, 5)
subtract(10, 5)
multiply(10, 5)
modulus(10, 5)


val add = (a: Int, b: Int) => a + b
val multiply = (a: Int, b: Int) => a * b
val subtract = (a: Int, b: Int) => a - b
val modulus = (a: Int, b: Int) => a % b


def operation(op: (Int, Int) => Int, a: Int, b: Int) : Int = op(a, b)


operation(add, 10, 5)
operation(subtract, 10, 5)
operation(multiply, 10, 5)
operation(modulus, 10, 5)


object HOFs extends App {

  def operation(op: (Int, Int) => Int, a: Int, b: Int) : Int = op(a,b)

  println(operation((a, b) => a + b, 10, 5))
  println(operation((a, b) => a * b, 10, 5))
  println(operation((a, b) => a - b, 10, 5))
  println(operation((a, b) => a % b, 10, 5))

}


// 15
// 50
// 5
// 0
