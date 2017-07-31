package fpinscala.exercise_3

import scala.annotation.tailrec

object exercise_3_5 {

  @tailrec
  def dropWhile[A](l: List[A], p: A ⇒ Boolean): List[A] = l match {
    case Nil          ⇒ l
    case head :: Nil  ⇒ if (p(head)) Nil else l
    case head :: tail ⇒ if (p(head)) dropWhile(tail, p) else l
  }
}