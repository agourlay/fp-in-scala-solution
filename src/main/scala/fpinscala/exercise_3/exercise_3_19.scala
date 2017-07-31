package fpinscala.exercise_3

import scala.annotation.tailrec

object exercise_3_19 {

  def filter[A](l: List[A])(f: A ⇒ Boolean): List[A] = {

    @tailrec
    def loop(input: List[A], acc: List[A]): List[A] = input match {
      case Nil          ⇒ acc
      case head :: tail ⇒ loop(tail, if (f(head)) acc :+ head else acc)
    }
    loop(l, Nil)
  }

}
