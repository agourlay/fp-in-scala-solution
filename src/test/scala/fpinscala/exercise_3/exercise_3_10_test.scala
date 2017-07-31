package fpinscala.exercise_3

import fpinscala.exercise_3.exercise_3_10.foldLeft
import org.scalatest.{ Matchers, WordSpec }

class exercise_3_10_test extends WordSpec with Matchers {

  "foldLeft" must {
    "standard" in {
      foldLeft(2 :: 3 :: Nil, 0)(_ + _) shouldEqual 5
    }

    "long" in {
      val length = 100000
      val longList = List.fill(length)(1)

      foldLeft(longList, 0)(_ + _) shouldEqual length
    }

    "empty" in {
      foldLeft(List.empty[Int], 0)(_ + _) shouldEqual 0
    }

    "one element" in {
      foldLeft(2 :: Nil, 0)(_ + _) shouldEqual 2
    }
  }
}
