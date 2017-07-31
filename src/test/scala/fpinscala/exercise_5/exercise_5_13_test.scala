package fpinscala.exercise_5

import org.scalatest.{ Matchers, WordSpec }

class exercise_5_13_test extends WordSpec with Matchers {

  "Stream unfold" when {

    "map" must {
      "empty" in {
        Stream.empty[String].mapUnfold(_.toInt).toList shouldEqual List.empty[String]
      }

      "map" in {
        Stream.cons(2, Stream.cons(1, Stream.empty)).mapUnfold(_ + 1).toList shouldEqual 3 :: 2 :: Nil
      }
    }

    "take" must {
      "empty" in {
        Stream.empty[String].takeUnfold(10).toList shouldEqual List.empty[String]
      }

      "one element" in {
        Stream.cons(1, Stream.empty).takeUnfold(1).toList shouldEqual 1 :: Nil
      }

      "two elements" in {
        Stream.cons(2, Stream.cons(1, Stream.empty)).takeUnfold(2).toList shouldEqual 2 :: 1 :: Nil
      }

      "take only first" in {
        Stream.cons(2, Stream.cons(1, Stream.empty)).takeUnfold(1).toList shouldEqual 2 :: Nil
      }
    }

    "takeWhile" must {
      "empty" in {
        Stream.empty[String].takeWhileUnfold(_ == "a").toList shouldEqual List.empty[String]
      }

      "one element" in {
        Stream.cons(1, Stream.empty).takeWhileUnfold(_ == 1).toList shouldEqual 1 :: Nil
      }

      "two elements" in {
        Stream.cons(2, Stream.cons(2, Stream.cons(1, Stream.empty))).takeWhileUnfold(_ == 2).toList shouldEqual 2 :: 2 :: Nil
      }
    }

    "zipWith" must {
      "same size" in {
        Stream.from(5).zipWith(Stream.constant(1))(_ + _).take(5).toList shouldEqual List(6, 7, 8, 9, 10)
      }

      "different size" in {
        Stream.from(5).take(5).zipWith(Stream.constant(1).take(4))(_ + _).take(5).toList shouldEqual List(6, 7, 8, 9)
      }
    }

    "zipAll" must {
      "same size" in {
        Stream.from(5).zipAll(Stream.constant(1)).take(3).toList shouldEqual List((Some(5), Some(1)), (Some(6), Some(1)), (Some(7), Some(1)))
      }

      "different size" in {
        Stream.from(5).take(3).zipAll(Stream.constant(1).take(2)).toList shouldEqual List((Some(5), Some(1)), (Some(6), Some(1)), (Some(7), None))
      }
    }

  }
}
