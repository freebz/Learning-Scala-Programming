// For expressions

object ForExpressions extends App {

  val person1 = Person("Albert", 21, 'm')
  val person2 = Person("Bob", 25, 'm')
  val person3 = Person("Cyril", 19, 'f')
  val persons = List(person1, person2, person3)

  val winners = for {
    person <- persons
    age = person.age
    name = person.name
    if age > 20
  } yield name

  winners.foreach(println)

  case class Person(name: String, age: Int, gender: Char)
}


// Albert
// Bob


object ForExpressions extends App {

  val person1 = Person("Albert", 21, 'm')
  val person2 = Person("Bob", 25, 'm')
  val person3 = Person("Cyril", 19, 'f')
  val persons = List(person1, person2, person3)

  val winners1 = persons.withFilter(_.age > 20) map (_.name)
  winners1.foreach(println)

  case class Person(name: String, age: Int, gender: Char)

}


case class Car(name: String, brandName: String)
case class Brand(name: String, cars: List[Car])

val brands = List(
  Brand("Toyota", List(Car("Corolia", "Toyota"))),
  Brand("Honda",  List(Car("Accord", "Honda"))),
  Brand("Tesla",  List(Car("Model S", "Tesla"),
                       Car("Model 3", "Tesla"),
                       Car("Model X", "Tesla"),
                       Car("New Model", "Tesla"))))


val teslaCarsStartsWithModel = for {
  brand <- brands
  car <- brand.cars
  if car.name.startsWith("Model") && brand.name == "Tesla"
} yield (brand.name, car.name)

teslaCarsStartsWithModel foreach println


// (Tesla,Model S)
// (Tesla,Model 3)
// (Tesla,Model X)


val teslaCarsStartsWithModel2 = brands.flatMap(brand =>
  brand.cars withFilter(_.name.startsWith("Model") && brand.name == "Tesla") map(car => (brand.name, car.name)))

teslaCarsStartsWithModel2 foreach println


// (Tesla,Model S)
// (Tesla,Model 3)
// (Tesla,Model X)


For(gen1 <- list, gen2 <- gen1.list, filter1)


for {
  brand <- brands
  car <- brand.cars
  if car.name.startsWith("Model") && brand.name == "Tesla"
} yield (brand.name, car.name)


brands.flatMap{ brand =>
  for {
    car <- brand.cars
    if car.name.startsWith("Model") && brand.name == "Tesla"
  } yield (brand.name, car.name)
}


brands.flatMap{ brand =>
  brand.cars.withFilter{ car =>
    car.name.startsWith("Model") && brand.name == "Tesla"
  } map(car => (brand.name, car.name))
}
