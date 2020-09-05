// Subtyping versus subclassing

// Overriding data and behaviour

class Book(val title: String){
  def cover(cover: String): String = "Paperback_" + cover
}

class Dictionary(name: String) extends Book(name){
  // wants to define its own version of cover method
}


class Dictionary(name: String) extends Book(name){
  override def cover(cover: String): String = "Hardcover_" + cover
}

object BookApp extends App {
  val dictionary = new Dictionary("Collins")
  println(dictionary.title)
  println(dictionary.cover("The Collins Dictionary"))
}


// Collins
// Hardcover_The Collins Dictionary


class Book(val title: String){
  def coverType: String = "Paperback"
  def cover(cover: String): String = coverType + "_" + cover
}

class Dictionary(name: String) extends Book(name){
  override val coverType: String = "Hardcover"
}
