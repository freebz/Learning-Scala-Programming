// Type erasure

trait Tfoo[T]{
  val number: T
}


trait Tfoo {
  val member: Object    //Cause scala files gets converted to *.class files.
}
