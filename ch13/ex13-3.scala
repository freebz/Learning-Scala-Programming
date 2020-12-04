// Asynchronous programming

// Working with Futures

import scala.concurrent._
import scala.concurrent.ExecutionContext.Implicits.global

object FutureExample extends App {

  val fileSource = "/Users/vika/Documents/LSProg/LSPWorkspace/FirstProject/src/chapter5/football_stats.csv"

  def listOfPlayers(): Future[List[Player]] = Future {
    val source = io.Source.fromFile(fileSource)
    val list = source.getLines().toList
    source.close()
    giveMePlayers(list)
  }

  println(s"listOfPlayers completed: ${listOfPlayers.isCompleted}")

  Thread.sleep(5000)

  println(s"listOfPlayers completed: ${listOfPlayers.isCompleted}")

  def giveMePlayers(list: List[String]): List[Player] = list match {
    case head :: tail => tail map {line =>
      val columns = line.split((",")).map(_.trim)
      Player(columns(5),columns(6),columns(9),columns(7),
        columns(8),columns(10), columns(12), columns(0),columns(2))
    }
    case Nil => List[Player]()
  }

}

case class Player(name: String, nationality: String, age:String, club: String,
  domesticLeague: String, rawTotal: String, finalScore: String, ranking2016: String,
  ranking2015: String)


// listOfPlayers completed: false
// listOfPlayers completed: true


import scala.concurrent._
import scala.concurrent.ExecutionContext.Implicits.global

object FutureExample extends App {

  val fileSource = "/Users/vika/Documents/LSProg/LSPWorkspace/FirstProject/src/chapter13/football_stats.csv"

  val listOfPlayers: Future[List[Player]] = Future {
    val source = io.Source.fromFile(fileSource)
    val list = source.getLines().toList

    source.close()

    giveMePlayers(list)
  }

  def giveMePlayers(list: List[String]): List[Player] = list match {
    case head :: tail => tail map {line =>
      val columns = line.split((",")).map(_.trim)
      Player(columns(5),columns(6),columns(9),columns(7)
        columns(8),columns(10), columns(12), columns(0),columns(2))
    }
    case Nil => List[Player]()
  }

  // Registering a callback
  listOfPlayers foreach {
    case list => list foreach println
  }

  Thread.sleep(5000)

}

case class Player(name: String, nationality: String, age: String, club: String,
  domesticLeague: String, rawTotal: String, finalScore: String, ranking2016: String,
  ranking2015: String)
