// Another way around - generic classes and traits

sealed abstract class List[+A] extends AbstractSeq[A]
    with LinearSeq[A]
    with Product
    with GenericTraversableTemplate[A, List]
    with LinearSeqOptimized[A, List[A]]
    with Serializable
