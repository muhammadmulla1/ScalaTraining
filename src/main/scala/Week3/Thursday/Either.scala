package Week3.Thursday

import sun.security.util.Password
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import java.time.LocalDate

object Either extends App{


  // Left - error
  // Right - success

  def isEven(x:Int): Either[String,String] =
    if (x % 2 == 0) Right(s"$x is even") else Left(s"$x is odd")

  println(isEven(4))
  println(isEven(7))

  //Custom error
  class NewError(val errorCode: Int, val errorMessage: String) extends Exception
  case object IsOddError extends NewError(400, "Bad request in the is odd method")

  def isOdd(x:Int): Either[NewError,String] =
    if (x % 2 != 0) Right(s"$x is odd") else Left(IsOddError)

  println(isOdd(4))
  println(isOdd(7))

  /** Try/catch */
  def plusOne(x:String): Either[String, Int] = {
    try {
      Right(x.toInt)
    } catch {
      case e: Exception => Left (s"Failed due to: $e") // wildcard
    }
  }
  println(plusOne("1")) // Right try
  println(plusOne("one")) // Left catch

  //functions directly
  plusOne("3").map(num => num + 1)
  plusOne("I will fail").map(num => num + 1) // will stop when it hits Left

  /** Pattern Matching */

  def plusOneMatch(): Unit = {
    plusOne("1") match {
      case Left(e) => println(s"Left: $e")
      case Right(x) => println(s"Right: $x")
    }
  }
  println(plusOneMatch())

  /** for comps with eithers */
  // Fail fast - as soon as one condition is not met, we exit

  case class User (username: String, password: String, dateOfBirth: LocalDate)

  case class ValidatedUser (username: String, password: String, dateOfBirth: LocalDate)

  // Validate username
  def validateUsername( username: String): Either[String, String] = {
    if (username.length < 12) Left("Username must be at least 12 characters")
    else Right(username)
  }

  // Validate password
  def validatePassword(password: String): Either[String, String] = {
    if (password.toUpperCase == password || password.toLowerCase == password) Left("Password must mic upper and lower")
    else Right (password)
  }

  // Validate age
  def validateAge(dateOfBirth: LocalDate): Either[String, LocalDate] = {
    if(dateOfBirth.plusYears(18).isAfter(LocalDate.now)) Left ("User must be 18 years old") else Right (dateOfBirth)
  }

  // Combine all 3 and validate the whole user
  def validatedUser(user: User): Either[String, ValidatedUser] =
    for {
      username <- validateUsername(user.username)
      password <- validatePassword(user.password)
      dateOfBirth <- validateAge(user.dateOfBirth)
      createValidatedUser = ValidatedUser(username, password, dateOfBirth)
    } yield createValidatedUser // yielding case class (only if all methods hit the RIGHT)

  val usernameBad = User("muhammad", "Password", LocalDate.of(2002,4,30))
  val passwordBad = User("muhammadimulla", "password", LocalDate.of(2002,4,30))
  val dobBad = User("muhammadmulla", "Password", LocalDate.of(2024,4,30))
  val goodUser = User("muhammadmulla", "Password", LocalDate.of(2002,4,30))

  println(validatedUser(usernameBad)) // Left
  println(validatedUser(passwordBad)) // Left
  println(validatedUser(dobBad)) // Left
  println(validatedUser(goodUser)) // Right
}




