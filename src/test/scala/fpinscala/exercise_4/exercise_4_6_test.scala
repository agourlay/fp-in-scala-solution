package fpinscala.exercise_4

import fpinscala.exercise_4.exercise_4_6._
import org.scalatest.{ Matchers, WordSpec }

class exercise_4_6_test extends WordSpec with Matchers {

  "Either" when {

    "mean" must {

      "Right if OK" in {
        mean(Vector(1d, 2d, 3d)) shouldEqual Right(2)
      }

      "Left if error" in {
        mean(Vector.empty) shouldEqual Left("mean of empty list!")
      }
    }

    "safe div" must {

      "Right if OK" in {
        safeDiv(6, 3) shouldEqual Right(2)
      }
    }

    "Try" must {

      "Right if OK" in {
        Try(3) shouldEqual Right(3)
      }
    }
  }
}
