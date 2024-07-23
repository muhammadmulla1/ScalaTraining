package Week4.Monday

import scala.annotation.tailrec

object Recursion extends App {

  // Standard recursion

  def factorial(n: Int): Int = {
    if (n <= 1) {
      1
    } else {
      //println(s"Currently working on ${n-1}")
      val finalResult = n * factorial(n - 1)
      //println(s"I'm the final call of $n")
      finalResult
    }
  }

  println("\nFactorial method (4) - standard recursion:")
  println(factorial(4))

  //Tail recursion
  //stops stack overflow error by reusing the call stack rather than adding

  def smartFactorial(n: Int): Int = {
    def factorialHelper(x: Int, acc: Int): Int = { // helper method ( has accumulator & additional params
      if (x <= 1) acc
      else {
        println(s"Current X: $x")
        println(s"Current acc: $acc")
        factorialHelper(x - 1, x * acc) //acc - holds the running total
      }
    }

    factorialHelper(n, 1)
  }

  println("\nFactorial - tail rec (4):")
  println(smartFactorial(4))

  // 1st call: factorialHelper(4-1, 4 * 1) = (3, 4)
  // 2nd call: factorialHelper(3-1, 3 * 4) = (2, 12)
  // 3rd call: factorialHelper(2-1, 2 * 12) = (1, 24)
  // 4th call: x ==1 ==> hitting the 'if' and returning the acc which is currently stored at 24

  // Tail rec -> concatenate a string n times
  // without helper method
  @tailrec
  def concatenateWords(aWord: String, n: Int, acc: String): String = {
    if (n <= 0) acc
    else {
      concatenateWords(aWord, n - 1, aWord + acc)
    }
  }

  println("\n tail rec concatenate words")
  println(concatenateWords("hello ", 3, ""))

  // Task
  // Standard recursion

  object StringListCounter {

    def countElements(list: List[String]): Int = {
      if (list.isEmpty) 0
      else 1 + countElements(list.tail)
    }

    def main(args: Array[String]): Unit = {
      val myList = List("1", "2", "3")
      println(countElements(myList))
    }
  }

  // Tail
  object StringListCounter1 {

    def countElementsTailRec(list: List[String]): Int = {
      def countHelper(list: List[String], acc: Int): Int = {
        if (list.isEmpty) acc
        else countHelper(list.tail, acc + 1)
      }

      countHelper(list, 0)
    }

    def main(args: Array[String]): Unit = {
      val myList = List("1", "2", "3")
      println(countElementsTailRec(myList))
    }
  }

  // S recursion with pattern matching
  object StringListCounter2 {

    def countElements(list: List[String]): Int = list match {
      case Nil => 0
      case _ :: tail => 1 + countElements(tail)
    }

    def main(args: Array[String]): Unit = {
      val myList = List("1", "2", "3")
      println(countElements(myList)) // Output: 3
    }
  }

  // R recursion with pattern matching
  object StringListCounter3 {

    def countElementsTailRec(list: List[String]): Int = {
      @scala.annotation.tailrec
      def countHelper(list: List[String], acc: Int): Int = list match {
        case Nil => acc
        case _ :: tail => countHelper(tail, acc + 1)
      }

      countHelper(list, 0)
    }

    def main(args: Array[String]): Unit = {
      val myList = List("1", "2", "3")
      println(countElementsTailRec(myList)) // Output: 3
    }
  }

  /** Recursion with enums */
  object DayOfWeek extends Enumeration {
    type DayOfWeek = Value // allows DayOfWeek to be used as a type
    val Monday, Tuesday, Wednesday, Thursday, Friday, Saturday, Sunday = Value
  }

  def enumListToString(dayOfWeekEnums: List[DayOfWeek.Value]): String = {
    def enumListHelper(dayEnums: List[DayOfWeek.Value], acc: String): String = {
      dayEnums match {
        case Nil => acc
        case ::(head, tail) =>
          val makeNiceToRead = if (acc.isEmpty) "" else ", "
          enumListHelper(tail, acc + makeNiceToRead + head.toString)
      }
    }

    enumListHelper(dayOfWeekEnums, "")
  }

  println("\n enum to string method: " + enumListToString(List(DayOfWeek.Monday, DayOfWeek.Tuesday, DayOfWeek.Wednesday)))

  /** Recursion with case objects */

  sealed trait DayOfWeek

  case object Monday extends DayOfWeek

  case object Tuesday extends DayOfWeek

  case object Wednesday extends DayOfWeek

  case object Thursday extends DayOfWeek

  case object Friday extends DayOfWeek

  case object Saturday extends DayOfWeek

  case object Sunday extends DayOfWeek

  def objectsToString(listDays: List[DayOfWeek]): String = {
    def helperMethod(remainingListOfDays: List[DayOfWeek], acc: String): String = {
      remainingListOfDays match {
        case Nil => acc
        case ::(head, tail) =>
          val makeNiceToRead = if (acc.isEmpty) "" else ", "
          helperMethod(tail, acc + makeNiceToRead + head.toString)

      }
    }

    helperMethod(listDays, "")
  }

  println("\n object to string: " + objectsToString(List(Monday, Tuesday, Wednesday)))


  // Task
  object FruitEnumeration {

    sealed trait Fruit

    case object Apple extends Fruit

    case object Orange extends Fruit

    case object Banana extends Fruit

    case object Mango extends Fruit

    case object Grapes extends Fruit

    def countFruit(fruits: List[Fruit], targetFruit: Fruit): Int = {
      @scala.annotation.tailrec
      def helperFruit(remainingFruitList: List[Fruit], acc: Int): Int = remainingFruitList match {
        case Nil => acc
        case head :: tail =>
          if (head == targetFruit) helperFruit(tail, acc + 1)
          else helperFruit(tail, acc)
      }

      helperFruit(fruits, 0)
    }

    def main(args: Array[String]): Unit = {
      val fruitList = List(Apple, Orange, Banana, Apple, Mango, Apple, Grapes, Banana)
      val targetFruit = Orange
      val count = countFruit(fruitList, targetFruit)
      println(s"$targetFruit appears $count times in the list.") // Output: Apple appears 3 times in the list.
    }
  }

  FruitEnumeration.main(Array())
}



