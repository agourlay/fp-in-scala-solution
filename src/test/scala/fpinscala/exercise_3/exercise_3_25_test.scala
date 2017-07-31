package fpinscala.exercise_3

import fpinscala.exercise_3.exercise_3_25.countNumberOfNode
import org.scalatest.{ Matchers, WordSpec }

class exercise_3_25_test extends WordSpec with Matchers {

  "count number of node" must {

    "single node tree" in {
      countNumberOfNode(Leaf("a")) shouldEqual 1
    }

    "single branch " in {
      countNumberOfNode(Branch(Leaf("a"), Leaf("b"))) shouldEqual 3
    }

    "bigger tree branch " in {
      val branch1 = Branch(Leaf("a"), Leaf("b"))
      val branch2 = Branch(Leaf("c"), branch1)
      countNumberOfNode(branch2) shouldEqual 5
    }
  }
}
