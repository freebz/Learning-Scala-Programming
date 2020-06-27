// Null and Nothing

def checkIF10AndReturn20(x: Int): Int = {
  if (x == 10)
    x * 2
  else
    throw new Exception("Sorry, Value wasn't 10")
}
