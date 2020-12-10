// Assertions

// Matchers

// ScalaMock - a native library to mock objects

libraryDependencies += "org.scalamock" %% "scalamock" % "4.0.0" % Test


import org.scalamock.scalatest.MockFactory

class PlayerAppSpec extends SomeSpec("PlayerAppSpec") with MockFactory {

  it should "give us a collection of 2 players" in {

    val mockPlayer = mock[PlayerService.Player]

    val list = List(mockPlayer, mockPlayer)
    list should have length 2
  }

}


val someStringToIntFunc = mockFunction[String, Int]

someStringToIntFunc expects ("Some Number") returning 1
