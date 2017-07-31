package fpinscala.exercise_5

import org.scalatest.{ Matchers, WordSpec }

class exercise_5_6_test extends WordSpec with Matchers {

  "Stream headOption" must {

    "empty" in {
      Stream.empty[String].headOption shouldEqual None
    }

    "one element" in {
      Stream.cons(1, Stream.empty).headOption shouldEqual Some(1)
    }

    "more" in {
      Stream.cons(2, Stream.cons(2, Stream.cons(1, Stream.empty))).headOption shouldEqual Some(2)
    }

  }

}
