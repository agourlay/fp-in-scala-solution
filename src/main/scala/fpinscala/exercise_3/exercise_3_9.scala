package fpinscala.exercise_3

object exercise_3_9 {

  def lengthOf[A](as: List[A]): Int =
    as.foldRight(0)((e, l) ⇒ l + 1)

}
