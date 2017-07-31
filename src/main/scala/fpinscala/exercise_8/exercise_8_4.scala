package fpinscala.exercise_8

import fpinscala.exercise_6.{RNG, State}

class exercise_8_4 {

}

case class Gen[A](sample: State[RNG,A])

object Gen {
  def choose(start: Int, stopExclusive: Int): Gen[Int] = {
    Gen(
      State[RNG,Int]{rng =>
        val (i, r) = rng.nextInt
        (if (i > stopExclusive) -(i + 1) else i, r)
      }
    )
  }
}