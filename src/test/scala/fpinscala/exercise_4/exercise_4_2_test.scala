package fpinscala.exercise_4

import fpinscala.exercise_4.exercise_4_2._
import org.scalatest.{ Matchers, WordSpec }

class exercise_4_2_test extends WordSpec with Matchers {

  "Variance" must {

    "empty" in {
      variance(Nil) shouldEqual None
    }

    "wolfram mean" in {
      mean(List(21.3, 38.4, 12.7, 41.6)) shouldEqual Some(28.5)
    }

    "wolfram population variance" in {
      variance(List(21.3, 38.4, 12.7, 41.6)) shouldEqual Some(142.775)
    }
  }

}
