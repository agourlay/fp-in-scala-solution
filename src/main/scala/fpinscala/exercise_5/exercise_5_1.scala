package fpinscala.exercise_5

import scala.annotation.tailrec

object exercise_5_1 {

}

trait Stream[+A] {

  def toList: List[A] = {

    @tailrec
    def loop(st: Stream[A], l: List[A]): List[A] = st match {
      case Empty            ⇒ l
      case Cons(head, tail) ⇒ loop(tail(), l :+ head())
    }

    loop(this, Nil)
  }

  def drop(n: Int): Stream[A] = {

    @tailrec
    def loop(i: Stream[A], counter: Int): Stream[A] =
      if (counter == n)
        i
      else
        i match {
          case Empty         ⇒ Empty
          case Cons(_, tail) ⇒ loop(tail(), counter + 1)
        }

    loop(this, 0)

  }

  def take(n: Int): Stream[A] = {

    def loop(i: Stream[A], counter: Int): Stream[A] =
      if (counter == n)
        Empty
      else
        i match {
          case Empty            ⇒ Empty
          case Cons(head, tail) ⇒ Stream.cons(head(), loop(tail(), counter + 1))
        }

    loop(this, 0)

  }

  def takeWhile(p: A ⇒ Boolean): Stream[A] = this match {
    case Empty ⇒ Empty
    case Cons(head, tail) ⇒
      val h = head()
      if (p(h)) Stream.cons(h, tail().takeWhile(p))
      else Empty
  }

  def forAll(p: A ⇒ Boolean): Boolean = this match {
    case Empty ⇒ true
    case Cons(head, tail) ⇒
      val h = head()
      if (p(h)) tail().forAll(p)
      else false
  }

  def foldRight[B](z: ⇒ B)(f: (A, ⇒ B) ⇒ B): B = // The arrow `=>` in front of the argument type `B` means that the function `f` takes its second argument by name and may choose not to evaluate it.
    this match {
      case Cons(h, t) ⇒ f(h(), t().foldRight(z)(f)) // If `f` doesn't evaluate its second argument, the recursion never occurs.
      case _          ⇒ z
    }

  def exists(p: A ⇒ Boolean): Boolean =
    foldRight(false)((a, b) ⇒ p(a) || b) // Here `b`

  def takeWhileFR(p: A ⇒ Boolean): Stream[A] =
    foldRight[Stream[A]](Empty)((a, b) ⇒ if (p(a)) Stream.cons(a, b) else Empty)

  lazy val headOption: Option[A] =
    foldRight[Option[A]](None)((a, _) ⇒ Some(a))

  def map[B](f: A ⇒ B): Stream[B] =
    foldRight[Stream[B]](Empty)((a, b) ⇒ Stream.cons(f(a), b))

  def filter(f: A ⇒ Boolean): Stream[A] =
    foldRight[Stream[A]](Empty)((h, t) ⇒ if (f(h)) Stream.cons(h, t) else t)

  def append[B >: A](s: ⇒ Stream[B]): Stream[B] =
    foldRight(s)((a, b) ⇒ Stream.cons(a, b))

  def flatMap[B](f: A ⇒ Stream[B]): Stream[B] =
    foldRight[Stream[B]](Empty)((a, b) ⇒ f(a).append(b))

  def mapUnfold[B](f: A ⇒ B): Stream[B] =
    Stream.unfold(this) {
      case Empty            ⇒ None
      case Cons(head, tail) ⇒ Some(f(head()), tail())
    }

  def takeUnfold(n: Int): Stream[A] =
    Stream.unfold((this, n)) {
      case (Cons(head, tail), i) if i > 0 ⇒ Some(head(), (tail(), n - 1))
      case _                              ⇒ None
    }

  def takeWhileUnfold(p: A ⇒ Boolean): Stream[A] =
    Stream.unfold(this) {
      case Cons(head, tail) if p(head()) ⇒ Some(head(), tail())
      case _                             ⇒ None
    }

