// The s interpolator

val nextYearAge = s"Next Year, I'll complete ${age + 1}."
// nextYearAge: String = Next Year, I'll complete 26.


def incrementBy1(x: Int) = x + 1
// incrementBy1: (x: Int)Int

val nextYearAge = s"Next Year, I'll complete ${incrementBy1(age)}."
// nextYearAge: String = Next Year, I'll complete 26.
