package fpinscala.test.exercise_2

import fpinscala.exercise_2.exercise_2_2._

import org.scalatest.{ WordSpec, Matchers }

class exercise_2_2_test extends WordSpec with Matchers {

  "isSorted" must {
    "empty array is always sorted" in {
      isSorted(Array.empty[Int], (a: Int, b: Int) ⇒ a < b) shouldEqual true
    }

    "Int sorted case" in {
      isSorted(Array.apply(1, 2, 3, 4), (a: Int, b: Int) ⇒ a < b) shouldEqual true
    }

    "Int not sorted case" in {
      isSorted(Array.apply(1, 2, 4, 3), (a: Int, b: Int) ⇒ a < b) shouldEqual false
    }

    "String sorted case" in {
      isSorted(Array.apply("1", "2", "3", "4"), (a: String, b: String) ⇒ a < b) shouldEqual true
    }

    "String not sorted case" in {
      isSorted(Array.apply("1", "2", "4", "3"), (a: String, b: String) ⇒ a < b) shouldEqual false
    }
  }
}
