package fpinscala.exercise_4

object exercise_4_6 {

  def mean(xs: IndexedSeq[Double]): Either[String, Double] =
    if (xs.isEmpty)
      Left("mean of empty list!")
    else
      Right(xs.sum / xs.length)

  def safeDiv(x: Int, y: Int): Either[Exception, Int] =
    try Right(x / y)
    catch { case e: Exception ⇒ Left(e) }

  def Try[A](a: ⇒ A): Either[Exception, A] =
    try Right(a)
    catch { case e: Exception ⇒ Left(e) }
}

sealed trait Either[+E, +A] {
  def map[B](f: A ⇒ B): Either[E, B] = this match {
    case Left(e)  ⇒ Left(e)
    case Right(v) ⇒ Right(f(v))
  }

  def flatMap[EE >: E, B](f: A ⇒ Either[EE, B]): Either[EE, B] = this match {
    case Left(e)  ⇒ Left(e)
    case Right(v) ⇒ f(v)
  }

  def orElse[EE >: E, B >: A](b: ⇒ Either[EE, B]): Either[EE, B] = this match {
    case Left(e)  ⇒ b
    case Right(_) ⇒ this
  }

  def map2[EE >: E, B, C](b: Either[EE, B])(f: (A, B) ⇒ C): Either[EE, C] =
    for {
      va ← this
      vb ← b
    } yield f(va, vb)
}

case class Left[+E](get: E) extends Either[E, Nothing]
case class Right[+A](get: A) extends Either[Nothing, A]