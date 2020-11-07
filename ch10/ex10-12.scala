// Type-classes

trait CSVEncoder[T] {
  def encode(t: T): List[String]
}
