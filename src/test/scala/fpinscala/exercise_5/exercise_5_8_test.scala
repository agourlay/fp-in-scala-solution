package fpinscala.exercise_5

import org.scalatest.{ Matchers, WordSpec }

class exercise_5_8_test extends WordSpec with Matchers {

  "Stream constant" must {

    "takeWhile" in {
      Stream.constant(1).takeWhile(_ != 1).headOption shouldEqual None
    }

    "forAll" in {
      Stream.constant("a").forAll(_ == "b") shouldEqual false
    }

  }
}
