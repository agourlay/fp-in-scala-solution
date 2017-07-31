package fpinscala.exercise_4

object exercise_4_4 {

  def sequence[A](l: List[Option[A]]): Option[List[A]] = {

    def loop(ops: List[Option[A]], acc: List[A]): Option[List[A]] = ops match {
      case Nil          ⇒ Some(acc)
      case head :: tail ⇒ head.flatMap(h ⇒ loop(tail, acc :+ h))
    }

    loop(l, Nil)
  }

}
