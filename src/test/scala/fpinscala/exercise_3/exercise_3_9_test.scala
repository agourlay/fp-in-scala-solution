package fpinscala.exercise_3

import fpinscala.exercise_3.exercise_3_9.lengthOf
import org.scalatest.{ Matchers, WordSpec }

class exercise_3_9_test extends WordSpec with Matchers {

  "length" must {
    "standard" in {
      lengthOf(2 :: 3 :: Nil) shouldEqual 2
    }

    "long" in {
      lengthOf(List.fill(100)("element")) shouldEqual 100
    }

    "empty" in {
      lengthOf(Nil) shouldEqual 0
    }

    "one element" in {
      lengthOf(2 :: Nil) shouldEqual 1
    }
  }
}
