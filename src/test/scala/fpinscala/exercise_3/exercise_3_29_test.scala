package fpinscala.exercise_3

import fpinscala.exercise_3.exercise_3_29._
import org.scalatest.{ Matchers, WordSpec }

class exercise_3_29_test extends WordSpec with Matchers {

  "generic fold" when {

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

}
