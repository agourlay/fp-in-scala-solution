package fpinscala.exercise_3

import fpinscala.exercise_3.exercise_3_5.dropWhile
import org.scalatest.{ Matchers, WordSpec }

class exercise_3_5_test extends WordSpec with Matchers {

  "drop while" must {
    "drop all" in {
      dropWhile(2 :: 3 :: Nil, (p: Int) ⇒ true) shouldEqual Nil
    }

    "drop none" in {
      dropWhile(2 :: 3 :: Nil, (p: Int) ⇒ false) shouldEqual 2 :: 3 :: Nil
    }

    "drop some" in {
      dropWhile(2 :: 3 :: Nil, (p: Int) ⇒ p == 2) shouldEqual 3 :: Nil
    }
  }
}
