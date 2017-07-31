package fpinscala.exercise_4

import fpinscala.exercise_4.exercise_4_7._
import org.scalatest.{ Matchers, WordSpec }

class exercise_4_7_test extends WordSpec with Matchers {

  "Either" when {

    "sequence" must {

      "Right if all OK" in {
        sequence(List(Right(1d), Right(2d), Right(3d))) shouldEqual Right(List(1d, 2d, 3d))
      }

      "Left if at least one error" in {
        sequence(List(Right(1d), Right(2d), Left("nop!"))) shouldEqual Left("nop!")
      }
    }

    "traverse" must {

      "Right if all OK" in {
        traverse(List(1d, 2d, 3d))(v ⇒ Right(v)) shouldEqual Right(List(1d, 2d, 3d))
      }

      "Left if at least one error" in {
        traverse(List(1d, 2d, 3d))(v ⇒ if (v == 3d) Left("nop!") else Right(v)) shouldEqual Left("nop!")
      }
    }
  }
}
