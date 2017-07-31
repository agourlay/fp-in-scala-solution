package fpinscala.exercise_5

import org.scalatest.{ Matchers, WordSpec }

class exercise_5_2_test extends WordSpec with Matchers {

  "Stream" when {

    "take" must {

      "empty" in {
        Stream.empty[String].take(10).toList shouldEqual List.empty[String]
      }

      "one element" in {
        Stream.cons(1, Stream.empty).take(1).toList shouldEqual 1 :: Nil
      }

      "two elements" in {
        Stream.cons(2, Stream.cons(1, Stream.empty)).take(2).toList shouldEqual 2 :: 1 :: Nil
      }

      "take only first" in {
        Stream.cons(2, Stream.cons(1, Stream.empty)).take(1).toList shouldEqual 2 :: Nil
      }
    }

    "drop" must {

      "empty" in {
        Stream.empty[String].drop(1).toList shouldEqual List.empty[String]
      }

      "one element" in {
        Stream.cons(1, Stream.empty).drop(1).toList shouldEqual Nil
      }

      "two elements" in {
        Stream.cons(2, Stream.cons(1, Stream.empty)).drop(1).toList shouldEqual 1 :: Nil
      }

      "drop all" in {
        Stream.cons(2, Stream.cons(1, Stream.empty)).drop(2).toList shouldEqual Nil
      }
    }
  }

}
