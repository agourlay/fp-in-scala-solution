package fpinscala.exercise_4

object exercise_4_7 {

  def traverse[E, A, B](es: List[A])(f: A ⇒ Either[E, B]): Either[E, List[B]] = {

    def loop(ops: List[A], acc: List[B]): Either[E, List[B]] = ops match {
      case Nil          ⇒ Right(acc)
      case head :: tail ⇒ f(head).flatMap(h ⇒ loop(tail, acc :+ h))
    }

    loop(es, Nil)
  }

  def sequence[E, A](es: List[Either[E, A]]): Either[E, List[A]] =
    traverse(es)(identity)

}
