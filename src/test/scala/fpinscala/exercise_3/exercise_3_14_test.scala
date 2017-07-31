package fpinscala.exercise_3

import fpinscala.exercise_3.exercise_3_14.appendWithFR
import org.scalatest.{ Matchers, WordSpec }

class exercise_3_14_test extends WordSpec with Matchers {

  "append with FR" must {
    "standard" in {
      appendWithFR(1 :: 2 :: 3 :: Nil, 4 :: Nil) shouldEqual 1 :: 2 :: 3 :: 4 :: Nil
    }

    "empty" in {
      appendWithFR(Nil, 1 :: Nil) shouldEqual 1 :: Nil
    }

    "one element" in {
      appendWithFR(2 :: Nil, 3 :: Nil) shouldEqual (2 :: 3 :: Nil)
    }
  }
}
