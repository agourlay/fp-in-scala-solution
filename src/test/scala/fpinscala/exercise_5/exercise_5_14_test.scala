package fpinscala.exercise_5

import org.scalatest.{ Matchers, WordSpec }

class exercise_5_14_test extends WordSpec with Matchers {

  "StartWith stream" must {

    "positive" in {
      Stream.from(10).startsWith(Stream.from(10).take(3)) shouldEqual true
    }

    "negative" in {
      Stream.from(10).startsWith(Stream.from(9).take(3)) shouldEqual false
    }

  }
}

