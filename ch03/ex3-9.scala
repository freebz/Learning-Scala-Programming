// Limitations of recursion

// The ideal way to write recursive functions

if(n == 0) 1 else 2 * power2toN(n - 1)


package chapter3

import scala.annotation.tailrec

object TailRecursionEx extends App {

  /*
   * 2 to the power n
   * @tailrec optimization
   */
  def power2toNTail(n: Int): Int = {
    @tailrec
    def helper(n: Int, currentVal: Int): Int = {
      if(n == 0) currentVal else helper(n - 1, currentVal * 2)
    }
    helper(n, 1)
  }

  println(power2toNTail(2))
  println(power2toNTail(4))
  println(power2toNTail(6))
}


// 4
// 16
// 64
