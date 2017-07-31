package fpinscala.exercise_6

import fpinscala.exercise_6.RNG.Simple
import org.scalatest.prop.PropertyChecks
import org.scalatest.{ Matchers, WordSpec }

class exercise_6_1_test extends WordSpec with Matchers with PropertyChecks {

  "Random" must {

    "nonNegativeInt" in {

      forAll { l: Long ⇒
        val r = Simple(l)
        RNG.nonNegativeInt(r)._1 >= 0 shouldEqual true
      }

    }

  }
}
