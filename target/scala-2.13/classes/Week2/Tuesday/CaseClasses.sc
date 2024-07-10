/** Case Classes */

//Extra Methods:
// apply method
// unapply method
// hashcode and equals method
// copy method
// toString method

case class SuperHero(realName: String, hereName: String, weakness: String)
//apply method
//use to make objects
val newSuperHero = SuperHero.apply("Clark Kent", "Superman", "Kryptonite")
val anotherNewSuperHero = SuperHero("Clark Kent", "Superman", "Kryptonite")

// ==
newSuperHero == anotherNewSuperHero
//Compares what makes the object - the parameters. Not the name of the object

// Copy method
val updateName = anotherNewSuperHero.copy(realName = "Clark Lane", hereName = "New Superman")
anotherNewSuperHero

// Task 1: Define the Dogs case class
case class Dogs(name: String, breed: String, age: Int)

// Task 2: Create four dog objects
val dog1 = Dogs(name = "Buddy", breed = "Golden Retriever", age = 3)
val dog2 = Dogs(name = "Bella", breed = "Labrador Retriever", age = 2)
val dog3 = Dogs(name = "Max", breed = "German Shepherd", age = 4)
val dog4 = Dogs(name = "Lucy", breed = "Beagle", age = 1)

// Task 3: Define the Cats and Birds case classes
case class Cats(name: String, color: String, age: Int, isIndoor: Boolean)
case class Birds(name: String, species: String, age: Int, canFly: Boolean)

// Define the updated Kennel case class to accept cats and birds as well
case class Kennel(name: String, dogs: List[Dogs], cats: List[Cats], birds: List[Birds])

// Create some cat objects
val cat1 = Cats(name = "Sophia", color = "Gray", age = 2, isIndoor = true)
val cat2 = Cats(name = "Shadow", color = "Black", age = 3, isIndoor = false)

// Create some bird objects
val bird1 = Birds(name = "Muhammad", species = "Canary", age = 1, canFly = true)
val bird2 = Birds(name = "Polly", species = "Parrot", age = 5, canFly = true)

// Create a kennel with a list of dogs, cats, and birds
val myKennel = Kennel(
  name = "Happy Tails Kennel",
  dogs = List(dog1, dog2, dog3, dog4),
  cats = List(cat1, cat2),
  birds = List(bird1, bird2)
)

// Print the kennel object
println(myKennel)

// Task 4: Create a new kennel with the same dogs, cats, and birds
val newKennel = Kennel(
  name = "Cozy Canine Kennel",
  dogs = List(dog1, dog2, dog3, dog4),
  cats = List(cat1, cat2),
  birds = List(bird1, bird2)
)

// Print the new kennel object
println(newKennel)


/** Case objects*/
case object Hulk
case object SuperMan