
//package Week2.Wednesday
//
//import org.scalatest.FlatSpec
//
//class FizzBuzzSpec extends FlatSpec {
//
//  "fizzBuzz" should "return Fizz for numbers divisible by 3" in {
//    val fizzBuzz = new FizzBuzz
//    assert(fizzBuzz.fizzBuzz(3) == "Fizz")
//    assert(fizzBuzz.fizzBuzz(6) == "Fizz")
//    assert(fizzBuzz.fizzBuzz(9) == "Fizz")
//  }
//
//  it should "return Buzz for numbers divisible by 5" in {
//    val fizzBuzz = new FizzBuzz
//    assert(fizzBuzz.fizzBuzz(5) == "Buzz")
//    assert(fizzBuzz.fizzBuzz(10) == "Buzz")
//    assert(fizzBuzz.fizzBuzz(20) == "Buzz")
//  }
//
//  it should "return 'FizzBuzz' for numbers divisible by both 3 and 5" in {
//    val fizzBuzz = new FizzBuzz
//    assert(fizzBuzz.fizzBuzz(15) == "FizzBuzz")
//    assert(fizzBuzz.fizzBuzz(30) == "FizzBuzz")
//    assert(fizzBuzz.fizzBuzz(45) == "FizzBuzz")
//  }
//
//  it should "return the number as a string if it is not divisible by 3 or 5" in {
//    val fizzBuzz = new FizzBuzz
//    assert(fizzBuzz.fizzBuzz(1) == "1")
//    assert(fizzBuzz.fizzBuzz(2) == "2")
//    assert(fizzBuzz.fizzBuzz(4) == "4")
//  }
//}
