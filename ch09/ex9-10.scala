// Type parameterization

object TypeParameterization {

  def main(args: Array[String]): Unit = {
    val mayBeAnInteger = Some("101")
    val mayBeADouble = Some("101.0")
    val mayBeTrue = Some("true")

    println(s"Calling mapToInt: ${mapToInt(mayBeAnInteger, (x: String) => x.toInt)}")
    println(s"Calling mapToDouble: ${mapToDouble(mayBeADouble, (x: String) => x.toDouble)}")
    println(s"Calling mapToBoolean: ${mapToBoolean(mayBeTrue, (x: String) => x.toBoolean)}")
  }
  def mapToInt(mayBeInt: Option[String], function: String => Int) = function(mayBeInt.get)

  def mapToDouble(mayBeDouble: Option[String], function: String => Double) = function(mayBeDouble.get)

  def mapToBoolean(mayBeBoolean: Option[String], function: String => Boolean) = function(mayBeBoolean.get)
}


// Calling mapToInt: 101
// Calling mapToDouble: 101.0
// Calling mapToBoolean: true


def mapToValue[A, B](mayBeValue: Option[A], function: A => B) : B = function(mayBeValue.get)


def map[B](f: A => B): Option[B] = if (isEmpty)
    None
  else
    Some(f(this.get))
