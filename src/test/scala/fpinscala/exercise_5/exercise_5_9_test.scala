package fpinscala.exercise_5

import org.scalatest.{ Matchers, WordSpec }

class exercise_5_9_test extends WordSpec with Matchers {

  "From stream" must {

    "takeWhile" in {
      Stream.from(10).takeWhile(_ < 15).toList shouldEqual List(10, 11, 12, 13, 14)
    }

  }
}
