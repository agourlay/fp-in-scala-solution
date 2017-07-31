package fpinscala.exercise_5

import org.scalatest.{ Matchers, WordSpec }

class exercise_5_7_test extends WordSpec with Matchers {

  "Stream" when {

    "map" must {

      "empty" in {
        Stream.empty[String].map(_.toInt).toList shouldEqual List.empty[String]
      }

      "map" in {
        Stream.cons(2, Stream.cons(1, Stream.empty)).map(_ + 1).toList shouldEqual 3 :: 2 :: Nil
      }

    }

    "filter" must {

      "empty" in {
        Stream.empty[String].filter(_ == "yo").toList shouldEqual List.empty[String]
      }

      "two elements" in {
        Stream.cons(2, Stream.cons(1, Stream.empty)).filter(_ == 1).toList shouldEqual 1 :: Nil
      }

      "filter all" in {
        Stream.cons(2, Stream.cons(1, Stream.empty)).filter(_ > 2).toList shouldEqual Nil
      }
    }

    "append" must {

      "left empty" in {
        Stream.empty[String].append(Stream.cons(1, Stream.empty)).toList shouldEqual 1 :: Nil
      }

      "append" in {
        Stream.cons(2, Stream.cons(1, Stream.empty)).append(Stream.cons(2, Stream.cons(1, Stream.empty))).toList shouldEqual 2 :: 1 :: 2 :: 1 :: Nil
      }
    }

    "flatMap" must {

      "empty" in {
        Stream.empty[String].flatMap(e ⇒ Stream.cons(e.toInt, Empty)).toList shouldEqual List.empty[String]
      }

      "drop all" in {
        Stream.cons(2, Stream.cons(1, Stream.empty))
          .flatMap(e ⇒ Stream.cons(e.toString, Stream.cons((e + 1).toString, Empty))).toList shouldEqual "2" :: "3" :: "1" :: "2" :: Nil
      }
    }
  }
}