package fpinscala.exercise_3

import scala.annotation.tailrec

object exercise_3_16 {

  def plus1(l: List[Int]): List[Int] = {

    @tailrec
    def loop(input: List[Int], acc: List[Int]): List[Int] = input match {
      case Nil          ⇒ acc
      case head :: tail ⇒ loop(tail, acc :+ head + 1)
    }
    loop(l, Nil)
  }
}
