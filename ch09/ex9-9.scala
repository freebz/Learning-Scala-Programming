// Combinators

val brands = List(Brand("Toyota", List(Car("Corolla", "Toyota"))),
                  Brand("Honda", List(Car("Accord", "Honda"))),
                  Brand("Tesla", List(Car("Model S", "Tesla"),
                                      Car("Model 3", "Tesla"),
                                      Car("Model X", "Tesla"),
                                      Car("New Model", "Tesla"))))

brands.foreach((b: Bran d) => {
  //Take the brand name, and check the number of Cars and print them.
  val brandName = b.name
  println(s"Brand: $brandName || Total Cars:${b.casrs.length}")
  (brandName, b.cars)
})


creditCards.filter(_.limit < 55000)
  .map(cc => cc.accounts(cc.holder))
  .filter(_.isLinkedAccount)
  .get
  .info
