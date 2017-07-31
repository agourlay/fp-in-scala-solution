package fpinscala.exercise_3

object exercise_3_13 {

  def foldLeftUsingFoldRight[A, B](l: List[A], z: B)(f: (B, A) ⇒ B): B =
    l.reverse.foldRight(z)((e, acc) ⇒ f(acc, e))

  def foldRightUsingFoldLeft[A, B](l: List[A], z: B)(f: (A, B) ⇒ B): B =
    l.foldLeft(z)((acc, e) ⇒ f(e, acc))

}
