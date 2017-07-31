package fpinscala.exercise_3

object exercise_3_29 {

  def fold[A, B](t: Tree[A])(f: A ⇒ B)(m: (B, B) ⇒ B): B = {

    def loop(tree: Tree[A]): B = tree match {
      case Leaf(v)      ⇒ f(v)
      case Branch(l, r) ⇒ m(loop(l), loop(r))
    }

    loop(t)

  }

  def countNumberOfNode[A](tree: Tree[A]): Int =
    fold(tree)(_ ⇒ 1)(_ + _ + 1)

  def maximumElement(tree: Tree[Int]): Int =
    fold(tree)(identity)(_ max _)

  def depth[A](tree: Tree[A]): Int =
    fold(tree)(_ ⇒ 1)((l, r) ⇒ (l + 1).max(r + 1))

  def map[A, B](tree: Tree[A])(f: A ⇒ B): Tree[B] =
    fold[A, Tree[B]](tree)(v ⇒ Leaf(f(v)))((l, r) ⇒ Branch(l, r))

}
