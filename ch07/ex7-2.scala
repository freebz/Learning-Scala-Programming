// Class inheritance

// Extending classes

class Book(val title: String) {
  // data and behaviour for Book
}

class Dictionary(name: String) extends Book(name) {
  // data and behaviour for dictionary
}

object BookApp extends App {
  val dictionary = new Dictionary("Collins")
  println(dictionary.title)
}


// Collins
