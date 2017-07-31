package fpinscala.exercise_6

import scala.annotation.tailrec

object exercise_6_1 {

}

trait RNG {
  def nextInt: (Int, RNG) // Should generate a random `Int`. We'll later define other functions in terms of `nextInt`.
}

object RNG {
  // NB - this was called SimpleRNG in the book text

  case class Simple(seed: Long) extends RNG {
    def nextInt: (Int, RNG) = {
      val newSeed = (seed * 0x5DEECE66DL + 0xBL) & 0xFFFFFFFFFFFFL // `&` is bitwise AND. We use the current seed to generate a new seed.
      val nextRNG = Simple(newSeed) // The next state, which is an `RNG` instance created from the new seed.
      val n = (newSeed >>> 16).toInt // `>>>` is right binary shift with zero fill. The value `n` is our new pseudo-random integer.
      (n, nextRNG) // The return value is a tuple containing both a pseudo-random integer and the next `RNG` state.
    }
  }

  type Rand[+A] = RNG ⇒ (A, RNG)

  val int: Rand[Int] = _.nextInt

  def unit[A](a: A): Rand[A] =
    rng ⇒ (a, rng)

  def map[A, B](s: Rand[A])(f: A ⇒ B): Rand[B] =
    rng ⇒ {
      val (a, rng2) = s(rng)
      (f(a), rng2)
    }

  def mapFM[A, B](s: Rand[A])(f: A ⇒ B): Rand[B] = flatMap(s)(a ⇒ unit(f(a)))

  def nonNegativeInt(rng: RNG): (Int, RNG) = {
    val (i, r) = rng.nextInt
    (if (i < 0) -(i + 1) else i, r)
  }

  def double(rng: RNG): (Double, RNG) = {
    val (i, r) = nonNegativeInt(rng)
    (i / (Int.MaxValue.toDouble + 1), r)
  }

  def doubleWithMap(rng: RNG): (Double, RNG) = {
    map(nonNegativeInt)(i ⇒ i / (Int.MaxValue.toDouble + 1))(rng)
  }

  def intDouble(rng: RNG): ((Int, Double), RNG) = {
    val (int, r1) = rng.nextInt
    val (d, r2) = double(r1)
    ((int, d), r2)
  }

  def doubleInt(rng: RNG): ((Double, Int), RNG) = {
    val ((int, d), r1) = intDouble(rng)
    ((d, int), r1)
  }

  def double3(rng: RNG): ((Double, Double, Double), RNG) = {
    val (d1, r1) = double(rng)
    val (d2, r2) = double(r1)
    val (d3, r3) = double(r2)
    ((d1, d2, d3), r3)
  }

  def ints(count: Int)(rng: RNG): (List[Int], RNG) = {

    @tailrec
    def loop(remaining: Int)(rand: RNG)(acc: List[Int]): (List[Int], RNG) =
      if (remaining == 0)
        (acc, rand)
      else {
        val (i, r) = rand.nextInt
        loop(remaining - 1)(r)(acc :+ i)
      }

    loop(count)(rng)(Nil)
  }

  def map2[A, B, C](ra: Rand[A], rb: Rand[B])(f: (A, B) ⇒ C): Rand[C] =
    rng ⇒ {
      val (a, aRng) = ra(rng)
      val (b, bRng) = rb(aRng)
      (f(a, b), bRng)
    }

  def map2FM[A, B, C](ra: Rand[A], rb: Rand[B])(f: (A, B) ⇒ C): Rand[C] =
    flatMap(ra) { a ⇒
      map(rb)(b ⇒ f(a, b))
    }

  def sequence[A](fs: List[Rand[A]]): Rand[List[A]] = {

    @tailrec
    def loop(remaining: List[Rand[A]])(acc: Rand[List[A]]): Rand[List[A]] = remaining match {
      case Nil          ⇒ acc
      case head :: tail ⇒ loop(tail)(map2(acc, head)(_ :+ _))
    }

    loop(fs)(rng ⇒ (Nil, rng))

  }

  def intsSequence(count: Int)(rng: RNG): (List[Int], RNG) =
    sequence(List.fill(count)(int))(rng)

  def flatMap[A, B](f: Rand[A])(g: A ⇒ Rand[B]): Rand[B] = { rng ⇒
    val (a, rngA) = f(rng)
    g(a)(rngA)
  }

  def nonNegativeLessThan(n: Int): Rand[Int] = {
    flatMap(nonNegativeInt) { i ⇒
      val mod = i % n
      if (i + (n - 1) - mod >= 0)
        unit(mod)
      else nonNegativeLessThan(n)
    }
  }
}

import State._

case class State[S, +A](run: S ⇒ (A, S)) {

  def unit[B](b: B): State[S, B] = State(s ⇒ (b, s))

  def map[B](f: A ⇒ B): State[S, B] =
    flatMap(a ⇒ unit(f(a)))

  def map2[B, C](sb: State[S, B])(f: (A, B) ⇒ C): State[S, C] =
    flatMap { a ⇒ sb.map(b ⇒ f(a, b)) }

  def flatMap[B](f: A ⇒ State[S, B]): State[S, B] = State { s1 ⇒
    val (a, s2) = run(s1)
    f(a).run(s2)
  }
}

object State {

  def unit[S, A](a: A): State[S, A] =
    State(s ⇒ (a, s))

  // The idiomatic solution is expressed via foldRight
  def sequence[S, A](sas: List[State[S, A]]): State[S, List[A]] =
    sas.foldRight(unit[S, List[A]](List()))((f, acc) ⇒ f.map2(acc)(_ :: _))

  def modify[S](f: S ⇒ S): State[S, Unit] = for {
    s ← get // Gets the current state and assigns it to `s`.
    _ ← set(f(s)) // Sets the new state to `f` applied to `s`.
  } yield ()

  def get[S]: State[S, S] = State(s ⇒ (s, s))

  def set[S](s: S): State[S, Unit] = State(_ ⇒ ((), s))

}

sealed trait Input
case object Coin extends Input
case object Turn extends Input

case class Machine(locked: Boolean, candies: Int, coins: Int)

object Candy {
  def update(i: Input)(s: Machine): Machine = (i, s) match {
    case (_, Machine(_, 0, _)) ⇒
      s
    case (Coin, Machine(false, _, _)) ⇒
      s
    case (Turn, Machine(true, _, _)) ⇒
      s
    case (Coin, Machine(true, candy, coin)) ⇒
      Machine(locked = false, candy, coin + 1)
    case (Turn, Machine(false, candy, coin)) ⇒
      Machine(locked = true, candy - 1, coin)
  }

  def simulateMachine(inputs: List[Input]): State[Machine, (Int, Int)] = for {
    _ ← sequence(inputs.map(update).map(modify[Machine]))
    s ← get
  } yield (s.coins, s.candies)
}