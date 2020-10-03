// Partially applied functions

def makeWebsite(platform: WebsitePlatform, domainName: DomainName, host: Host) =
  println(s"Making $domainName using $platform with hosting from $host ")


object PaF extends App {

  type WebsitePlatform = String
  type DomainName = String
  type Host = String
  type Protocol = String

  def makeWebsite(platform: WebsitePlatform, domainName: DomainName, host: Host) =
    println(s"Making $domainName using $platform with hosting from $host ")

  val wordPressSite: (DomainName, Host) => Unit = makeWebsite("WordPress", _: DomainName, _: Host)

  val makeExampleDotCom: (WebsitePlatform, Host) => Unit = makeWebsite(_: WebsitePlatform,
      "example.com",
      _: Host
    )

  val makeBlueHostingExampleDotCom: (WebsitePlatform) => Unit = makeWebsite(_: WebsitePlatform,
    "example.com",
    "bluehost.com"
    )

  makeWebsite("Wordpress", "anyDomain.com", "Godaddy.com")
  wordPressSite("example.com", "Godaddy.com")
  makeExampleDotCom("Wordpress", "bluehost.com")
  makeBlueHostingExampleDotCom("Blogger")

}


// Making anyDomain.com using Wordpress with hosting from Godaddy.com
// Making example.com using WordPress with hosting from Godaddy.com
// Making example.com using Wordpress with hosting from bluehost.com
// Making example.com using Blogger with hosting from bluehost.com


val wordPressSite: (DomainName, Host) => Unit = makeWebsite("WordPress", _: DomainName, _: Host)


val makeExampleDotCom: (WebsitePlatform, Host) => Unit = makeWebsite(_: WebsitePlatform,
      "example.com",
      _: Host
    )
