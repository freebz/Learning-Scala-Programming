// Case classes

class Country(val name: String, val capital: String) {

  override def toString: String = s"Country($name,$capital)"

  override def equals(obj: scala.Any): Boolean = ???

  override def hashCode(): Int = ???

}


case class Country(name: String, capital: String)


case class Country(name: String, capital: String)

object CountryUtil extends App {
  val country = Country("France", "Paris")
  println(s"Our country is: $country")

  println(s"Equality => ${country == country}")

  println(s"HashCode for country instance: ${country.hashCode()}")
}


// Our country is: Country(France,Paris)
// Equality => true
// HashCode for country instance: -66065175


public final class chapter6.Country$ extends
scala.runtime.AbstractFunction2<java.lang.String, java.lang.String, chapter6.Country>
implements scala.Serializable {
  public static chapter6.Country$ MODULES$;
  public static {};
  public final java.lang.String toString();
  public chapter6.Country apply(java.lang.String, java.lang.String);
  public scala.Option<scala.Tuple2<java.lang.String, java.lang.String>> unapply(chapter6.Country);
  public java.lang.Object apply(java.lang.Object, java.lang.Object);
}


public class chapter6.Country implements scala.Product.,scala.Serializable {
  public static scala.Option<scala.Tuple2<java.lang.String, java.lang.String>> unapply(chapter6.Country);
  public static chapter6.Country apply(java.lang.String, java.lang.String);
  public static scala.Function1<scala.Tuple2<java.lang.String, scala.Function1<java.lang.String, chapter6.Country>> curried();
  public java.lang.String name();
  public java.lang.String capital();
  public chapter6.Country copy(java.lang.String, java.lang.String);
  public java.lang.String copy$default$1();
  public java.lang.String copy$default$2();
  public java.lang.String productPrefix();
  public int productArity();
  public java.lang.Object productElement(int);
  public scala.collection.Iterator<java.lang.Object> productIterator();
  public boolean canEqual(java.lang.Object);
  public int hashCode();
  public java.lang.String toString();
  public boolean equals(java.lang.Object);
  public chapter6.Country(java.lang.String, java.lang.String);
}


package chapter6

object CountryUtil extends App {
  case class Country(name: String, capital: String)
  val country = Country("France", "Paris")
  println(s"Country: => $country")
  println(s"Equality: => ${country == country}")
  println(s"HashCode: => ${country.hashCode()}")

  println(s"Unapply: => ${Country.unapply(country)}")
  println(s"apply: => ${Country.apply("Germany","Berlin")}")

  println(s"copy: => ${country.copy("Germany","Berlin")}")
  println(s"copyName: => ${country.copy(name="Germany")}")
  println(s"copyCapital: => ${country.copy(capital="Berlin")}")

  println(s"productArity: => ${country.productArity}")
  println(s"productPrefix: => ${country.productPrefix}")
  println(s"productElement(0): => ${country.productElement(0)}")
  println(s"productElement(1): => ${country.productElement(1)}")
}


// Country: => Country(France,Paris)
// Equality: => true
// HashCode: => -66065175
// Unapply: => Some((France,Paris))
// apply: => Country(Germany,Berlin)
// copy: => Country(Germany,Berlin)
// copyName: => Country(Germany,Paris)
// copyCapital: => Country(France,Berlin)
// productArity: => 2
// productPrefix: => Country
// productElement(0): => France
// productElement(1): => Paris


case class Country(name: String, capital: String)
val country = Country("France", "Paris")

country match {
  case Country("Germany", _) => println(s"It's Germany")
  case Country("France", _) => println(s"It's France")
  case Country(_, _) => println(s"It's some country")
}


// It's France


package chapter6

object CountryUtil extends App {
  case class Country(name: String, capital: String)
  val country = Country("France", "Paris")
}

class Country(name: String, capital: String)


package chapter6
case class Country(name: String, capital: String)

object CountryUtil extends App {
  val country = Country("France", "Paris")
}

class Country(name: String, capital: String)


// Country is already defined in scope


abstract class Continent
case class Country(name: String, capital: String) extends Continent