  def zipWith[B, C](r: Stream[B])(f: (A, B) ⇒ C): Stream[C] =
    Stream.unfold((this, r)) {
      case (Cons(head1, tail1), Cons(head2, tail2)) ⇒ Some(f(head1(), head2()), (tail1(), tail2()))
      case _                                        ⇒ None
    }

  def zipAll[B](s2: Stream[B]): Stream[(Option[A], Option[B])] =
    Stream.unfold((this, s2)) {
      case (Cons(head1, tail1), Cons(head2, tail2)) ⇒ Some((Some(head1()), Some(head2())), (tail1(), tail2()))
      case (Cons(head1, tail1), Empty)              ⇒ Some((Some(head1()), None), (tail1(), Empty))
      case (Empty, Cons(head2, tail2))              ⇒ Some((None, Some(head2())), (Empty, tail2()))
      case _                                        ⇒ None
    }

  def startsWith[B](s: Stream[B]): Boolean = {
    val matches = zipWith(s)(_ == _).takeWhile(_ == true)
    s.zipAll(matches).forAll(_._2.isDefined)
  }

  def tails: Stream[Stream[A]] =
    Stream.unfold(this) {
      case Empty            ⇒ None
      case Cons(head, tail) ⇒ Some(Stream.cons(head(), tail()), tail())
    }.append(Stream(Empty))

  /*
  Did not find this one.
  The function can't be implemented using `unfold`, since `unfold` generates elements of the `Stream` from left to right. It can be implemented using `foldRight` though.
  The implementation is just a `foldRight` that keeps the accumulated value and the stream of intermediate results, which we `cons` onto during each iteration. When writing folds, it's common to have more state in the fold than is needed to compute the result. Here, we simply extract the accumulated list once finished.
  */
  def scanRight[B](z: B)(f: (A, ⇒ B) ⇒ B): Stream[B] =
    foldRight((z, Stream(z)))((a, p0) ⇒ {
      // p0 is passed by-name and used in by-name args in f and cons. So use lazy val to ensure only one evaluation...
      lazy val p1 = p0
      val b2 = f(a, p1._1)
      (b2, Stream.cons(b2, p1._2))
    })._2

}
case object Empty extends Stream[Nothing]
case class Cons[+A](h: () ⇒ A, t: () ⇒ Stream[A]) extends Stream[A]

object Stream {
  def cons[A](hd: ⇒ A, tl: ⇒ Stream[A]): Stream[A] = {
    lazy val head = hd
    lazy val tail = tl
    Cons(() ⇒ head, () ⇒ tail)
  }

  def empty[A]: Stream[A] = Empty

  val ones: Stream[Int] = Stream.cons(1, ones)

  def constant[A](a: A): Stream[A] = Stream.cons(a, constant(a))

  def from(f: Int): Stream[Int] = Stream.cons(f, from(f + 1))

  val fibs = {

    def next(a: Int, b: Int): Stream[Int] =
      Stream.cons(a, next(b, a + b))

    next(0, 1)
  }

  def apply[A](as: A*): Stream[A] =
    if (as.isEmpty) empty
    else cons(as.head, apply(as.tail: _*))

  def unfold[A, S](z: S)(f: S ⇒ Option[(A, S)]): Stream[A] = {

    def next(a: S): Stream[A] = f(a) match {
      case None         ⇒ Empty
      case Some((b, s)) ⇒ Stream.cons(b, next(s))
    }

    next(z)
  }

  val fibsUnfold = unfold((0, 1)) { case (a, b) ⇒ Some(a, (b, a + b)) }

  val onesUnfold: Stream[Int] = unfold(1)(one ⇒ Some((one, one)))

  def constantUnfold[A](a: A): Stream[A] = unfold(a)(v ⇒ Some((v, v)))

  def fromUnfold(f: Int): Stream[Int] = unfold(f)(v ⇒ Some((v, v + 1)))

}