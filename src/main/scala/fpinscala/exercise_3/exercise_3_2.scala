package fpinscala.exercise_3

object exercise_3_2 {

  def tail[A](list: List[A]): List[A] = list match {
    case Nil          ⇒ throw new NoSuchElementException
    case head :: Nil  ⇒ throw new NoSuchElementException
    case head :: tail ⇒ tail
  }
}