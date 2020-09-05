// Composition and inheritance

class Book(val title: String)
class Dictionary(name: String) extends Book(name) {
  // data and behavior
}


class Book(val title: String) {
  val chapters = scala.collection.mutable.Set[Chapter]()
  def addChapter(chapter: Chapter) = chapters.add(chapter)
  def pages = chapters.foldLeft(0)((b, c) => b + c.noOfPages)
}

case class Chapter(name: String, sn: Int, noOfPages: Int)

object BookApp extends App {
  val book = new Book("The New Book")
  book.addChapter(Chapter("Chapter1", 1, 15))
  book.addChapter(Chapter("Chapter2", 2, 13))
  book.addChapter(Chapter("Chapter3", 3, 17))

  println(book.title)
  println(book.pages)
}
