package fpinscala.exercise_4

import fpinscala.exercise_4.exercise_4_5.traverse
import org.scalatest.{ Matchers, WordSpec }

class exercise_4_5_test extends WordSpec with Matchers {

  "traverse" must {

    "one None is None" in {
      traverse(List(1, 2))(n ⇒ if (n % 2 == 0) Some(n) else None) shouldEqual None
    }

    "all None is None" in {
      traverse(List(1, 3))(n ⇒ if (n % 2 == 0) Some(n) else None) shouldEqual None
    }

    "Somes" in {
      traverse(List(2, 4, 6))(n ⇒ if (n % 2 == 0) Some(n) else None) shouldEqual Some(List(2, 4, 6))
    }
  }
}
