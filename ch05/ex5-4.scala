// Iterable

def iterator: Iterator[A]


trait iterable[+A] extends Traversable[A] with GenIterable[A] with GenericTraversableTemplate[A, Iterable] with IterableLike[A, Iterable[A]]
