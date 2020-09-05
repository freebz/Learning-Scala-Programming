// Traits

trait Socialize {

  //people who socialize, greets.
  def greet(name: String) = "Hello " + name
}


case class Person(val name: String)

object SocializeApp extends App {
  val person = Person("Victor Mark")
  val employee = new Employee("David Barbara") with Socialize

  println(employee.greet(person.name))

  class Employee(fullName: String) extends Person(fullName)
}


// Hello Victor Mark


public interface chapter7.Socalize {
  public static java.lang.String greet$(chapter7.Socialize, java.lang.String);
  public java.lang.String greet(java.loang.String);
  public static void $init$(chapter7.Socialize);
}


trait Socialize {

  def greet(name: String) = "Hello " + name

  val socialNetworks = Set("Facebook", "LinkedIn", "Twitter", "Instagram", "Youtube")

  def linkToSocialNetwork(network: String, uri: String)
}

object SocializeApp extends App {

  val employee = new Employee("David Barbara")
  employee.linkToSocialNetwork("LinkedIn", "www.linkedin.com/profiles/david_b")

  println(employee.mapOfSocialNetwork)

}

class Employee(fullName: String) extends Person(fullName) with Socialize {

  var mapOfSocialNetwork = new scala.collection.mutable.HashMap[String, String]()

  override val socialNetworks = Set("LinkedIn", "Twitter", "Youtube")
  override def linkToSocialNetwork(network: String, uri: String): Unit =
    if(socialNetworks contains network) mapOfSocialNetwork.put(network, uri)
}

// Map(LinkedIn -> www.linkedin.com/profiles/david_b)
