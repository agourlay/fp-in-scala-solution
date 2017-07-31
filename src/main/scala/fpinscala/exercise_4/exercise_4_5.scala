package fpinscala.exercise_4

object exercise_4_5 {

  def traverse[A, B](l: List[A])(f: A ⇒ Option[B]): Option[List[B]] = {

    def loop(ops: List[A], acc: List[B]): Option[List[B]] = ops match {
      case Nil          ⇒ Some(acc)
      case head :: tail ⇒ f(head).flatMap(h ⇒ loop(tail, acc :+ h))
    }

    loop(l, Nil)
  }

}
