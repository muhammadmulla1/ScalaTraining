package Week2.Wednesday

class FizzBuzz {
  def fizzBuzz(number: Int): String = {
    (number % 3 == 0, number % 5 == 0) match {
      case (true, true) => "FizzBuzz"
      case (true, false) => "Fizz"
      case (false, true) => "Buzz"
      case (false, false) => number.toString
    }
  }
}
