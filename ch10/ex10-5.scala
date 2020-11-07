// Type parameter names

//With type parameter name A
sealed abstract class List[+A] extends AbstractSeq[A]

//With type parameter name T
sealed abstract class List[+T] extends AbstractSeq[T]
