// Classes

class Country(var name: String, var capital: String)


object CountryApp extends App {
  val country = new Country("France", "Paris")
  println(s"Country Name: ${country.name} and Capital: ${country.capital}")
}


// Country Name: France and Capital: Paris


public class CountryJava {
    private String name;
    private String capital;

    public CountryJava(String name, String capital){
        this.name = name;
        this.capital = capital;
    }

    public void setName(String name){this.name = name;}
    public String getName(){return this.name;}

    public void setCapital(String capital){this.capital = capital;}
    public String getCapital(){return this.capital;}
}


class CountryJavaApp {
    public static void main(String[] args) {
	CountryJava country = new CountryJava("France", "Paris");
	System.out.println("Country Name: " + country.getName() + " and Capital: " + country.getCapital());
    }
}


// Country Name: France and Capital: Paris


class Country(name: String, capital: String)


println(s"Country Name: ${country.name} and Capital: ${country.capital}")


object CountryApp extends App {
  val country = new Country("France", "Paris")
  country.name = "Germany"
  country.capital = "Berlin"
  println(s"Country Name: ${country.name} and Capital: ${country.capital}")
}


// Country Name: Germany and Capital: Berlin


class Country(val name: String, val capital: String)


country.name = "Germany"
country.capital = "Berlin"


case class Country(name: String, capital: String)


class Country(val name: String, val capital: String){
  var populationMap = scala.collection.mutable.Map[String, Double]()

  def getPopulation(year: String): Double = populationMap(year) //In Million
}

object CountryApp extends App {
  val country = new Country("France", "Paris")
  country.populationMap += ("2015" -> 64.39) += ("2016" -> 64.67) += ("2017" -> 64.93)
  println(s"Country Nmae: ${country.name} and Population 2017: ${country.getPopulation("2017")} million")
}


// Country Nmae: France and Population 2017: 64.93 million


public class chapter6.Country {
    public java.lang.String name();
    public void name_$eq(java.lang.String);
    public java.lang.String capital();
    public void capital_$eq(java.lang.String);
    public chapter6.Country(java.lang.String, java.lang.String);
}


object CountryApp extends App {
  val country = new Country("France", "Paris")
  country.name_=("Germany")
  country.capital_=("Berlin")
  println(s"Country Name: ${country.name} and capatia: ${country.capital}")
}


// Country Name: Germany and Capital: Berlin


public class chapter6.Country {
    public java.lang.String name();
    public java.lang.String capital();
    public chapter6.Country(java.lang.String, java.lang.String);
}


private def getPopulation(year: String): Double = populationMap(year)
//In Milion


println(s"Country Name: ${country.name} and Population 2017: ${country.getPopulation("2017")} million")


val country = new Country("France", "Paris")
println(country)


class Country(val name: String, val capital: String){
  override def toString: String = s"Country($name, $capital)"
}


val country = new Country("France", "Paris")
println(country)


// Country(France, Paris)
