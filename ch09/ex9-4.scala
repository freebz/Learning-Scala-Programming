// Maqtching a constant

def matchAgainst(i: Int) = i match {
  case 1 => println("One")
  case 2 => println("Two")
  case 3 => println("Three")
  case 4 => println("Four")
  case _ => println("Not in Range 1 to 4")
}

matchAgainst(1)
matchAgainst(5)


// One
// Not in Range 1 to 4
