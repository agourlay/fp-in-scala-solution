package fpinscala.exercise_3

object exercise_3_25 {

  def countNumberOfNode[A](tree: Tree[A]): Int = {

    def loop(tree: Tree[A], acc: Int): Int = tree match {
      case Leaf(_)      ⇒ acc + 1
      case Branch(l, r) ⇒ loop(l, acc) + loop(r, acc) + 1
    }

    loop(tree, 0)
  }

}

sealed trait Tree[+A]
case class Leaf[A](value: A) extends Tree[A]
case class Branch[A](left: Tree[A], right: Tree[A]) extends Tree[A]
