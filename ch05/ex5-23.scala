// Converting a Java collection into a Scala collection

package chapter5

import java.time.LocalDate
import scala.collection.JavaConverters._

object CollectionConvertors extends App {
    /*
     We'll create a java collection of a couple of days and convert it to Scala Collection
     */
  val aJavaList = new java.util.ArrayList[LocalDate]()
  aJavaList.add(LocalDate.now())
  aJavaList.add(aJavaList.get(0).plusDays(1))

  println(s"Java List of today and tomorrow: $aJavaList")

  val scalaDates = aJavaList.asScala
  scalaDates map { date =>
    println(s"Date :: $date")
  }

  val backToJavaList = scalaDates.asJavaCollection
  println(backToJavaList)
}


// Java List of today and tomorrow: [2017-10-01, 2017-10-02]
// Date :: 2017-10-01
// Date :: 2017-10-02
// [2017-10-01, 2017-10-02]


val backToJavaList = scalaDates.asJava
println(backToJavaList)
