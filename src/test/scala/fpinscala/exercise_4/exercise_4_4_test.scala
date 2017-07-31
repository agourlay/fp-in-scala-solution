package fpinscala.exercise_4

import fpinscala.exercise_4.exercise_4_4.sequence
import org.scalatest.{ Matchers, WordSpec }

class exercise_4_4_test extends WordSpec with Matchers {

  "sequence" must {

    "one None is None" in {
      sequence(List(None, Some(1))) shouldEqual None
    }

    "all None is None" in {
      sequence(List(None, None)) shouldEqual None
    }

    "Somes" in {
      sequence(List(Some(2), Some(1))) shouldEqual Some(List(2, 1))
    }
  }

}