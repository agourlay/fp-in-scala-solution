package fpinscala.exercise_5

import org.scalatest.{ Matchers, WordSpec }

class exercise_5_10_test extends WordSpec with Matchers {

  "fibs stream" must {

    "works" in {
      Stream.fibs.take(10).toList shouldEqual List(0, 1, 1, 2, 3, 5, 8, 13, 21, 34)
    }

  }
}
