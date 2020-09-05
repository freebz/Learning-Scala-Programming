// Packaging and importing

// Package statements

package country

class Country(val name: String) {

  import Country._

  val populationsMap = scala.collection.mutable.Map[Int, Double]()

  def showAveragePopulation() = println(averagePopulation(this.populationsMap.values))
}

object Country {
  def averagePopulation(populations: Iterable[Double]) = populations.sum / populations.size

}


import country.Country._
