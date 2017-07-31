package fpinscala.exercise_6

import fpinscala.exercise_6.RNG.Simple
import org.scalatest.{ Matchers, WordSpec }
import org.scalatest.prop.PropertyChecks

class exercise_6_5_test extends WordSpec with Matchers with PropertyChecks {

  "Random" must {

    "doubleMap" in {

      forAll { l: Long ⇒
        val r = Simple(l)
        RNG.doubleWithMap(r)._1 >= 0d shouldEqual true
        RNG.doubleWithMap(r)._1 < 1d shouldEqual true
      }

    }

  }
}
