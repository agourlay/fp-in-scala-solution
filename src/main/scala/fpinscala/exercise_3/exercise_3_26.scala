package fpinscala.exercise_3

object exercise_3_26 {

  def maximumElement(tree: Tree[Int]): Int = {
    def loop(tree: Tree[Int], max: Int): Int = tree match {
      case Leaf(v)      ⇒ v.max(max)
      case Branch(l, r) ⇒ loop(l, max).max(loop(r, max))
    }

    loop(tree, Int.MinValue)
  }

}
