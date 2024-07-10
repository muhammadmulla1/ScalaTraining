// Base Animal class
abstract class Animal(val name: String, val age: Int) {
  override def toString: String = s"Animal(Name: $name, Age: $age)"
}

// Trait for Mammals
trait Mammal extends Animal {
  val furColour: String
  val hasTail: Boolean
}

// Trait for Birds
trait Bird extends Animal {
  val beakLength: Double
  val featherColour: String
}

// Trait for Insects
trait Insect extends Animal {
  val numOfLimbs: Int
}

// Trait for species-specific information
trait Species {
  val speciesName: String
  val conservationStatus: String
  val avgLifespanRange: (Int, Int)
  val numOfYoungRange: (Int, Int)
}

// Trait for flyable animals
trait Flyable {
  val canFly: Boolean
  val wingspan: Double
}

// Specific animal classes
case class Warthog(override val name: String, override val age: Int, val furColour: String, val hasTail: Boolean, val hasTusks: Boolean)
  extends Animal(name, age) with Mammal {
  override def toString: String = s"Warthog(Name: $name, Age: $age, Fur Colour: $furColour, Has Tail: $hasTail, Has Tusks: $hasTusks)"
}

case class Owl(override val name: String, override val age: Int, val beakLength: Double, val featherColour: String, val hootsPerNight: Int)
  extends Animal(name, age) with Bird {
  override def toString: String = s"Owl(Name: $name, Age: $age, Beak Length: $beakLength, Feather Colour: $featherColour, Hoots Per Night: $hootsPerNight)"
}

case class Dragonfly(override val name: String, override val age: Int, val numOfLimbs: Int, val wingPairs: Int)
  extends Animal(name, age) with Insect with Flyable {
  override val canFly: Boolean = true
  override val wingspan: Double = wingPairs * 2.5 // Assuming each wing pair adds 2.5 units to wingspan

  override def toString: String = s"Dragonfly(Name: $name, Age: $age, Num of Limbs: $numOfLimbs, Wing Pairs: $wingPairs, Can Fly: $canFly, Wingspan: $wingspan)"
}

// Example usage
object AnimalSanctuary extends App {
  val warthog = Warthog("Pumbaa", 5, "Brown", hasTail = true, hasTusks = true)
  val owl = Owl("Hedwig", 3, 3.5, "White", 5)
  val dragonfly = Dragonfly("Blue Dasher", 1, 6, 2)

  println(warthog)
  println(owl)
  println(dragonfly)
}
