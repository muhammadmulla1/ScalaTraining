package Week2.Wednesday

class TwoNumbers(x:Int, y:Int) {

  def add(): Int = {
    x + y
  }

  def subtract(): Int = {
    x - y
  }

  def multiply(): Int = {
    x * y
  }

  def divide(): Double = {
    x.toDouble / y.toDouble
  }

  def isAMultiple(): Boolean = {
    y % x == 0
  }
}
