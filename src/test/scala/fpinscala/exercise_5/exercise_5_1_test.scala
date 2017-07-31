package fpinscala.exercise_5

import org.scalatest.{ Matchers, WordSpec }

class exercise_5_1_test extends WordSpec with Matchers {

  "Stream to List" must {

    "empty" in {
      Stream.empty[String].toList shouldEqual List.empty[String]
    }

    "one element" in {
      Stream.cons(1, Stream.empty).toList shouldEqual 1 :: Nil
    }

    "two elements" in {
      Stream.cons(2, Stream.cons(1, Stream.empty)).toList shouldEqual 2 :: 1 :: Nil
    }
  }

}