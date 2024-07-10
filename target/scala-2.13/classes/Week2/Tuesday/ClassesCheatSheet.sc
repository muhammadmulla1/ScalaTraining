/** With parentheses () */

//construct with no defined parameters 
class Park1

// Make objects 
new Park1

//Construct with defined parameters 
//We are not giving default values 
//We do not have to put val or var (but best practice to include )
class Park2(val rollerCoaster: Boolean, val largestLoop: Double)
//Make an object 
val x = new Park2(rollerCoaster = true, largestLoop = 4.5)
x.largestLoop
x.rollerCoaster
new Park2(rollerCoaster = false, largestLoop = 23.95)

//Extend Park2 Class = must enter values because I don't have default
object Disney extends Park2(rollerCoaster = true, largestLoop = 4.65)

//Abstract - If we are noy giving default values but are giving defined parameters
//By making it Abstract = safety net
abstract class Park3(val coaster: Boolean, val loop:Double)
//Make object of Abstract class
//new Park3 // Can't make objects of abstract classes - they must be extended to use them

//Constructing with default parameters
//Unlikely to change
class Park4(val coaster: Boolean = true, val loop: Double = 4.7)
//Make an object
new Park4 //would use default values
// do not need to use the keyword override or val/var for normal brackets
//Can override, none, 1, multiple
//If not overriding, do not include it
new Park4(coaster = false) //using default for loop but has a override for coaster

/** With curly braces {} */

//No defined parameter
class Park5{}

//Make object
new Park5

//Constructed with defined parameters (but not default) -- CANNOT DO THIS
//Make it abstract or give default values
//class Park6{
//  val coaster: Boolean
//  val loop: Double
//}

abstract class Park6{
  val coaster: Boolean
  val loop: Double
}

//Construct with default parameters
//New line
//Must specify val/var
class Park7 {
  val coaster: Boolean = true
  val loop: Double = 5.6
}

//Make object
new Park7 //use of default parameters
//Can override these
 val y = new Park7 {
  override val coaster: Boolean = false
}
y.coaster
y.loop
//We can extend
object LegoLand extends Park7
LegoLand.loop
//Override
object LegoLand2 extends Park7 {
  override val loop: Double = 3.5
}

/** Abstract classes */

/** {} */
//must use val/var
abstract class Park8 {
  val coaster: Boolean
  val loop: Double
}
//Make object
new Park8 {
   val coaster: Boolean = true
   val loop: Double = 6.32
}

//When extending - must give a value to every parameter (even if it has a default)
object HydePark extends Park8 {
  override val coaster: Boolean = false
  override val loop: Double = 0.0
}

/** () */
abstract class Park9 (val coaster: Boolean, val loop: Double)
//Make object
//new Park9(coaster = false, loop = 5.7) // - NOPE
//Extend the class we can make an object
object AnotherNewPark extends Park9(coaster = true, loop = 4.7)
//would work with no parameter names too
object AnotherNewPark extends Park9( true, 4.7)

//What is accessible?
// Will lose access to params if you remove val / var from abstract class with ()
println(AnotherNewPark.coaster)

/** () and {} */
 class Park10 (val coaster: Boolean){
  val loop: Double = 7.6
}
new Park10 (coaster = true)

//abstract class Park10 (val coaster: Boolean){
//  val loop: Double = 7.6
//}
//new Park10 (coaster = true) {
//  override val loop: Double = 6.4
//}

/** Traits */
//Without defaults
//trait CandyFloss {
//  val hasCandyFloss: Boolean
//}
//object AnotherNewPark2 extends CandyFloss{
//  override val hasCandyFloss: Boolean = true
//}

//With default value
trait CandyFloss {
  val hasCandyFloss: Boolean = true
}
object AnotherNewPark3 extends CandyFloss //could still override in the same way as above

/** Sealed keyword */
//Only access in the same file
sealed abstract class AbstractClassThatIsSealed
sealed trait  SealedTrait
//Allows for exhaustive matching - to be continued...