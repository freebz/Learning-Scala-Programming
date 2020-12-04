// Parallel collections

import scala.collection.parallel.immutable.ParSeq
import scala.concurrent.Future
import scala.util.{Failure, Success}
import scala.concurrent.ExecutionContext.Implicits.global

object TowardParallelCollections extends App {

  val fileSource = "/Users/vika/Documents/LSProg/LSPWorkspace/FirstProject/src/chapter13/bootball_stats.csv"

  val listOfPlayers: Future[List[Player]] = Future {
    val source = io.Source.fromFile(fileSource)
    val list: List[String] = source.getLines().toList

    source.close()

    val parSequence = list.par.tail

    val playerParSequence: ParSeq[Player] = parSequence.map {
      case line => val columns = line.split((",")).map(_.trim)
        Player(columns(5),columns(6),columns(9),columns(7),
          columns(8),columns(10), columns(12), columns(0),columns(2))
    }

    playerParSequence.toList
  }

  listOfPlayers foreach {
    case list => list foreach println
  }

  Thread.sleep(5000)

}
