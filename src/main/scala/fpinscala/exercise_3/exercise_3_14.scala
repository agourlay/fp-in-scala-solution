package fpinscala.exercise_3

object exercise_3_14 {

  def appendWithFR[A](l: List[A], elements: List[A]): List[A] =
    l.foldRight[List[A]](elements)((e, acc) ⇒ e :: acc)

}
