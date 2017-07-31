package fpinscala.exercise_4

object exercise_4_3 {

  def map2[A, B, C](o1: Option[A], o2: Option[B])(f: (A, B) ⇒ C): Option[C] = {
    o1.flatMap(a ⇒ o2.map(b ⇒ f(a, b)))
  }

}
