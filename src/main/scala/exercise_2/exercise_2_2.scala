package fpinscala.exercise_2

import scala.annotation.tailrec

object exercise_2_2 {

  def isSorted[A](as: Array[A], ordered: (A, A) ⇒ Boolean): Boolean = {

    @tailrec
    def loop(index: Int): Boolean = {
      if (index + 1 >= as.length) true
      else if (ordered(as(index), as(index + 1))) loop(index + 1)
      else false
    }

    loop(0)
  }
}
