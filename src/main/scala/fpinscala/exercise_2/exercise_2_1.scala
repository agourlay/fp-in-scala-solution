package fpinscala.exercise_2

import scala.annotation.tailrec

object exercise_2_1 {

  def fib(n: Int): Int = {
    @tailrec
    def loop(target: Int, current: Int, prev: Int, secondPrev: Int): Int = {
      target match {
        case `current` ⇒ prev + secondPrev
        case _         ⇒ loop(target, current + 1, prev + secondPrev, prev)
      }
    }

    n match {
      case 1 ⇒ 0
      case 2 ⇒ 1
      case _ ⇒ loop(n, 3, 1, 0)

    }
  }

  def fibNotTC(n: Int): Int = n match {
    case 1 ⇒ 0
    case 2 ⇒ 1
    case _ ⇒ fib(n - 1) + fib(n - 2)
  }

}
