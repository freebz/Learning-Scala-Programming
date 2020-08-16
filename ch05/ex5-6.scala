// Sequences

// Map

trait Map[K, +V] extends Iterable[(K, V)] with GenMap[K, V] with MapLike[K, V, Map[K, V]]


val aMap = Map("country" -> "capital", "Poland" -> "Warsaw")
// aMap: scala.collection.immutable.Map[String,String] = Map(country -> capital, Poland -> Warsaw)
