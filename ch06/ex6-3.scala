// Abstract classes and traits

trait Person {
  val category: String
  val idPrefix: String
}

class Customer extends Person {
  override val category: String = "External"
  override val idPrefix: String = "CUST"
}

class Employee extends Person {
  override val category: String = "Internal"
  override val idPrefix: String = "EMP"
}


trait Person(category: String) //can't give cons params
