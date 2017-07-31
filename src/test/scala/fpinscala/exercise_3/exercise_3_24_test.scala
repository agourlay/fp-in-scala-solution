package fpinscala.exercise_3

import fpinscala.exercise_3.exercise_3_24.hasSubsequence
import org.scalatest.{ Matchers, WordSpec }

class exercise_3_24_test extends WordSpec with Matchers {

  "hasSubsequence" must {

    "empty sup" in {
      hasSubsequence(Nil, List(1, 2)) shouldEqual false
    }

    "empty sub" in {
      hasSubsequence(List(1, 2), Nil) shouldEqual true
    }

    "start" in {
      hasSubsequence(List(1, 2, 3, 4), List(1, 2)) shouldEqual true
    }

    "middle" in {
      hasSubsequence(List(1, 2, 3, 4), List(2, 3)) shouldEqual true
    }

    "end" in {
      hasSubsequence(List(1, 2, 3, 4), List(3, 4)) shouldEqual true
    }

    "false" in {
      hasSubsequence(List(1, 2, 3, 4), List(2, 4)) shouldEqual false
    }
  }
}
