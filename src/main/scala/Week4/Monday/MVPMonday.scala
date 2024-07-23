package Week4.Monday

import scala.annotation.tailrec

// Task 1: Create an object that extends Enumeration and print all the teams using tail recursion.
object Euro2024Teams extends Enumeration {
  type Euro2024Teams = Value
  val Germany, France, Spain, Italy, England, Portugal, Belgium, Netherlands, Croatia, Denmark, Switzerland, Sweden, Poland, Austria, CzechRepublic, Hungary, Wales, Scotland, Finland, Norway, Slovakia, Slovenia, Russia, Turkey = Value

  def printTeams(teams: List[Euro2024Teams.Value]): Unit = {
    @tailrec
    def printHelper(remainingTeams: List[Euro2024Teams.Value]): Unit = remainingTeams match {
      case Nil => // do nothing
      case head :: tail =>
        println(head)
        printHelper(tail)
    }

    printHelper(teams)
  }
}

// Task 2: Use case objects instead of Enumeration.
sealed abstract class Team(val name: String)

object Team {
  case object Germany extends Team("Germany")
  case object France extends Team("France")
  case object Spain extends Team("Spain")
  case object Italy extends Team("Italy")
  case object England extends Team("England")
  case object Portugal extends Team("Portugal")
  case object Belgium extends Team("Belgium")
  case object Netherlands extends Team("Netherlands")
  case object Croatia extends Team("Croatia")
  case object Denmark extends Team("Denmark")
  case object Switzerland extends Team("Switzerland")
  case object Sweden extends Team("Sweden")
  case object Poland extends Team("Poland")
  case object Austria extends Team("Austria")
  case object CzechRepublic extends Team("Czech Republic")
  case object Hungary extends Team("Hungary")
  case object Wales extends Team("Wales")
  case object Scotland extends Team("Scotland")
  case object Finland extends Team("Finland")
  case object Norway extends Team("Norway")
  case object Slovakia extends Team("Slovakia")
  case object Slovenia extends Team("Slovenia")
  case object Russia extends Team("Russia")
  case object Turkey extends Team("Turkey")

  val allTeams: List[Team] = List(
    Germany, France, Spain, Italy, England, Portugal, Belgium, Netherlands, Croatia, Denmark,
    Switzerland, Sweden, Poland, Austria, CzechRepublic, Hungary, Wales, Scotland, Finland, Norway,
    Slovakia, Slovenia, Russia, Turkey
  )

  def printTeams(teams: List[Team]): Unit = {
    @tailrec
    def printHelper(remainingTeams: List[Team]): Unit = remainingTeams match {
      case Nil => // do nothing
      case head :: tail =>
        println(head.name)
        printHelper(tail)
    }

    printHelper(teams)
  }
}

// Task 3: Recursive method to check if a number at a given index position is even or not.
object NumberCheck {
  def isEven(numbers: List[Int], index: Int): Either[String, Boolean] = {
    @tailrec
    def helper(remainingNumbers: List[Int], currentIndex: Int): Either[String, Boolean] = (remainingNumbers, currentIndex) match {
      case (Nil, _) => Left(s"Index $index out of bounds")
      case (head :: _, 0) => Right(head % 2 == 0)
      case (_ :: tail, _) => helper(tail, currentIndex - 1)
    }

    if (index < 0) Left(s"Index $index out of bounds")
    else helper(numbers, index)
  }
}

// Task 4: Method to sum all numbers between 0 and a given number.
object SumNumbers {
  def sumUpTo(n: Int): Int = {
    @tailrec
    def helper(current: Int, acc: Int): Int = {
      if (current == 0) acc
      else helper(current - 1, acc + current)
    }

    helper(n, 0)
  }
}

// Testing the code
object Main extends App {
  // Testing Task 1
  println("Task 1: Euro2024 Teams using Enumeration:")
  Euro2024Teams.printTeams(Euro2024Teams.values.toList)

  // Testing Task 2
  println("\nTask 2: Euro2024 Teams using Case Objects:")
  Team.printTeams(Team.allTeams)

  // Testing Task 3
  val numbers = (1 to 20).toList
  println("\nTask 3: Checking if numbers at given indices are even:")
  println(NumberCheck.isEven(numbers, 3))  // Should return Right(false)
  println(NumberCheck.isEven(numbers, 10)) // Should return Right(true)
  println(NumberCheck.isEven(numbers, 21)) // Should return Left("Index 21 out of bounds")

  // Testing Task 4
  println("\nTask 4: Sum of numbers up to a given number:")
  println(SumNumbers.sumUpTo(5)) // Should return 15
}
