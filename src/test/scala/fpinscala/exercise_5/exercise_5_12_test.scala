package fpinscala.exercise_5

import org.scalatest.{ Matchers, WordSpec }

class exercise_5_12_test extends WordSpec with Matchers {

  "Stream unfold" when {

    "fibs" must {
      "works" in {
        Stream.fibsUnfold.take(10).toList shouldEqual List(0, 1, 1, 2, 3, 5, 8, 13, 21, 34)
      }
    }

    "ones" must {
      "works" in {
        Stream.onesUnfold.take(5).toList shouldEqual List(1, 1, 1, 1, 1)
      }
    }

    "constant" must {
      "works" in {
        Stream.constantUnfold(1).take(5).toList shouldEqual List(1, 1, 1, 1, 1)
      }
    }

    "from" must {
      "works" in {
        Stream.from(5).take(5).toList shouldEqual List(5, 6, 7, 8, 9)
      }
    }

  }
}
