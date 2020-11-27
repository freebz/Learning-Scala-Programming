// Writing our first Actor

import akka.actor.Acotr

class SimpleActor extends Actor {

  override def receive = Actor.emptyBehavior

}


import akka.actor.ActorSystem

object AkkaStarter extends App {

  val simpleActorSystem = ActorSystem("SimpleActorSystem")

}


import akka.actor.{Actor, ActorSystem, Props}

class SimpleActor extends Actor {
  override def receive = Actor.emptyBehavior
}

object SimpleActor {
  val props = Props[SimpleActor]
}

object AkkaStarter extends App {

  val simpleActorSystem = ActorSystem("SimpleActorSystem")

  val simpleActor = simpleActorSystem.actorOf(SimpleActor.props)
}


val simpleActor = simpleActorSystem.actorOf(SimpleActor.props, "simple-actor")


case class Player(name: String, nationality: String, age: String, club: String
  domesticLeague: String, rawTotal: String, finalScore: String, ranking2016: String,
  ranking2015: String)

object Util {

  def bufferedSourceToList(source: BufferedSource): List[String] = {
    val list = source.getLines().toList
    source.close()
    list
  }

  def asPlayers(listOfPlayersString: List[String]) : List[Player] = listOfPlayersString match {
    case head :: tail => tail map (line =>
      val columns = line.split((",")).map(_.trim)
        Player(columns(5),columns(6),columns(9),columns(7),
          columns(8),columns(10), columns(12), columns(0),columns(2))
    }
    case Nil => List[Player]()
  }

}


class SimpleActor extends Actor {
  import scala.io.Source
  import SimpleActor.ShowFootballPlayersRequest
  import Util._

  override def receive = {
    case ShowFootballPlayersRequest(url) => {
      val playersInfoSource = Source.fromFile(url)

      val players = asPlayers(bufferedSourceToList(playersInfoSource))
      palyers.foreach(player => println(player + "n"))
    }
  }

}

object SimpleActor {
  val props = Props[SimpleActor]

  final case class ShowFootallPlayersRequest(url: String)
}


val fileSource = "/Users/vika/Workspace/akkaa/akka-starter/src/main/scala/files/football_starts.csv"

simpleActor ! ShowFootallPlayersRequest(fileSource)


final case class GetPlayerInformationRequest(name: String, source: List[Player])
final case class PlayerInformationResponse(player: Option[Player])


import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

case GetPlayerInformationRequest(naem, listOfPlayers) => {
  log.info(s"Executing GetPlayerInformationRequest($name, listOfPlayers)")

  akka.pattern.pipe(

    Future.successful(PlayerInformationResponse(listOfPlayers.find(_.name.contains(name))))
  ) to sender()

}


import akka.pattern._
someFuture pipeTo sender()


//Storing players in a collection!
val players: List[Player] = Util
  .asPlayers(bufferedSourceToList(
    scala.io.Source.fromFile(fileSource)
  ))


simpleActor ? GetPlayerInformationRequest("Cristiano Ronaldo", players)


import akka.pattern.ask


import akka.util.Timeout
import scala.concurrent.duration._

implicit val timeout = Timeout(5 seconds)


val playerInformation = (simpleActor ? GetPlayerInformationRequest("Cristiano Ronaldo", players))

playerInformation
  .mapTo[PlayerInformationResponse]
  .map(futureValue => {
    futureValue.player map println
  })
