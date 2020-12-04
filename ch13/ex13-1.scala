// Concurrent programming

// Building blocks of concurrency

// Understanding processes and threads

// Locks and synchronization

object ThreadFirstEncounter extends App {

  class FirstThread extends Thread {
    override def run(): Unit = println(s"FirstThread's run!")
  }

  val firstThread = new FirstThread()
  firstThread.start()

  println(s"CurrentThread: ${Thread.currentThread().getName}")
  println(s"firstThread: ${firstThread.getName}")

}


// FirstThread's run!
// CurrentThread: main
// firstThread: Thread-0


object TowardsLocking extends App {
  var counter = 0 // counter variable

  def readWriteCounter(): Int = {
    val incrementedCounter = counter + 1  //Reading counter
    counter = incrementedCounter // Writing to counter
    incrementedCounter
  }

  def printCounter(nTimes: Int): Unit = {
    val readWriteCounterNTimes = for(i <- 1 to nTimes) yield readWriteCounter()
    println(s"${Thread.currentThread.getName} executing :: counter $nTimes times: $readWriteCounterNTimes")
  }

  class First extends Thread {
    override def run(): Unit = {
      printCounter(10)
    }
  }

  val first = new First
  first.start() // thread-0

  printCounter(10)    // main thread

}


// main executing :: counter 10 times: Vector(1, 3, 5, 7, 9, 11, 13, 15, 17, 18)
// Thread-0 executing :: counter 10 times: Vector(1, 2, 4, 6, 8, 10, 11, 12, 14, 16)


object TowardsLockingOne extends App {

  var counter = 0 // counter variable

  def readWriteCounter(): Int = this.synchronized {
    val incrementedCounter = counter + 1  //Reading counter
    counter = incrementedCounter // Writing to counter
    incrementedCounter
  }

  def printCounter(nTimes: Int): Unit = {
    val readWriteCounterNTimes = for(i <- 1 to nTimes) yield readWriteCounter()
    println(s"${Thread.currentThread.getName} executing :: counter $nTimes times: $readWriteCounterNTimes")
  }

  class First extends Thread {
    override def run(): Unit = {
      printCounter(10)
    }
  }

  val first = new First
  first.start() // thread-0

  printCounter(10)    // main thread
}


val any = new Any()

def readWriteCounter(): Int = any.synchronized {
    val incrementedCounter = counter + 1  //Reading counter
    counter = incrementedCounter // Writing to counter
    incrementedCounter
}
