package fpinscala.exercise_3

import fpinscala.exercise_3.exercise_3_19.filter
import org.scalatest.{ Matchers, WordSpec }

class exercise_3_19_test extends WordSpec with Matchers {

  "filter" must {
    "filter out odd" in {
      filter(1 :: 2 :: 3 :: 4 :: Nil)(_ % 2 == 0) shouldEqual 2 :: 4 :: Nil
    }
  }
}
