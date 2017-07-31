package fpinscala.exercise_3

object exercise_3_3 {

  def setHead[A](newHead: A, list: List[A]): List[A] = list match {
    case Nil          ⇒ newHead :: Nil
    case head :: Nil  ⇒ newHead :: Nil
    case head :: tail ⇒ newHead :: tail
  }
}