package fpinscala.exercise_3

import fpinscala.exercise_3.exercise_3_27.depth
import org.scalatest.{ Matchers, WordSpec }

class exercise_3_27_test extends WordSpec with Matchers {

  "Tree depth" must {

    "single node tree" in {
      depth(Leaf(5)) shouldEqual 1
    }

    "single branch " in {
      depth(Branch(Leaf(3), Leaf(4))) shouldEqual 2
    }

    "bigger tree branch " in {
      val branch1 = Branch(Leaf(3), Leaf(5))
      val branch2 = Branch(Leaf(6), branch1)
      val branch3 = Branch(branch2, Leaf(2))
      depth(branch3) shouldEqual 4
    }
  }
}
