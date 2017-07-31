package fpinscala.exercise_3

import scala.annotation.tailrec

object exercise_3_17 {

  def doubleToString(l: List[Double]): List[String] = {

    @tailrec
    def loop(input: List[Double], acc: List[String]): List[String] = input match {
      case Nil          ⇒ acc
      case head :: tail ⇒ loop(tail, acc :+ head.toString)
    }
    loop(l, Nil)

  }

}
