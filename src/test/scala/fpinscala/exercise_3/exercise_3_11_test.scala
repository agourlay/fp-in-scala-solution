package fpinscala.exercise_3

import fpinscala.exercise_3.exercise_3_11._
import org.scalatest.{ Matchers, WordSpec }

class exercise_3_11_test extends WordSpec with Matchers {

  "length" must {
    "standard" in {
      lengthOf(2 :: 3 :: Nil) shouldEqual 2
    }

    "empty" in {
      lengthOf(Nil) shouldEqual 0
    }

    "one element" in {
      lengthOf(2 :: Nil) shouldEqual 1
    }
  }

  "sum" must {

    "standard" in {
      sum(2 :: 3 :: Nil) shouldEqual 5
    }

    "long" in {
      val length = 100000
      val longList = List.fill(length)(1)

      sum(longList) shouldEqual length
    }

    "empty" in {
      sum(Nil) shouldEqual 0
    }

    "one element" in {
      sum(2 :: Nil) shouldEqual 2
    }
  }

  "product" must {

    "standard" in {
      product(2 :: 3 :: Nil) shouldEqual 6
    }

    "with zero" in {
      val length = 100000
      val longList = List.fill(length)(1) :+ 0

      product(longList) shouldEqual 0
    }

    "empty" in {
      product(Nil) shouldEqual 0
    }

    "one element" in {
      product(2 :: Nil) shouldEqual 2
    }
  }

}
