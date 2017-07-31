package fpinscala.exercise_3

import fpinscala.exercise_3.exercise_3_20.flatMap

object exercise_3_21 {

  def filterWithFlatMap[A](l: List[A])(f: A ⇒ Boolean): List[A] =
    flatMap(l)(i ⇒ if (f(i)) i :: Nil else Nil)

}
