// Restricting inheritance - final keyword

class Book(val title: String){
  final val coverType: String = "Paperback"
  def cover(cover: String): String = coverType + "_" + cover
}
