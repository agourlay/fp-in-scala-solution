package fpinscala.exercise_3

import fpinscala.exercise_3.exercise_3_22.addListsInt
import org.scalatest.{ Matchers, WordSpec }

class exercise_3_22_test extends WordSpec with Matchers {

  "add list int" must {
    "different size throws" in {
      assertThrows[IllegalArgumentException] {
        addListsInt(1 :: 2 :: Nil, 1 :: 2 :: 3 :: Nil)
      }
    }

    "work" in {
      addListsInt(1 :: 2 :: Nil, 1 :: 2 :: Nil) shouldEqual 2 :: 4 :: Nil
    }

    "empty" in {
      addListsInt(Nil, Nil) shouldEqual Nil
    }
  }
}