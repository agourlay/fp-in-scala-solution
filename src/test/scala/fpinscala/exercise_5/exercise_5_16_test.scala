package fpinscala.exercise_5

import org.scalatest.{ Matchers, WordSpec }

class exercise_5_16_test extends WordSpec with Matchers {

  "ScanRight stream" must {

    "positive" in {
      Stream(1, 2, 3).scanRight(0)(_ + _).toList shouldEqual List(6, 5, 3, 0)
    }

  }
}
