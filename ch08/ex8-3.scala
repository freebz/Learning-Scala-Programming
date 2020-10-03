// Functions versus methods

val colorPrint = (index: Int) => println(s"Printing Color Page $index.")

val colorPrintV2 = new Function1[Int, Unit]{
  override def apply(index: Int): Unit =
    println(s"Printing Color Page $index.")
}

def colorPrintV3(index: Int) = println(s"Printing Color Page $index.")


println("----------Function V1----------")
printPages(Document(15, "DOCX"), 2, colorPrint)

println("----------Function V2----------")
printPages(Document(15, "DOCX"), 2, colorPrintV2)

println("----------Method V3----------")
printPages(Document(15, "DOCX"), 2, colorPrintV3)


// ----------Function V1----------
// Printing Color Page 1.
// Printing Color Page 2.
// ----------Function V2----------
// Printing Color Page 1.
// Printing Color Page 2.
// ----------Method V3----------
// Printing Color Page 1.
// Printing Color Page 2.


:> javap ColorPrinter.class
Compiled from "FuncLiterals.scala"
public final class chapter4.ColorPrinter {
  public static void main(java.lang.String[]);
  public static void delayedInit(scala.Function0<scala.runtime.BoxedUnit>);
  public static void delayedEndpoint$chapter4$ColorPrinter$1();
  public static long executionStart();

  public static void colorPrintV3(int);

  public static scala.Function1<java.lang.Object, scala.runtime.BoxedUnit> colorPrintV2();

  public static scala.Function1<java.lang.Object, scala.runtime.BoxedUnit> colorPrint();

  public static void printPages(chapter4.Document, int, scala.Function1<java.lang.Object, scala.runtime.BoxedUnit>, scala.Function0<java.lang.Object>);

  public static boolean printerSwitch();
}


colorPrintV2(3)


new Function1[Int, Unit]().apply(3)


colorPrint == colorPrintV2 //false


colorPrint == colorPrintV3 //Compile Time Error


val colorPrintV4 = colorPrintV3 _
