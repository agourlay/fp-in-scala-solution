package fpinscala.exercise_3

import fpinscala.exercise_3.exercise_3_12.reverse
import org.scalatest.{ Matchers, WordSpec }

class exercise_3_12_test extends WordSpec with Matchers {

  "reverse" must {
    "standard" in {
      reverse(1 :: 2 :: 3 :: Nil) shouldEqual (3 :: 2 :: 1 :: Nil)
    }

    "empty" in {
      reverse(Nil) shouldEqual Nil
    }

    "one element" in {
      reverse(2 :: Nil) shouldEqual (2 :: Nil)
    }
  }
}