// What is underneath a Scala program?

import scala.reflect.runtime.universe._
// import scala.reflect.runtime.universe._


val expr = reify {class Car {val segment="SUV"; def name="Q7"}}
// expr: reflect.runtime.universe.Expr[Unit] =
//   Expr[Unit]({
//     class Car extends AnyRef {
//       def <init>() = {
//         super.<init>();
//         ()
//       };
//       val segment = "SUV";
//       def name = "Q7"
//     };
//     ()
//   })


showRaw(expr.tree)
// res0: String = Block(List(ClassDef(Modifiers(), TypeName("Car"), List(),
// Template(List(Ident(TypeName("AnyRef"))), noSelfType, List(DefDef(Modifiers(),
// termNames.CONSTRUCTOR, List(), List(List()), TypeTree(),
// Block(List(Apply(Select(Super(This(typeNames.EMPTY), typeNames.EMPTY),
// termNames.CONSTRUCTOR), List())), Literal(Constant(())))), ValDef(Modifiers(),
// TermName("segment"), TypeTree(), Literal(Constant("SUV"))), DefDef(Modifiers(),
// TermName("name"), List(), List(), TypeTree(), Literal(Constant("Q7"))))))),
// Literal(Constant(())))
