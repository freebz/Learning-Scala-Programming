// Multiple package statements in a file

import country.Country

import customutil.Util.averagePopulation

package country {

  class Country(val name: String) {

    val populationsMap = scala.collection.mutable.Map[Int, Double]()

    def showAveragePopulation() = println(averagePopulation(this.populationsMap.values))
  }

}

package state {

  class State(val name: String) {

    val populationsMap = scala.collection.mutable.Map[Int, Double]()

    def showAveragePopulation() = println(averagePopulation(this.populationsMap.values))
  }

}

package Util {

  object Util {

    def averagePopulation(populations: Iterable[Double]) = populations.sum / populations.size


  }

}
