// Smbol literals

val aSymbol = 'givenName
// aSymbol: Symbol = 'givenName

aSymbol.name
// res10: String = givenName


import scala.reflect.runtime.universe._
// import scala.reflect.runtime.universe._

typeOf[Symbol]
// res12: reflect.runtime.universe.Type = scala.reflect.runtime.universe.Symbol
