package fpinscala.exercise_5

import org.scalatest.{ Matchers, WordSpec }

class exercise_5_5_test extends WordSpec with Matchers {

  "Take While fold right" must {

    "empty" in {
      Stream.empty[String].takeWhileFR(_ == "a").toList shouldEqual List.empty[String]
    }

    "one element" in {
      Stream.cons(1, Stream.empty).takeWhileFR(_ == 1).toList shouldEqual 1 :: Nil
    }

    "two elements" in {
      Stream.cons(2, Stream.cons(2, Stream.cons(1, Stream.empty))).takeWhileFR(_ == 2).toList shouldEqual 2 :: 2 :: Nil
    }
  }

}
