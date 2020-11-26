// Implicit conversions

val ld = LocalDate.now
// ld: java.time.LocalDate = 2017-12-17

ld.plusDays(1)
// res0: java.time.LocalDate = 2017-12-18

ld.plusWeeks(1)
// res1: java.time.LocalDate = 2017-12-24

ld.plusMonths(1)
// res2: java.time.LocalDate = 2018-01-17

ld.plusYears(1)
// res3: java.time.LocalDate = 2018-12-17


import java.time.LocalDate

case class CustomDate(date: LocalDate) {

  def +(dyas: Day): CustomDate = CustomDate(this.date.plusDays(days.num))
  def -(days: Day): CustomDate = CustomDate(this.date.minusDays(days.num))

  def +(weeks: Week): CustomDate = CustomDate(this.date.plusWeeks(weeks.num))
  def -(weeks: Week): CustomDate = CustomDate(this.date.minusWeeks(weeks.num))

  def +(months: Month): CustomDate = CustomDate(this.date.plusMonths(months.num))
  def -(months: Month): CustomDate = CustomDate(this.date.minusMonths(months.num))

  def +(years: Year): CustomDate = CustomDate(this.date.plusYears(years.num))
  def -(years: Year): CustomDate = CustomDate(this.date.minusYears(years.num))

  def till(endDate: CustomDate): CustomDateRange = if(this.date isBefore endDate.date) CustomDateRange(this, endDate)
  else {
    throw new IllegalArgumentException("Can't create a DateRange with given start and end dates.")
  }

  override def toString: String = s"Date: ${this.date}"
}

case class Day(num: Int)
case class Week(num: Int)
case class Month(num: Int)
case class Year(num: Int)

case class CustomDateRange(sd: CustomDate, ed: CustomDate) {
  override def toString: String = s"$sd till $ed"
}


object BeautifulDateApp extends App {

  val today = CustomDate(LocalDate.now())
  val tomorrow = today + Day(1)
  val yesterday = today - Day(1)

  println(today)
  println(tomorrow)
  println(today + Year(1))

  val dateRange = today till tomorrow + Day(20)
  println(dateRange)
}


// Date: 2017-12-17
// Date: 2017-12-18
// Date: 2018-12-17
// Date: 2017-12-17 till Date: 2018-01-07



case class Day(num: Int)
case class Week(num: Int)
case class Month(num: Int)
case class Year(num: Int)

case class CustomDateRange(sd: CustomDate, ed: CustomDate) {
  override def toString: String = s"$sd till $ed "
}

object LocalDateOps {

  implicit class CustomDate(val date: LocalDate) {
    def +(days: Day): CustomDate = CustomDate(this.date.plusDays(days.num))
    def -(days: Day): CustomDate = CustomDate(this.date.minusDays(days.num))

    def +(weeks: Week): CustomDate = CustomDate(this.date.plusWeeks(weeks.num))
    def -(weeks: Week): CustomDate = CustomDate(this.date.minusWeeks(weeks.num))

    def +(months: Month): CustomDate = CustomDate(this.date.plusMonths(months.num))
    def -(months: Month): CustomDate = CustomDate(this.date.minusMonths(months.num))

    def +(years: Year): CustomDate = CustomDate(this.date.plusYears(years.num))
    def -(years: Year): CustomDate = CustomDate(this.date.minusYears(years.num))

    def till(endDate: CustomDate): CustomDateRange = if(this.date isBefore endDate.date) CustomDateRange(this, endDate)
    else {
      throw new IllegalArgumentException("Can't create a DateRange with given start and end dates.")
    }

    override def toString: String = s"Date: ${this.date}"
  }
}


import java.time.LocalDate
import LocalDateOps._

object BeautifulDateApp extends App {

  val today = LocalDate.now()
  val tomorrow = today + Day(1)
  val yesterday = today - Day(1)

  println(today)
  println(tomorrow)
  println(today + Year(1))

  val dateRange = today till tomorrow + Day(20)
  println(dateRange)

}
