package fpinscala.exercise_3

import fpinscala.exercise_3.exercise_3_6.init
import org.scalatest.{ Matchers, WordSpec }

class exercise_3_6_test extends WordSpec with Matchers {

  "init" must {
    "standard" in {
      init(2 :: 3 :: Nil) shouldEqual 2 :: Nil
    }

    "empty" in {
      init(Nil) shouldEqual Nil
    }

    "one element" in {
      init(2 :: Nil) shouldEqual Nil
    }
  }
}
