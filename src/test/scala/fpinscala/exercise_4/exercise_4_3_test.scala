package fpinscala.exercise_4

import fpinscala.exercise_4.exercise_4_3.map2
import org.scalatest.{ Matchers, WordSpec }

class exercise_4_3_test extends WordSpec with Matchers {

  "map2" must {

    "one None is None" in {
      map2[Int, Int, Int](None, Some(1))(_ + _) shouldEqual None
    }

    "two None is None" in {
      map2[Int, Int, Int](None, None)(_ + _) shouldEqual None
    }

    "Somes" in {
      map2[Int, Int, Int](Some(2), Some(1))(_ + _) shouldEqual Some(3)
    }
  }

}
