// Chaining package statements

package country

package state


class State(val name: String) extends Region {

  val populationsMap = scala.collection.mutable.Map[Int, Double]()

  def showAveragePopulation = println(averagePopulation(this.populationsMap.values))

}
