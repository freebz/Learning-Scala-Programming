// Companion objects

class Country(val name: String, val capital: String){
  var populationMap = scala.collection.mutable.Map[String, Double]()
  def getPopulation(year: String): Double = populationMap(year) //In Million

  override def toString: String = s"Country($name,$capital)"
}

object Country {
  /*
   * Function takes a sequence of population per million and returns average.
   * */
  def populationAverage(pops: Seq[Double]) = pops.sum / pops.length
}

object CountryApp extends App {
  val country = new Country("France", "Paris")
  country.populationMap += ("2015" -> 64.39) += ("2016" -> 64.67) += ("2017" -> 64.93)

  println(s"Country Name: ${country.name} and Population 2017: ${country.getPopulation("2017")} million")

  println(s"${country.name}'s average population: ${Country.populationAverage(country.populationMap.values.toSeq)}")
}


import java.time.LocalDate
import java.time.format.DateTimeFormatter

class Date(val dateStr: String) {
  override def toString: String = s"Date(${this.dateStr})"
}

object Date{
  def apply(str: String): Date = {
    val dater = LocalDate.parse(str, DateTimeFormatter.ofPattern("dd/MM/yyyy"))
    new Date(s"${dater.getDayOfWeek} ${dater.getDayOfMonth}-${dater.getMonth}-${dater.getYear}")
  }
}

object DateApp extends App {
  val date = Date("01/01/1992")
  println(date)
}


// Date(WEDNESDAY 1-JANUARY-1992)


val date = Date("01/01/1992")


class Country(val name: String, val capital: String) {

  override def toString: String = s"Country($name,$capital)"

  override def equals(obj: scala.Any): Boolean = ???

  override def hashCode(): Int = ???

}
