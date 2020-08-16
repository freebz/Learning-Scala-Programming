// ListBuffer

val listBuffer = ListBuffer("Alex","Bob","Charles")
// listBuffer: scala.collection.mutable.ListBuffer[String] = ListBuffer(Alex, Bob, Charles)

listBuffer += "David"
// res39: listBuffer.type = ListBuffer(Alex, Bob, Charles, David)

println(listBuffer)
// ListBuffer(Alex, Bob, Charles, David)
