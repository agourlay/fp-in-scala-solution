package fpinscala.exercise_6

import org.scalatest.{ Matchers, WordSpec }
import org.scalatest.prop.PropertyChecks

class exercise_6_11_test extends WordSpec with Matchers with PropertyChecks {

  "Candy machine" must {

    "example input" in {

      val initialMachine: Machine = Machine(locked = true, coins = 10, candies = 5)

      val buyCandies: List[Input] = List(Coin, Turn)
      val commands = List.fill(4)(buyCandies).flatten

      val ((coins, candies), _) = Candy.simulateMachine(commands).run(initialMachine)
      coins shouldEqual 14
      candies shouldEqual 1
    }
  }
}
