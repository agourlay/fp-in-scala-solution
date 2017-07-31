package fpinscala.exercise_3

import scala.annotation.tailrec

object exercise_3_10 {

  def foldLeft[A, B](l: List[A], z: B)(f: (B, A) ⇒ B): B = {

    @tailrec
    def loop(l: List[A], acc: B): B = l match {
      case Nil          ⇒ acc
      case head :: tail ⇒ loop(tail, f(acc, head))
    }

    loop(l, z)
  }

}
