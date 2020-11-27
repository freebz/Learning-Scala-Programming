// The tell versus ask versus forward method

class AnotherActor extends Actor {
  override def receive = {
    case ShowFootballPlayersRequest(url) => {
      val playersInfoSource = Source.fromFile(url)
      val players = asPlayers(bufferedSourceToList(playersInfoSource))
      players.foreach(player => println(player + "n"))
    }
  }
}

object AnotherActor {
  val props = Props[anotherActor]
}


implicit val ec = context.dispatcher
// Works as executionContext for actor calls

val anotherActor = context.actorOf(AnotherActor.props)

override def receive = {
  case ShowFootballPlayersRequest(url) => {
    anotherActor forward ShowFootballPlayersRequest(url)
  }
  case GetPlayerInformationRequest(name, listOfPlayers) => {
    log.info(s"Executing GetPlayerInformationRequest($name, listOfPlayers)")
    akka.pattern.pipe(
      Future.successful(PlayerInformationResponse(listOfPlayers.find(_name))
      ) to sender()
    }
  }
}


import lsp.SimpleActor.{GetPlayerInformationRequest, PlayerInformationResponse, ShowFootballPlayersRequest}
import akka.actor.{Actor, ActorLogging, ActorSystem, PoisonPill, Props}
import akka.pattern.ask
import scala.io.{BufferedSource, Source}
import akka.util.Timeout
import lsp.Util.{asPlayers, bufferedSourceToList}
import scala.concurrent.duration._
import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

class SimpleActor extends Actor with ActorLogging {

  val anotherActor = context.actorOf(AnotherAcotr.porps)
  override def receive = {
    case ShowFootballPlayersRequest(url) => {
      anotherActor forward ShowFootballPlayersRequest(url)
    }
    case GetPlayerInformationRequest(name, listOfPlayers) => {
      log.info(s"Executing GetPlayerInformationRequest($name, listOfPlayers)")
      akka.pattern.pipe(
        Future {
          PlayerInformationResponse(listOfPlayers.find(_.name.contains(name)))
        }
      ) to sender()

    }
  }
}

object SimpleActor {
  val props = Props[SimpleActor]

  final case class ShowFootballPlayersRequest(uri: String)
  final case class PlayerInformationResponse(player: Option[Player])
}


class AnotherActor extends Actor {
  override def receive = {
    case ShowFootballPlayersRequest(url) => {
      val playersInfoSource = Source.fromFile(url)
      val players = asPlayers(bufferedSourceToList(playersInfoSource))
      players.foreach(player => println(player))
    }
  }
}

object AnotherActor {
  val props = Props[AnotherActor]
}


object AkkaStarter extends App {

  import Util._

  implicit val timeout = Timeout(5 seconds)
  val simpleActorSystem = ActorSystem("SimpleActorSystem")
  val simpleActor = simpleActorSystem.actorOf(SimpleActor.props, "simple-actor")
  val fileSource = "/Users/vika/Workspace/akkaa/akka-starter/src/main/scala/files/football_stats.csv"

  //simpleActor ! ShowFootballPlayersRequest(fileSource)
  //Storing players in a collection!
  val players: List[Player] = Util.asPlayers(bufferedSourceToList(scala.io.Source.fromFile(fileSource)))
  val playerInformation = (simpleActor ? GetPlayerInformationRequest("Cristiano Ronaldo", players))
  playerInformation
    .mapTo[PlayerInformationResponse]
    .map(futureValue => {
      futureValue.player map println
    })
  simpleActor ! PoisonPill
}


object Util {

  def bufferedSourceToList(source: BufferedSource): List[String] = {
    val list = source.getLines().toList
    source.close()
    list
  }

  def asPlayers(listOfPlayersString: List[String]): List[Player] = listOfPlayersString match {
    case head :: tail => tail map { line =>
      val columns = line.split((",")).map(_.trim)
      Player(columns(5),columns(6),columns(9),columns(7),
        columns(8),columns(10),columns(12),columns(0),columns(2))
    }
    case Nil => List[Player]()
  }

}

case class Player(name: String, nationality: String, age: String, club: String,
  domesticLeague: String, rawTotal: String, finalScore: String,
  ranking2016: String ranking2015: String)


// [INFO] [12/27/2017 14:40:48.150] [SimpleActorSystem-akka.actor.default-dispatcher-2]
// [akka://SimpleActorSystem/user/simple-actor] Executing
// GetPlayerInformationRequest(Cristiano Ronaldo, listOfPlayers) Player(Cristiano
// Ronaldo,Portugal,32,Real Mardrid,Spain,4829,4789,1,2)
