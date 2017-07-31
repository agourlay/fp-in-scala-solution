package fpinscala.exercise_3

import scala.annotation.tailrec

object exercise_3_6 {

  def init[A](l: List[A]): List[A] = {
    @tailrec
    def loop(l: List[A], acc: List[A]): List[A] =
      l match {
        case Nil          ⇒ acc
        case head :: Nil  ⇒ loop(Nil, acc)
        case head :: tail ⇒ loop(tail, acc :+ head)
      }

    loop(l, Nil)
  }
}