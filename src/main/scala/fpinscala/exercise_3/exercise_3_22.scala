package fpinscala.exercise_3

object exercise_3_22 {

  def addListsInt(l: List[Int], r: List[Int]): List[Int] = {

    def loop(l1: List[Int], l2: List[Int], res: List[Int]): List[Int] = (l1, l2) match {
      case (Nil, Nil)           ⇒ res
      case (h1 :: t1, h2 :: t2) ⇒ loop(t1, t2, res :+ (h1 + h2))
      case _                    ⇒ throw new IllegalArgumentException
    }

    loop(l, r, List.empty)
  }
}
