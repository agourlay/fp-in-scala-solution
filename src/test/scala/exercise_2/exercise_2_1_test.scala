package fpinscala.test.exercise_2

import fpinscala.exercise_2.exercise_2_1._

import org.scalatest.{ WordSpec, Matchers }

class exercise_2_1_test extends WordSpec with Matchers {

  "fibonacci" must {
    "calculate first of fib" in {
      fib(1) shouldEqual (0)
    }

    "calculate second of fib" in {
      fib(2) shouldEqual (1)
    }

    "calculate third of fib" in {
      fib(3) shouldEqual (1)
    }

    "calculate fourth of fib" in {
      fib(4) shouldEqual (2)
    }

    "calculate fifth of fib" in {
      fib(5) shouldEqual (3)
    }

    "calculate sixth of fib" in {
      fib(6) shouldEqual (5)
    }

    "calculate random fib" in {
      val rand = scala.util.Random.nextInt()
      fib(rand) shouldEqual fibNotTC(rand)
    }
  }

}
