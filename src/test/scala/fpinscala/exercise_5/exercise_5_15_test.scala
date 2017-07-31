package fpinscala.exercise_5

import org.scalatest.{ Matchers, WordSpec }

class exercise_5_15_test extends WordSpec with Matchers {

  "Tails stream" must {

    "empty" in {
      Stream.empty[String].tails.toList shouldEqual List(Empty)
    }

    "positive" in {
      Stream.from(1).take(3).tails.toList.map(_.toList) shouldEqual List(List(1, 2, 3), List(2, 3), List(3), List())
    }

  }
}
