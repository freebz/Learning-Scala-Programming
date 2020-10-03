// Currying

WebsitePlatform => DomainName => Host


def makeWebsite(platform: WebsitePlatform, domainName: DomainName, host: Host) = println(s"Making $domainName using $platform with hosting from $host ")


def makeWebsite(platForm: WebsitePlatform)(domainName: DomainName)(host: Host): Unit


DomainName => Host => Unit


Host => Unit


object Curried extends App {

  type WebsitePlatform = String
  type DomainName = String
  type Host = String

  def makeWebsite(platform: WebsitePlatform)(domainName: DomainName)
    (host: Host) =
    println(s"Making $domainName using $platform with hosting from $host ")

  val wordPress: DomainName => Host => Unit = makeWebsite("WordPress")

  val wordPressDummyDotCom : Host => Unit = wordPress("dummy123.com")

  val blueHostedWordPressDummyDotCom : Unit =
    wordPressDummyDotCom("Bluthost.com")

  blueHostedWordPressDummyDotCom

}


// Making dummy123.com using WordPress with hosting from Bluthost.com
