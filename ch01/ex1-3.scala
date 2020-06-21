// Scala is multi-paradigm

package scala
trait Function1[A, B] {
        def apply(x: A) : B
}


val answer = new Function1[Int, Int] {
  def apply(x: Int): Int = x * 2
}


class YearsAndMonths(years: Int, months: Int)
def age(birthdate: Date): YearAndMonths = //Some Logic
