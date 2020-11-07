// Here comes type parameterization

def serveMeal[A, B](serveTo: A, serveThis: Option[B]) = ???


serveMeal(Human(Category("MALE")), None)
serveMeal(Human(Category("FEMALE")), Some(Food()))
serveMeal(Animal(), None)
serveMeal(Animal(), Some("NONVEG"))

case class Human(category: Category)
case class Category(name: String)
case class Animal()
case class Food()


def serveMeal[A, B](serveTo: A, serveThis: Option[B]) = ???


serveMeal(Human(Category("MALE")): Human, None: Option[Food])
serveMeal(Human(Category("FEMALE")): Human, Some(Food()): Option[Food])
serveMeal(Animal() : Animal, None: Option[Food])
serveMeal(Animal(): Animal, Some(Food()): Option[Food])
