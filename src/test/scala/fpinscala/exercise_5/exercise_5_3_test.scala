package fpinscala.exercise_5

import org.scalatest.{ Matchers, WordSpec }

class exercise_5_3_test extends WordSpec with Matchers {

  "Take While" must {

    "empty" in {
      Stream.empty[String].takeWhile(_ == "a").toList shouldEqual List.empty[String]
    }

    "one element" in {
      Stream.cons(1, Stream.empty).takeWhile(_ == 1).toList shouldEqual 1 :: Nil
    }

    "two elements" in {
      Stream.cons(2, Stream.cons(2, Stream.cons(1, Stream.empty))).takeWhile(_ == 2).toList shouldEqual 2 :: 2 :: Nil
    }
  }

}
