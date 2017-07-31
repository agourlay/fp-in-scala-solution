package fpinscala.exercise_3

import fpinscala.exercise_3.exercise_3_21.filterWithFlatMap
import org.scalatest.{ Matchers, WordSpec }

class exercise_3_21_test extends WordSpec with Matchers {

  "filter with flatMap" must {
    "filter out odd" in {
      filterWithFlatMap(1 :: 2 :: 3 :: 4 :: Nil)(_ % 2 == 0) shouldEqual 2 :: 4 :: Nil
    }
  }
}
