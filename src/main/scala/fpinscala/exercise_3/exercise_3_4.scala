package fpinscala.exercise_3

import scala.annotation.tailrec

object exercise_3_4 {

  @tailrec
  def drop[A](n: Int, list: List[A]): List[A] = {
    if (n == 0) list
    else {
      list match {
        case Nil          ⇒ Nil
        case head :: Nil  ⇒ Nil
        case head :: tail ⇒ drop(n - 1, list.tail)
      }
    }
  }
}