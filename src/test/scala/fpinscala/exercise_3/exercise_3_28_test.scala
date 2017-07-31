package fpinscala.exercise_3

import fpinscala.exercise_3.exercise_3_28.map
import org.scalatest.{ Matchers, WordSpec }

class exercise_3_28_test extends WordSpec with Matchers {

  "Tree map" must {

    "single node tree" in {
      map(Leaf(5))(_ + 1) shouldEqual Leaf(6)
    }

    "single branch " in {
      map(Branch(Leaf(3), Leaf(4)))(_ + 1) shouldEqual Branch(Leaf(4), Leaf(5))
    }

    "bigger tree branch " in {
      val branch1 = Branch(Leaf(3), Leaf(5))
      val branch2 = Branch(Leaf(6), branch1)
      val branch3 = Branch(branch2, Leaf(2))

      val branch4 = Branch(Leaf(4), Leaf(6))
      val branch5 = Branch(Leaf(7), branch4)
      val branch6 = Branch(branch5, Leaf(3))

      map(branch3)(_ + 1) shouldEqual branch6
    }
  }
}
