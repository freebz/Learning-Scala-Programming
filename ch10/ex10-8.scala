// Variance under inheritance

abstract class Animal()

class Cat(name: String) extends Animal()    // Inheritance relationship between Cat and Animal

// Is it possible to pass an argument that's a list of Cats?
val cats = List(new Cat("Mischief"), new Cat("Birdie"))
doSomethingForAnimals(cats)


class AircraftSeat[-T]


abstract class Passengers
class CorporatePassengers extends Passengers
class RegularPassengers extends Passengers


def reserveSeatForCorporatePassengers(corporateSeats:
    AircraftSeat[CorporatePassengers]) = ??? //Seat booking logic!


object ContraVariance extends App {

  class AircraftSeat[-T]

  def reserveSeatForCorporatePassengers(corporateSeats:
      AircraftSeat[CorporatePassengers]) = {
    //Performs some logic regarding the seat reservation!
    println(s" Seats Confirmed!")
  }

  abstract class Passengers
  class CorporatePassengers extends Passengers
  class RegularPassengers extends Passengers

  reserveSeatForCorporatePassengers(new AircraftSeat[CorporatePassengers])

  reserveSeatForCorporatePassengers(new AircraftSeat[Passengers])

}


// Seats Confirmed!
// Seats Confirmed!


trait Function1[-T1, +R] extends AnyRef {self =>
  /** Apply the body of this function to the argument
    * 
    * @return the result of function application
    */
  def apply(v1: T1): R

}


val func = (i: Int) => i.toString
// func: Int => String = <function1>


new Function1[Int, String]{
  override def apply(v1: Int): String = v1.toString
}
