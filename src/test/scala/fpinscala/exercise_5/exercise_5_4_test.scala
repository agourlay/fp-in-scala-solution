package fpinscala.exercise_5

import org.scalatest.{ Matchers, WordSpec }

class exercise_5_4_test extends WordSpec with Matchers {

  "ForAll" must {

    "empty" in {
      Stream.empty[String].forAll(_ == "a") shouldEqual true
    }

    "one element" in {
      Stream.cons(1, Stream.empty).forAll(_ == 1) shouldEqual true
    }

    "last one is incorrect" in {
      Stream.cons(2, Stream.cons(2, Stream.cons(1, Stream.empty))).forAll(_ == 2) shouldEqual false
    }

    "all" in {
      Stream.cons(2, Stream.cons(2, Stream.cons(2, Stream.empty))).forAll(_ == 2) shouldEqual true
    }
  }

}
