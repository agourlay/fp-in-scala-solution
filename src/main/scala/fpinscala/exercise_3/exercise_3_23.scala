package fpinscala.exercise_3

object exercise_3_23 {

  def zipWith[A, B, C](l: List[A], r: List[B])(f: (A, B) ⇒ C): List[C] = {

    def loop(l1: List[A], l2: List[B], res: List[C]): List[C] = (l1, l2) match {
      case (Nil, Nil)           ⇒ res
      case (h1 :: t1, h2 :: t2) ⇒ loop(t1, t2, res :+ f(h1, h2))
      case _                    ⇒ throw new IllegalArgumentException
    }

    loop(l, r, List.empty)
  }

}
