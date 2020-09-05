// Dynamic binding in function invocation

class Book(val title: String){
  val coverType: String = "Paperback"
  def cover(cover: String): String = coverType + "_" + cover
}

class Dictionary(name: String) extends Book(name){
  override val coverType: String = "Hardcover"
}

class Encyclopedia(name: String) extends Book(name){
  override val coverType: String = "Blue_Hardcover"
}

object BookApp extends App {
  val dictionary: Book = new Dictionary("Collins")
  val encyclopedia: Book = new Encyclopedia("Britannica")
  val theBoringBook: Book = new Book("TheBoringBook")

  println(s"${dictionary.title} has cover ${dictionary.cover("The Collins Dictionary")}")
  println(s"${encyclopedia.title} has cover ${encyclopedia.cover("Britannica")}")
  println(s"${theBoringBook.title} has cover ${theBoringBook.cover("Some Book")}")
}


// Collins has cover Hardcover_The Collins Dictionary
// Britannica has cover Blue_Hardcover_Britannica
// TheBoringBook has cover Paperback_Some Book
