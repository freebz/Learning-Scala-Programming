// Either left or right

import java.lang.Exception
import scala.util.{Failure, Success, Try}

object Main extends App {

  def toInt(str: String): Either[String, Int] = Try(str.toInt) match {
    case Success(value) => Right(value)
    case Failure(exp) => Left(s"${exp.toString} occurred," +
        s" You may want to check the string you passed.")
  }

  println(toInt("121"))
  println(toInt("-199"))
  println(toInt("+ -199"))
}


// Right(121)
// Right(-199)
// Left(java.lang.NumberFormatException: For input string: "+ -199" occurred, You may want to check the string you passed.)


sealed abstract class Either[+A, +B] extends Product with Serializable
final case class Right[+A, +B](value: B) extends Either[A, B]
final case class Left[+A, +B](value: A) extends Either[A, B]


import scala.util.{Failure, Success, Try}

object BankApp extends App {

  val accountHolders = Map(
    "1234" -> AccountInfo("Albert", 1000),
    "2345" -> AccountInfo("Bob", 3000),
    "3456" -> AccountInfo("Catherine", 9000),
    "4567" -> AccountInfo("David", 7000)
  )

  def getAccountInfo(id: String): Either[String, AccountInfo] = Try(accountHolders(id)) match {
    case Success(value) => Right(value)
    case Failure(excep) => Left("Couldn't fetch the AccountInfo, Please Check the id passed or try again!")
  }

  def makeTransaction(amount: Double, accountInfo: AccountInfo): Either[String, Double] = Try {
    if(accountInfo.balance < amount) throw new Exception("Not enough account balance!") else accountInfo.balance - amount
  } match {

    case Success(value) => Right(value)
    case Failure(excep) => Left(excep.getMessage)
  }

  println(getAccountInfo("1234").flatMap(actInfo => makeTransaction(100, actInfo)))

  println(getAccountInfo("1234").flatMap(actInfo => makeTransaction(10000, actInfo)))

  println(getAccountInfo("12345").flatMap(actInfo => makeTransaction(100, actInfo)))
}

case class AccountInfo(id: String, balance: Double)


// Right(900.0)
// Left(Not enough account balance!)
// Left(Couldn't fetch the AccountInfo, Please Check the id passed or try again!)


def flatMap[A, B](someValue: Option[A])(functionToPerform: A => Option[B]): Option[B] =
  if (someValue.isEmpty) None else functionToPerform(someValue.get)
