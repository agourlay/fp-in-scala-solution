package fpinscala.exercise_3

import fpinscala.exercise_3.exercise_3_23.zipWith
import org.scalatest.{ Matchers, WordSpec }

class exercise_3_23_test extends WordSpec with Matchers {

  "zipWith" must {
    "different size throws" in {
      assertThrows[IllegalArgumentException] {
        zipWith(1 :: 2 :: Nil, 1 :: 2 :: 3 :: Nil)(_ + _)
      }
    }

    "work" in {
      zipWith(1 :: 2 :: Nil, 1 :: 2 :: Nil)(_ + _) shouldEqual 2 :: 4 :: Nil
    }

    "empty" in {
      zipWith(List.empty[Int], List.empty[Int])(_ + _) shouldEqual Nil
    }
  }
}
