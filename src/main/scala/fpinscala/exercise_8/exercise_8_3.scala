package fpinscala.exercise_8

class exercise_8_3 {

}

trait Prop { self =>
  def check: Boolean
  def &&(p: Prop): Prop = new Prop {
    def check: Boolean = self.check && p.check
  }
}