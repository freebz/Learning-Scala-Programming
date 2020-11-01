// Matching a constructor

def safeToInt(canBeNumber: String): Option[Int] = {
  try {
    Some(canBeNumber.toInt)
  } catch {
    case NonFatal(e) => None
  }
}

safeToInt("10") match {
  case None => println("Got nothing")
  case Some(value) => println(s"Got $value")
}


// Got 10


trait Employee
case class ContractEmp(id: String, name: String) extends Employee
case class Developer(id: String, name: String) extends Employee
case class Consultant(id: String, name: String) extends Employee

/*
 * Process joining bonus if
 *     :> Developer has ID Starting from "DL"  JB: 1L
 *     :> Consultant has  ID Starting from "CNL":  1L
 */
def processJoiningBonus(employee: Employee, amountCTC: Double) = employee match {
  case ContractEmp(id, _) => amountCTC
  case Developer(id, _) => if(id.startsWith("DL")) amountCTC + 10000.0 else amountCTC
  case Consultant(id, _) => if(id.startsWith("CNL")) amountCTC + 10000.0 else amountCTC
}

val developerEmplEligibleForJB = Developer("DL0001", "Alex")
val consultantEmpEligibleForJB = Consultant("CNL0001", "Henry")
val developer = Developer("DI0002", "Heith")

println(processJoiningBonus(developerEmplEligibleForJB, 55000))
println(processJoiningBonus(consultantEmpEligibleForJB, 65000))
println(processJoiningBonus(developer, 66000))


// 65000.0
// 75000.0
// 66000.0


/*
 * Process joining bonus if
 *     :> Developer has ID Starting from "DL"  JB: 1L
 *     :> Consultant has  ID Starting from "CNL":  1L
 */
def processJoiningBonus(employee: Employee, amountCTC: Double) = employee match {
  case ContractEmp(id, _) => amountCTC
  case Developer(id, _) if id.startsWith("DL") => amountCTC + 10000.0
  case Consultant(id, _) if id.startsWith("CNL") =>  amountCTC + 10000.0
  case _ => amountCTC
}


// 65000.0
// 75000.0
// 66000.0


case class Car(name: String, brand: CarBrand)
case class CarBrand(name: String)

val car = Car("Model X", CarBrand("Tesla"))
var anyCar = Car("Model XYZ", CarBrand("XYZ"))

def matchCar(c: Car) = c match {
  case Car(_, brand @ CarBrand("Tesla")) => println("It's a Tesla Car!")
  case _ => println("It's just a Carrr!!")
}

matchCar(car)
matchCar(anyCar)


// It's a Tesla Car!
// It's just a Carrr!!


def safeToInt(canBeNumber: String): Option[Int] = {
  try {
    Some(canBeNumber.toInt)
  } catch {
    case NonFatal(e) => None
  }
}

safeToInt("10") match {
  case None => println("Got nothing")
  case Some(value) =>  println(s"Get $value")
}
