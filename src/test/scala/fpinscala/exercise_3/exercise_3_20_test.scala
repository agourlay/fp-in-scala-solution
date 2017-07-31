package fpinscala.exercise_3

import fpinscala.exercise_3.exercise_3_20.flatMap
import org.scalatest.{ Matchers, WordSpec }

class exercise_3_20_test extends WordSpec with Matchers {

  "flatMap" must {
    "works" in {
      flatMap(1 :: 2 :: 3 :: Nil)(i ⇒ i :: i :: Nil) shouldEqual 1 :: 1 :: 2 :: 2 :: 3 :: 3 :: Nil
    }
  }
}
