package Week3.Thursday

object ForComp extends App {

// <-
/** Classic */

  def retrieveNumbers: Seq[Int] = for (numbers <- 1 to 10) yield numbers
  println(retrieveNumbers)

  def squareNumbers: Seq[Int] = for (numbers <- 1 to 10) yield numbers * numbers
  println(squareNumbers)

  def ifGuardNumbers: Seq[Int] = for (numbers <- 1 to 10 if numbers % 2 == 0) yield numbers
  println(ifGuardNumbers)

/** Use with case classes  */
sealed trait Colour
  case object Blue extends Colour
  case object Green extends Colour
  case object Yellow extends Colour

  case class Pencil(colour: Colour, sharpened: Boolean)
  def getPencils: List[Pencil] = for {
    colour <- List(Blue, Green, Yellow)
    sharpened <- List(true, false)
  } yield Pencil(colour, sharpened)

  println(getPencils)
}

// Task
object NameMachine {

  def capitaliseNames(names: List[String]): List[String] = {
    for (name <- names) yield name.toUpperCase
  }

  def capitaliseFirstLetter(names: List[String]): List[String] = {
    for (name <- names) yield name.capitalize
  }

  def main(args: Array[String]): Unit = {
    val names = List("alice", "bob", "charlie", "diana")

    val capitalisedNames = capitaliseNames(names)
    println(s"All letters capitalised: $capitalisedNames")

    val firstLetterCapitalisedNames = capitaliseFirstLetter(names)
    println(s"First letter capitalised: $firstLetterCapitalisedNames")
  }
}



