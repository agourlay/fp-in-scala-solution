package fpinscala.exercise_3

object exercise_3_27 {

  def depth[A](tree: Tree[A]): Int = {

    def loop(tree: Tree[A], acc: Int): Int = tree match {
      case Leaf(_)      ⇒ acc + 1
      case Branch(l, r) ⇒ loop(l, acc + 1).max(loop(r, acc + 1))
    }

    loop(tree, 0)
  }

}
