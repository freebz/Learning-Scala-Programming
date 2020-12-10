// Testing in style using ScalaTest

package example

import org.scalatest._

class HelloSpec extends FlatSpec with Matchers {
  "The Hello object" should "say hello" in {
    Hello.greeting shouldEqual "hello"
  }
}


package exmaple

object Hello extends Greeting with App {
  println(greeting)
}

trait Greeting {
  lazy val greeting: String = "hello"
}


package example

import org.scalatest._

abstract class SomeSpec(toBeTested: String) extends FlatSpec with Matchers


package example

class PlayerSpec extends SomeSpec("PlayerService") {

  it should "compile" in {
    """PlayerService.Player("Cristiano Ronaldo", "Portuguese", 32, "Real Madrid")""" should compile
  }
}


object PlayerService extends App {
  case class Player(name: String, nationality: String, age: Int, league: String)
}


package example

class PlayerSpec extends SomeSpec("PlayerSpec") {

  it should "compile" in {
    """PlayerService.Player("Cristiano Ronaldo", "Portuguese", 32, "Real Madrid")""" should compile
  }

  it should "throw an exception when source is wrong" in {
    val src = "some source"
    assertThrows[java.io.FileNotFoundException](PlayerService.readPlayerDataFromSource(src))
  }

  it should "return collection of String when data is read from correct source" in {
    val src = "/Users/vika/Documents/LSProg/LSPWorkspace/First_Proj_Testing/src/main/scala/example/football.csv"
    PlayerService.readPlayerDataFromSource(src) should not be empty
  }

  it should "return None while parsing wrong player string data into player instance" in {
    val data = "some wrong player string"
    PlayerService.parseToPlayer(data) shouldBe None
  }

  it should "return Some Player while parsing player string data into player instance" in {
    val data = """1,1,2,1,2,Cristiano Ronaldo,Portugal,Real Madrid,Spain,32,4829,40,4789,124,63"""
    val player = PlayerService.Player("Cristiano Ronaldo", "Portugal", 32, "Real Madrid")
    PlayerService.parseToPlayer(data) shouldBe Some(player)
  }

}


import scala.util.Try
import scala.util.{Failure, Success}

object PlayerService extends App {

  def readPlayerDataFromSource(src: String): List[String] = {
    val source = io.Source.fromFile(src)

    val list: List[String] = source.getLines().toList
    source.close()
    list
  }

  def parseToPlayer(string: String): Option[Player] = {
    Try {
      val columns = string.split((",")).map(_.trim) Player(columns(5), columns(6), columns(9).toInt, columns(7))
    } match {
      case Success(value) => Some(value)
      case Failure(excep) => None
    }
  }

  case class Player(name: String, nationality: String, age: Int, league: String)
}


// FuncSpec

describe("In PlayerService object") {
  it("should compile") {
    assertCompiles("""PlayerService.Player (
                          "Cristiano Ronaldo",
                          "Portuguese", 32,
                          "Real Madrid")""")
  }
}


// WordSpec

"PlayerService.Player.parseToPlayer" when {
  "wrong parsing data passed" should {
    "return None" in {
      PlayerService.parseToPlayer("some wrong data") shouldBe None
    }
  }
}


// FreeSpec

"PlayerService.Player.parseToPlayer" - {
  "wrong parsing data passed" - {
    "return None" in {
      PlayerService.parseToPlayer("some wrog data") shouldBe NOne
    }
  }
}
