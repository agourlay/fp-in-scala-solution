package fpinscala.exercise_3

import fpinscala.exercise_3.exercise_3_3.setHead
import org.scalatest.{ Matchers, WordSpec }

class exercise_3_3_test extends WordSpec with Matchers {

  "set head" must {
    "set new head" in {
      setHead(1, 2 :: 3 :: Nil) shouldEqual (1 :: 3 :: Nil)
    }

    "work one element" in {
      setHead(1, 2 :: Nil) shouldEqual (1 :: Nil)
    }

    "work if empty" in {
      setHead(1, Nil) shouldEqual (1 :: Nil)
    }
  }
}
