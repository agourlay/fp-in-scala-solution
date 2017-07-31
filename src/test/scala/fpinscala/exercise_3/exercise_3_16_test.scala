package fpinscala.exercise_3

import fpinscala.exercise_3.exercise_3_16.plus1
import org.scalatest.{ Matchers, WordSpec }

class exercise_3_16_test extends WordSpec with Matchers {

  "plus1" must {
    "standard" in {
      plus1(1 :: 2 :: 3 :: Nil) shouldEqual 2 :: 3 :: 4 :: Nil
    }

    "empty" in {
      plus1(Nil) shouldEqual Nil
    }

    "one element" in {
      plus1(2 :: Nil) shouldEqual (3 :: Nil)
    }
  }
}
