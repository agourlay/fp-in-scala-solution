package fpinscala.exercise_3

import fpinscala.exercise_3.exercise_3_10.foldLeft

object exercise_3_11 {

  def sum(l: List[Int]) =
    foldLeft(l, 0)(_ + _)

  def product(l: List[Int]) =
    if (l.isEmpty)
      0
    else
      foldLeft(l, 1)(_ * _)

  def lengthOf(l: List[Int]) =
    foldLeft(l, 0)((acc, _) ⇒ acc + 1)

}
