package fpinscala.exercise_3

import scala.annotation.tailrec

object exercise_3_24 {

  def hasSubsequence[A](sup: List[A], sub: List[A]): Boolean = {

    @tailrec
    def loop(l1: List[A], l2: List[A]): Boolean =
      if (l2.isEmpty)
        true
      else
        l1 match {
          case head :: tail if head == l2.head ⇒ loop(tail, l2.tail)
          case head :: tail                    ⇒ loop(tail, sub)
          case Nil                             ⇒ false
        }

    loop(sup, sub)
  }
}
