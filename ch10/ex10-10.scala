// Type bounds

class AircraftSeat[-T]


class AircraftSeat[-T <: Passengers]


object Bounds extends App {

  /*
   * AircraftSeats can be consumed only by Passengers.
   */
  class AircraftSeat[-T <: Passengers]

  def reserveSeatForCorporatePassengers(corporateSeats: AircraftSeat[CorporatePassengers]) = {
    //Performs some logic regarding the seat reservation!
    println(s"Seats Confirmed!")
  }

  val corporateSeat = new AircraftSeat[CorporatePassengers]()
  val passengersSeat = new AircraftSeat[Passengers]()

  reserveSeatForCorporatePassengers(new AircraftSeat[CorporatePassengers]())

  reserveSeatForCorporatePassengers(new AircraftSeat[Passengers]())

  abstract class Passengers
  class CorporatePassengers extends Passengers
  class RegularPessengers extends Passengers

}


class Person(name: String)

val seat: AircraftSeat[Person] = new AircraftSeat[Person]()


// type arguments [chapter10.Bounds.Person] do not conform to class AircraftSeat's type parameter bounds [-T <: chapter10.Bounds.Passengers]
//   val seat: AircraftSeat[Person] = new AircraftSeat[Person]()


class ListLikeStructure[T >: AnyRef]


new ListLikeStructure[Any]()
new ListLikeStructure[AnyRef]()


new ListLikeStructure[String]()
// Error:(30, 7) type arguments [String] do not conform to class ListLikeStructure's type parameter bounds [T >: AnyRef]
//   new ListLikeStructure[String]()


abstract class Zero
trait One extends Zero
trait Two extends One
trait Three extends Two
trait Four extends Three


class ListLikeStructure[T >: Four <: Two]


new ListLikeStructure[Four]
new ListLikeStructure[Three]
new ListLikeStructure[Two]


new ListLikeStructure[One]
// type arguments [One] do not conform to class ListLikeStructure's type parameter bounds [T >: Four <: Two]
//    new ListLikeStructure[One]


trait ThinkingInTermsOfT {
  type T <: Two
}
