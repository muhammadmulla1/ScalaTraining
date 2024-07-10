/** Classes */
//Capital for the name
//Declare using 'class'
//Act as blueprints

//1 - unimplemented members
class ThemeParkEmptyParams(val hasRollerCoasters: Boolean, val diameterOfLargestLoop: Double)

// 2 - implement members
//{} braces
//Default parameters
class ThemeParkDefaultParams{
  val hasRollerCoasters: Boolean = true
  val diameterOfLargestLoop: Double = 30.24
}

// Everything inside {} belong to the class - known as members

class ThemeParkBoth (val diameterOfLargestLoop: Double){
  val hasRollerCoasters: Boolean = true
}

// Use classes to make objects
/** Objects */

// State - attributes or properties
// Behaviour - methods that will give a response when called
// Identity - the name given to allow interaction between different objects
// Keyword - new

//Empty params
val mercatorPark : ThemeParkEmptyParams = new ThemeParkEmptyParams(hasRollerCoasters = true, diameterOfLargestLoop = 7.95)
mercatorPark.getClass
mercatorPark.hasRollerCoasters
mercatorPark.diameterOfLargestLoop

//Default params
val disneyWorld: ThemeParkDefaultParams = new
ThemeParkDefaultParams()
disneyWorld.diameterOfLargestLoop

/** Parameters*/
// Meaningful name
// raw or existing values van be passed in

class Hamster (age: Int, val colour: String)
val orange:String = "Orange"
// make the hamster object
val BooTheHamster: Hamster = new Hamster(1, orange)


/** Objects without classes */
// Used when we only need 1 of something
// Don't use the new keyword
// Have no params
// Available globally

object DavidsDogs{
  val Loki: String = "Loki"
  val Tayamul: String = "Tayamul"
  val Isla: String = "Isla"
  val Bilal: String = "Bilal"
  val Oscar: String = "Oscar"
}
DavidsDogs.Loki
DavidsDogs.Isla

/** Inheritance */
// Use the 'extends' keyword
// declare the class we want to extent
// class we extend from is called the 'parent' or 'superclass'
// Can only extend 1 class

//class Bakken extends ThemeParkDefaultParams{
//  override val diameterOfLargestLoop: Double = 20.15
//  val oldestThemePark: Boolean = true
//}

class Bakken extends ThemeParkEmptyParams (hasRollerCoasters
= true, diameterOfLargestLoop =  20.15){
  val oldestThemePark: Boolean = true
}

// Task

// Define a Person class
class Person(val firstName: String, val surname: String) {
  override def toString: String = s"$firstName $surname"
}

// Define a Family class
class Family(val parents: (Person, Person), val children: Seq[Person]) {
  def addChild(child: Person): Family = {
    new Family(parents, children :+ child)
  }

  override def toString: String = {
    s"Parents: ${parents._1} and ${parents._2}, Children: ${children.mkString(", ")}"
  }
}

object FamilyTreeApp extends App {
  // Initial family setup
  val father = new Person("John", "Smith")
  val mother = new Person("Jane", "Smith")
  val child = new Person("Tom", "Smith")

  val initialFamily = new Family((father, mother), Seq(child))
  println(s"Initial Family: $initialFamily")

  // Child grows up, gets a girlfriend, and gets married
  val girlfriend = new Person("Alice", "Johnson")
  val wife = new Person("Alice", "Smith") // After marriage, surname changes
  val newFamily = new Family((child, wife), Seq())

  println(s"New Family: $newFamily")

  // They have a child
  val theirChild = new Person("Sam", "Smith")
  val expandedFamily = newFamily.addChild(theirChild)

  println(s"Expanded Family: $expandedFamily")
}

// Family tree task

class Person (firstName: String){
  val surname: String = "Smith"
}

class Dad extends Person ("Steve")

class girlFriend extends Person ("Jess") {
  override val surname: String = "Jones"
}

/** Traits */
// Keyword - with
// Extend multiple traits
// Traits can have unimplemented members
// Cannot create an instance of a trait like a class
// Must be used in combination

trait Mascot {
  val nameOfMainCharacter: String
}

trait OversizedFood {
  val hugeTurkeyLeg: Boolean
}

class DisneyWorld extends ThemeParkDefaultParams with Mascot
  with OversizedFood
{
  override val nameOfMainCharacter: String = "Mickey"
  override val hasRollerCoasters: Boolean = false
  override val hugeTurkeyLeg: Boolean = true
}