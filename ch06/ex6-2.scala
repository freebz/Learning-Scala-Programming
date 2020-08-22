// Abstract classes

abstract class Person

class Customer extends Person

class Employee extends Person


abstract class Person(category: String) {
  val idPrefix: String
}

class Customer extends Person("External") {
  override val idPrefix: String = "CUST"
}

class Employee extends Person("Internal") {
  override val idPrefix: String = "EMP"
}
