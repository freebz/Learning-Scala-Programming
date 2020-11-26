// Using the Option way

def toInt(str: String): Option[Int] =
  Try(str.toInt) match {
    case Success(value) => Some(value)
    case Failure(_) => None
  }


object Try {
  /*
   * Constructs a 'Try' using the by-name parameter. This
   * method will ensure any non-fatal exception is caught and a
   * 'Failure' object is returned.
   */
  def apply[T](r: => T): Try[T] =
    try Success(r) catch {
      case NonFatal(e) => Failure(e)
    }

}

final case class Success[+T](value: T) extends Try[T]

final case class Failure[+T](exception: Throwable) extends Try[T]


def getAccountInfo(id: String): Option[AccountInfo]

def makeTransaction(amt: Double, accountInfo: AccountInfo): Option[Double]

case class AccountInfo(id: String, balance: Double)


object BankApp extends App {

  val accountHolders = Map(
    "1234" -> AccountInfo("Albert", 1000),
    "2345" -> AccountInfo("Bob", 3000),
    "3456" -> AccountInfo("Catherine", 9000),
    "4567" -> AccountInfo("David", 7000))

  def getAccountInfo(id: String): Option[AccountInfo] =
    Try(accountHolders(id)).toOption

  def makeTransaction(amt: Double, accountInfo: AccountInfo):
      Option[Double] = Try(accountInfo.balance - amt).toOption

  println(getAccountInfo("1234").flatMap(actInfo =>
    makeTransaction(100, actInfo)))

  println(getAccountInfo("12345").flatMap(actInfo =>
    makeTransaction(100, actInfo)))
}

case class AccountInfo(id: String, balance: Double)


// Some(900.0)
// None
