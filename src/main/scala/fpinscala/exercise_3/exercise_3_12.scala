package fpinscala.exercise_3

object exercise_3_12 {

  def reverse[A](l: List[A]): List[A] =
    l.foldLeft[List[A]](Nil)((acc, e) ⇒ e :: acc)

}
