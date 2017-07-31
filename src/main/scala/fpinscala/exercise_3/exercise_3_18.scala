package fpinscala.exercise_3

import scala.annotation.tailrec

object exercise_3_18 {

  def map[A, B](l: List[A])(f: A ⇒ B): List[B] = {

    @tailrec
    def loop(input: List[A], acc: List[B]): List[B] = input match {
      case Nil          ⇒ acc
      case head :: tail ⇒ loop(tail, acc :+ f(head))
    }
    loop(l, Nil)
  }
}
