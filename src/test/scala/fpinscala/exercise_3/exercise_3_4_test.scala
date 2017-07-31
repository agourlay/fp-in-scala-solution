package fpinscala.exercise_3

import fpinscala.exercise_3.exercise_3_4.drop
import org.scalatest.{ Matchers, WordSpec }

class exercise_3_4_test extends WordSpec with Matchers {

  "drop n" must {
    "drop it" in {
      drop(1, 2 :: 3 :: Nil) shouldEqual 3 :: Nil
    }

    "drop all" in {
      drop(3, 1 :: 2 :: 3 :: Nil) shouldEqual Nil
    }

    "drop more" in {
      drop(5, 1 :: 2 :: 3 :: Nil) shouldEqual Nil
    }

    "work one element" in {
      drop(1, 2 :: Nil) shouldEqual Nil
    }

    "work if empty" in {
      drop(1, Nil) shouldEqual Nil
    }
  }
}
