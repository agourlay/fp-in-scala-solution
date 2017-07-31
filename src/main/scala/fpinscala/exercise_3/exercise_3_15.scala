package fpinscala.exercise_3

object exercise_3_15 {

  def concat[A](l: List[List[A]]): List[A] =
    l.foldLeft(List.empty[A])(_ ::: _)

}
