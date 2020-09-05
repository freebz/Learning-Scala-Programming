// Default and parameterized constructors

import java.time.LocalDate

case class Employee(name: String, id: String, contact: String, email: String)

case class StartUp(name: String, founder: Employee, coFounders: Option[Set[Employee]],
members: Option[List[Employee]], foundingDate: Option[LocalDate])


case class StartUp(name: String, founder: Employee, coFounders: Option[Set[Employee]],
members: Option[List[Employee]], foundingDate: Option[LocalDate]){

  //founder | name
  def this(name: String, founder: Employee) = this(name, founder, None, None, None)

  //founder | foundingDate
  def this(name: String, founder: Employee, foundingDate: LocalDate) = this(name, founder, None, None, Some(foundingDate))

  //founder | coFounders
  def this(name: String, founder: Employee, coFounders: Set[Employee]) = this(name, founder, Some(coFounders), None, None)

  //founder | coFounders | members
  def this(name: String, founder: Employee, coFounders: Set[Employee], members: List[Employee]) =
    this(name, founder, Some(coFounders), Some(members), None)

  //founder | coFounders | foundingDate
  def this(name: String, founder: Employee, coFounders: Set[Employee], foundingDate: LocalDate) =
    this(name, founder, Some(coFounders), None, Some(foundingDate))

  //founder | members    | foundingDate
  def this(name: String, founder: Employee, members: List[Employee], foundingDate: LocalDate) =
    this(name, founder, None, Some(members), Some(foundingDate))

}


object StartUpApp extends App {

  val startUpWithFoundingDate = new StartUp("WSup", Employee("Rahul Sharma", "RH_ID_1", "9090000321", "rahul_sharma@abc.com"), LocalDate.now())

  println(s"${startUpWithFoundingDate.name} founded on ${startUpWithFoundingDate.foundingDate.get} by ${startUpWithFoundingDate.founder.name}")

  val startUp = new StartUp("Taken", Employee("David Barbara", "DB_ID_1", "9090654321", "david_b@abc.com"))

  println(s"${startUp.name} founded by ${startUp.founder.name}")
}


// WSup founded on Sun Jun 13 20:29:00 IST 2016 by Rahul Sharma
// Taken founded by David Barbara


object StartUpApp extends App {

  val startUp = StartUp("Taken", Employee("David Barbara", "DB_ID_1", "9090654321", "david_b@abc.com"))
  println(s"${startUp.name} founded by ${startUp.founder.name}")
}


// Error(30, 24) not enough arguments for method apply: (name: String, founder: Employee, coFounders: Option[Set[Employee]], members: Option[List[Employee]], foundingDate: Option[java.time.LocalDate])StartUp in object StartUp.
//   Unspecified value parameters coFounders, members, foundingDate.
// val startUp = StartUp("Taken", Employee("David Barbara", "DB_ID_1", "9090654321", "david_b@abc.com"))


object StartUp {

  def apply(name: String, founder: Employee): StartUp = new StartUp(name, founder, None, None, None)
}


object StartUpApp extends App {

  val startUp = StartUp("Taken", Employee("David Barbara", "DB_ID_1", "9090654321", "david_b@abc.com"))

  println(s"${startUp.name} founded by ${startUp.founder.name}")
}


// Taken founded by David Barbara
