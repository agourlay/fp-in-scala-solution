package fpinscala.exercise_3

import fpinscala.exercise_3.exercise_3_26.maximumElement
import org.scalatest.{ Matchers, WordSpec }

class exercise_3_26_test extends WordSpec with Matchers {

  "maximum node in Tree[Int]" must {

    "single node tree" in {
      maximumElement(Leaf(5)) shouldEqual 5
    }

    "single branch " in {
      maximumElement(Branch(Leaf(3), Leaf(4))) shouldEqual 4
    }

    "bigger tree branch " in {
      val branch1 = Branch(Leaf(3), Leaf(5))
      val branch2 = Branch(Leaf(6), branch1)
      maximumElement(branch2) shouldEqual 6
    }
  }
}
