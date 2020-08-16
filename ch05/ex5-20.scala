// Rich operations performed on collections

package chapters

object CollectionOperations extends App {

  val source = io.Source.fromFile("../src/chapter5/football_stats.csv")    // Give pathString for the csv file
}


io.Source.fromFile("filePath")


case class Player(name: String, nationality: String, age: String, club: String, domesticLeague: String, rawTotal: String, finalScore: String, ranking2016: String, ranking2015: String)


source.getLines().toList


// 2016,Up/down,2015,2014,2013,Name,Nationality, Club at Dec 20 2016, Domestic league, Age at 20 Dec 2016,RAW TOTAL,HIGHEST SCORE REMOVED,FINAL SCORE,VOTES CAST,No1 PICK


def giveMePlayers(list: List[String]): List[Player] = list match {
    case head :: tail => tail map {line =>
      val columns = line.split((",")).map(_.trim)
      Player(columns(5),columns(6),columns(9),columns(7),
        columns(8),columns(10), columns(12), columns(0),columns(2))
    }
    case Nil => List[Player]()
  }


def map[B](f: (A) => B): Traversable[B]


package chapter5

object CollectionOperations extends App {

  val source = io.Source.fromFile("/Users/vika/Documents/LSProg/LSPorkspace/FirstProject/src/chapter5/football_stats.csv")

  val bufferedSourceToList: List[String] = {
    val list = source.getLines().toList
    source.close()
    list
  }

  def giveMePlayers(list: List[String]): List[Player] = list match {
      case head :: tail => tail map {line=>
        val columns = line.split((",")).map(_.trim)
        Player(columns(5),columns(6),columns(9),columns(7),
          columns(8),columns(10), columns(12), columns(0),columns(2))
      }
      case Nil => List[Player]()
    }

  val players = giveMePlayers(bufferedSourceToList)}

case class Player(name: String, nationality: String, age:String, club: String, domesticLeague: String, rawTotal: String, finalScore: String, ranking2016: String, ranking2015: String)


val filterTop10 = players filter(_.ranking2016.toInt < 11)


def filter(p: A => Boolean): Repr


def showPlayers(players: List[Player]) = players.foreach{p =>
  println(s"""Player: ${p.name}    Country: ${p.nationality}    Ranking 2016: ${p.ranking2016}

***** Other Information *****
Age: ${p.age}  |  Club: ${p.club}  |  Domestic League: ${p.domesticLeague}
Raw Total: ${p.rawTotal}  |  Final Score: ${p.finalScore}  |  Ranking 2015: ${p.ranking2015}
##########################################################""")
}


// Player: Cristiano Ronaldo    Country: Portugal    Ranking 2016: 1

// ***** Other Information *****
// Age: 32  |  Club: Real Madrid  |  Domestic League: Spain
// Raw Total: 4829  |  Final Score: 4789  |  Ranking 2015: 2
// ##########################################################


val takeTop10 = players takeWhile(_.ranking2016.toInt < 11)


def takeWhile(p: (A) => Boolean): Traversable[A]

def dropWhile(p: (A) => Boolean): Traversable[A]


val first50Players = players take 50
val (top20,least30) = first50Players partition(_,ranking2016.toInt < 21)
showPlayers(top20)


def drop(n: Int): Traversable[A]

def take(n: Int): Traversable[A]

def partition(p: (A) => Boolean): (Traversable[A], Traversable[A])


def slice(from: Int, until: Int): Traversable[A]

def span(p: (A) => Boolean): (Traversable[A], Traversable[A])

def splitAt(n: Int): (Traversable[A], Traversable[A])


// Select players from Germany who have ranking in Top 50.

first50Players filter(_.nationality.equals("Germany"))


val isGermanPalyer: (Player => Boolean) = _.nationality.equals("Germany")

val numberOfGermanPlayers = players count isGermanPlayer
println(s"German Players: $numberOfGermanPlayers")

// Run:
// German Players: 17


val isAnyPlayerAbove45 = players exists(p => p.age.toInt > 40)
println(s"isAnyPlayerAbove45: $isAnyPlayerAbove45")

// Run:
// isAnyPlayerAbove45: false


val topPlayerWithAge35plus = players find(p => p.age.toInt > 35)
println(topPlayerWithAge35plus.get)


// Player: Zlatan Ibrahimovic    Country: Sweden    Ranking 2016: 20

// ***** Other Information *****
// Age: 36  |  Club: Manchester United  |  Domestic League: England
// Raw Total: 1845  |  Final Score: 1809  |  Ranking 2015: 7
// ##########################################################


val top5PlayerWithAge35plus = players filter isAge35plus take 5
showPlayers(top5PlayerWithAge35plus)

// Run:
// Player: Zlatan Ibrahimovic    Country: Sweden    Ranking 2016: 20

// ***** Other Information *****
// Age: 36  |  Club: Manchester United  |  Domestic League: England
// Raw Total: 1845  |  Final Score: 1809  |  Ranking 2015: 7
// ##########################################################


def find(p: (A) => Boolean): Option[A]

def count(p: (A) => Boolean): Int

def exists(p: (A) => Boolean): Boolean

def forall(p: (A) => Boolean): Boolean


val Top20Countries = top20.foldLeft(List[String]())((b,a) => a.nationality :: b)


List(Sweden, England, Germany, France, France, Spain, Argentina, Belgium, Croatia, Argentina, Algeria, Chile, Gabon, Poland, Walse, Brazil, France, Uruguay, Argentina, Portugal)


val top20Countries = top20.foldRight(List[String]())((b,a) => b.nationality :: a)


List(Portugal, Argentina, Uruguay, France, Brazil, Walse, Portugal, Gabon, Chile, Algeria, Argentina, Croatia, Belgium, Argentina, Spain, France, France, Germany, England, Sweden)


def foldLeft[B](z: B)(op: (B, A) => B): B

def foldRight[B](z: B)(op: (A, B) => B): B


top20Countries.par map(println(_))

// Walse
// Portugal
// Argentina
// France
// Croatia
// Argentina
// Poland
// France
// Uruguay
// ... remaining elements
