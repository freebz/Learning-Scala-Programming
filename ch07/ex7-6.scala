// Misusing inheritance

class CustomStack extends util.ArrayList[String] {
  def push(value: String) = ???
  def pop = ???
}
