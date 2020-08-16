// Differences between the root and immutable collections

// Hierarchy of collections in Scala

// Traversable

trait Traversable[+A] extends TraversableLike[A, Traversable[A]] with GenTraversable[A] with TraversableOnce[A] with GenericTraversableTemplate[A, Traversable]


def foreach[U](f: Elem => U)
