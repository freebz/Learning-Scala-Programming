// Visibility rules

class Restaurant

package privaterestaurant {

  class class Dish(name: String)

  trait Kitchen {
    self: PrivateRestaurant =>

    private val secret = "Secret to tasty dish" //Think of a secret logical evaluation resulting in value, we don't want to expose.

    def cookMyDish: Option[Dish] = Some(Dish(secret))
  }

  class PrivateRestaurant extends Kitchen {

    def serveDishWithSecret = Dish(secret) // Symbol secret is inaccessible from this place.

    def serveDish = cookMyDish // Works fine
  }

}


class Restaurant

package privaterestaurant {

  trait Kitchen {

    self: Restaurant =>

    private[privaterestaurant] val secret = "Secret to tasty dish" //Think of a secret logical evaluation resulting in value, we don't want to expose.

    def cookMyDish: Option[Dish] = Some(Dish(secret))
  }

  class PrivateRestaurant extends Restaurant with Kitchen {
    def serveDishWithSecret = Dish(secret) // Symbol secret is inaccessible from this place.

    def serveDish = cookMyDish // Works fine
  }

}

package protectedrestaurant {

  import restaurant.privaterestaurant.Kitchen

  class ProtectedRestaurant extends Restaurant with Kitchen {

    def serveDishWithSecret = Dish(secret) // Symbol secret is inaccessible from this place.

    def serveDish = cookMyDish // Works fine

  }
}
