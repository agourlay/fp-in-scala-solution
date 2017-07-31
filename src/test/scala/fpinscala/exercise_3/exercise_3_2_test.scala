package fpinscala.exercise_3

import org.scalatest.{ Matchers, WordSpec }
import fpinscala.exercise_3.exercise_3_2._

class exercise_3_2_test extends WordSpec with Matchers {

  "list tail" must {
    "return tail" in {
      tail(2 :: 3 :: Nil) shouldEqual 3 :: Nil
    }

    "explode if one element" in {
      assertThrows[NoSuchElementException] {
        tail(2 :: Nil)
      }
    }

    "explode if empty" in {
      assertThrows[NoSuchElementException] {
        tail(Nil)
      }
    }
  }
}
