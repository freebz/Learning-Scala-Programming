// Reactive programming

// Reactive extensions

// React to RxScala

// Creating Observables

package example

import rx.lang.scala.Observable
import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._

object FirstRxApp extends App {

  //Creates an empty Observable.
  val emptyObservable = Observable.empty

  //Creates an Observable that only emits 1.
  val numObservable = Observable.just(1)

  val sequence = List(1, 3, 5, 7, 9)

  //Creates an Observable, which emits values from the sequence mentioned.
  val sequenceObservable = Observable.from(sequence)

  val someAsyncComputation = Future { 1 }
  //Creates an Observable, from an async computation
  val fromAsyncObservable = Observable.from(someAsyncComputation)

  //Creates an Observable, which emits items at a duration gap specified.
  val intervalObservables = Observable.interval(200 millis)

  //Creates an Observable, which starts emitting, onec some observer subscribe to it.
  val deferObservable = Observable.defer(fromAsyncObservable)

  //Creates an Observable, which never emits any value.
  val neverObservable = Observable.never


  import rx.Subscription
  import rx.observers.TestSubscriber


  //Subscribing to Observables
  emptyObservable
    .subscribe(value => println(s"From emptyObservable: $value"))

  numObservable
    .subscribe(value => println(s"From numObservable: $value"))

  sequenceObservable
    .subscribe(value => println(s"From sequenceObservable: $value"))

  fromAsyncObservable
    .subscribe(value => println(s"From fromAsyncObservable: $value"))

  intervalObservables
    .subscribe(value => println(value))
  Thread.sleep(1000)

  new TestSubscriber[Subscription].awaitTerminalEvent(1000, MILLISECONDS)

  deferObservable
    .subscribe(value => println(s"From deferObservable: $value"))
}


package example

import rx.lang.scala.Observable

object SmartApp extends App {

  val src = "/Users/vika/Documents/LSProg/LSPWorkspace/First_Proj_Rx/src/main/scala/example/football.csv"

  val playerObservable
    .map(playerString =>
      PlayerService.parseToPlayer(playerString))
    .subscribe(player => PlayerService.showPlayerInformation(player),
      error => println(s"Error Occurred: ${error.getMessage}"))

  Thread.sleep(10000)
}


package example

import scala.io.BufferedSource
import scala.util.{Failure, Success, Try}

object PlayerService {

  def readPlayerDataFromSource(src: String): List[String] = {
    val source: BufferedSource = io.Source.fromFile(src)
    val list: List[String] = source.getLines().toList

    source.close()
    list
  }

  def parseToPlayer(string: String): Option[Player] = {
    Try {
      val columns = string.split((",")).map(_.trim)
      Player(columns(5), columns(6), columns(9).toInt, columns(7))
    } match {
      case Success(value) => Some(value)
      case Failure(excep) => None
    }
  }

  def showPlayerInformation(playerOp: Option[Player]): Unit = {
    playerOp.map { player =>
      println("------------ Here's our Player Information ------------")
      println(s"Name: ${player.name}")
      println(s"Age: ${player.age} | Nationality: ${player.nationality} | League: ${player.league}")
      println
    }
  }

  case class Player(name: String, nationality: String, age: Int, league: String)

}


package example

import rx.lang.scala.Observable

object SmartApp extends App {

  val src = "/Users/vika/Documents/LSProg/LSPWorkspace/First_Proj_Rx/src/main/scala/example/football.csv"

  val playerObservable: Observable[String] =
    Observable.from(PlayerService.readPlayerDataFromSource(src))

  val somePlayer = Some(PlayerService.Player("Random Player", "Random Nation", 31, "Random League"))

  playerObservable
    .map(playerString =>
      PlayerService.parseToPlayer(playerString))
    .merge(Observable.just(somePlayer))
    .subscribe(player => PlayerService.showPlayerInformation(player),
      error => println(s"Error Occurred: ${error.getMessage}"))

  Thread.sleep(10000)
}
