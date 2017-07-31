package fpinscala.exercise_3

import fpinscala.exercise_3.exercise_3_17.doubleToString
import org.scalatest.{ Matchers, WordSpec }

class exercise_3_17_test extends WordSpec with Matchers {

  "double to string" must {
    "standard" in {
      doubleToString(1d :: 2d :: 3d :: Nil) shouldEqual "1.0" :: "2.0" :: "3.0" :: Nil
    }

    "empty" in {
      doubleToString(Nil) shouldEqual Nil
    }

    "one element" in {
      doubleToString(2d :: Nil) shouldEqual ("2.0" :: Nil)
    }
  }
}