package fpinscala.exercise_3

object exercise_3_28 {

  def map[A, B](tree: Tree[A])(f: A ⇒ B): Tree[B] = {

    def loop(tree: Tree[A]): Tree[B] = tree match {
      case Leaf(v)      ⇒ Leaf(f(v))
      case Branch(l, r) ⇒ Branch(loop(l), loop(r))
    }
    loop(tree)

  }
}
