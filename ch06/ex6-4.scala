// Objects as singletons

object CountryUtil {

}


object CountryUtil {
  /*
   * Function takes a sequence of population per million and returns average.
   * */
  def populationAverage(pops: Seq[Double]) = pops.sum / pops.length
}

object CountryApp extends App {
  val country = new Country("France", "Paris")
  country.populationMap += ("2015" -> 64.39) += ("2016" -> 64.67) += ("2017" -> 64.93)

  println(s"Country Name: ${country.name} and Population 2017: ${country.getPopulation("2017")} million")

  println(s"${country.name}'s average population: ${CountryUtil.populationAverage(country.populationMap.values.toSeq)}")

}


// Country Name: France and Population 2017: 64.93 million
// France's average population: 64.66333333333334


class WeCant extends CountryUtil {
}
// Sorry we can't extend from an object


public final class chapter6.CountryUtil {
  public static double populationAverage(scala.collection.Seq<java.lang.Object>);
}


public final class chapter6.CountryUtil$ {
  public static chapter6.CountryUtil$ MODULE$;
  public static {};
  public double populationAverage(scala.collection.Seq<java.lang.Object>);
}


class Continent

object CountryUtil extends Continent {
      // some code here
}


import java.time.LocalDate
import java.time.format.{DateTimeFormatter, TextStyle}
import java.util.Locale
import scala.util.{Failure, Success, Try}

object DateUtil {
  /*
   * Just pass a date with format DD/MM/YYYY, get back DAY_OF_WEEK
   * */
  def dayOfWeek(date: String): Option[String] = Try{
    LocalDate.parse(date, DateTimeFormatter.ofPattern("dd/MM/yyyy")).getDayOfWeek
  } match {
    case Success(dayOfWeek) => Some(dayOfWeek.getDisplayName(TextStyle.FULL, Locale.ENGLISH))
    case Failure(exp) => exp.printStackTrace; None
  }
}

object TestDateUtil extends App {
  import DateUtil._

  val date = "01/01/1992"

  dayOfWeek(date) match {
    case Some(dow) => println(s"It was $dow on $date")
    case None => println(s"Something went wrong!")
  }

}


// It was Wednesday on 01/01/1992
