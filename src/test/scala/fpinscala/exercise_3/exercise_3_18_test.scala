package fpinscala.exercise_3

import fpinscala.exercise_3.exercise_3_18.map
import org.scalatest.{ Matchers, WordSpec }

class exercise_3_18_test extends WordSpec with Matchers {

  "generic map" when {
    "double to string" must {

      "standard" in {
        map(1d :: 2d :: 3d :: Nil)(_.toString) shouldEqual "1.0" :: "2.0" :: "3.0" :: Nil
      }

      "empty" in {
        map(List.empty[String])(_.toString) shouldEqual Nil
      }

      "one element" in {
        map(2d :: Nil)(_.toString) shouldEqual ("2.0" :: Nil)
      }
    }

    "plus1" must {
      "standard" in {
        map(1 :: 2 :: 3 :: Nil)(_ + 1) shouldEqual 2 :: 3 :: 4 :: Nil
      }

      "empty" in {
        map(List.empty[Int])(_ + 1) shouldEqual Nil
      }

      "one element" in {
        map(2 :: Nil)(_ + 1) shouldEqual (3 :: Nil)
      }
    }
  }
}
