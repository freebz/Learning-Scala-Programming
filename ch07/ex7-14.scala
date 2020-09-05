// Nested package statements

import country.Contry

package country {

  import customutil.Util.averagePopulation

  abstract class Region

  class Country(val name: String) extends Region {

    val populationsMap = scala.collection.mutable.Map[Int, Double]()

    def showAveragePopulation() = println(averagePopulation(this.populationsMap.values))

  }

  package state {

    class State(val name: String) extends Region {

      val populationsMap = scala.collection.mutable.Map[Int, Double]()

      def showAveragePopulation() = println(averagePopulation(this.populationsMap.values))

    }

  }
}

package customutil {

  object Util {

    def averagePopulation(populations: Iterable[Double]) = populations.sum / populations.size

  }

}
