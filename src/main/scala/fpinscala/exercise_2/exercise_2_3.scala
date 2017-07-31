package fpinscala.exercise_2

object exercise_2_3 {

  def curry[A, B, C](f: (A, B) ⇒ C): A ⇒ (B ⇒ C) = {
    (a: A) ⇒ f(a, _)
  }
}
