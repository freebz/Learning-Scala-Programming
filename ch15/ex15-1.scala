// The why and what of TDD

// The process of TDD

// Step 1 - write a test that will fail

// Step 2 - write code to pass the failing test

// Step 3 - refactor the code to improve the quality

// Step 4 - repeat steps 1 to 3

// Scenario

"PlayerService" should {
  "return a Player object." in {/*some code*/}
  "return an empty collection if there's no data." in {/*some code*/}
  "return a Nothing on call to getPlayer method with right player string." in {/*some code*/}
  "return a Some Player instance on call to getPlayer method with right Player string." in {/*some code*/}
  "print a Player's information on console." in {/*some code*/}
}
