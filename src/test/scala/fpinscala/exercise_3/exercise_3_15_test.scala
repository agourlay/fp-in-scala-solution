package fpinscala.exercise_3

import fpinscala.exercise_3.exercise_3_15.concat
import org.scalatest.{ Matchers, WordSpec }

class exercise_3_15_test extends WordSpec with Matchers {

  "concat List[List[A]]" must {
    "standard" in {
      concat(List(1 :: 2 :: 3 :: Nil, 4 :: Nil)) shouldEqual 1 :: 2 :: 3 :: 4 :: Nil
    }

    "empty" in {
      concat(List(Nil, 1 :: Nil)) shouldEqual 1 :: Nil
    }

    "one element" in {
      concat(List(2 :: Nil, 3 :: Nil)) shouldEqual (2 :: 3 :: Nil)
    }
  }
}
