//1

/** Default Implementations
Case Classes:

 Automatic equals and hashCode Methods: Case classes automatically get equals and hashCode methods, which are based on the values of their parameters. This makes case classes useful for comparing instances and using them in collections that rely on hashing, like sets and maps.
Automatic toString Method: Case classes automatically get a toString method that returns a string representation of the object, including its class name and parameter values.
  Automatic copy Method: Case classes have a copy method, which allows for creating a new instance with some parameters modified while keeping the rest unchanged.
Classes:

  No Automatic Implementations: Regular classes do not have these methods automatically generated. If you need equals, hashCode, or toString methods, you have to define them explicitly. There is no built-in copy method for regular classes.
2. Pattern Matching
Case Classes:

  Pattern Matching: Case classes are designed to work seamlessly with pattern matching. The constructor parameters of a case class are automatically treated as public val fields, and case classes are decomposable in match expressions, making it easy to destructure and work with their contents.
Classes:

  No Built-In Support for Pattern Matching: Regular classes do not support pattern matching out of the box. To use pattern matching with a regular class, you need to explicitly define an unapply method in a companion object, which adds extra boilerplate.
3. Immutability and val Parameters
Case Classes:

  Immutability: The parameters of a case class are by default immutable (val), which means once an instance is created, its parameters cannot be changed. This makes case classes well-suited for functional programming paradigms where immutability is a key concept.
  Default val Parameters: The constructor parameters are implicitly public val, which means they are accessible as public fields of the class.
Classes:

  Mutable or Immutable: In a regular class, you can choose whether the parameters are mutable (var) or immutable (val). This provides more flexibility but requires more careful management to ensure immutability where needed.
Explicit Parameter Fields: The constructor parameters do not automatically become fields of the class. You need to explicitly declare them if you want to access them as fields.
*/
//2

case class Person(name: String, age: Int, nationality: String, isStudent:
Boolean)

val firstPerson = new Person ("Carlos", 23, "Spanish", true)

val secondPerson = Person("Carlos", 23, "Spanish", true)

val thirdPerson = Person("Chloe", 25, "British", false)

class Animal (name: String, colour: String, pet: Boolean)

//val cat = Animal("cat", "black", true)
//Because Animal is likely an abstract class and cannot be
//instantiated directly.

val dog = new Animal ("dog", "white",true)

// 3
case class Muffin(flavour: String, price: Double, storeBoughtFrom: String)

val chocolateMuffin = Muffin("chocolate", 3.50, "Mercator Bakery")
val blueberryMuffin = Muffin("blueberry", 3.50, "Mercator Bakery")
val vanillaMuffin = Muffin("vanilla", 3.50, "Mercator Bakery")
val anotherChocolateMuffin = Muffin("chocolate", 3.50, "Mercator Bakery")
val oneMoreChocolateMuffin = Muffin("Chocolate", 3.50, "Mercator Bakery")
val finalChocolateMuffin = Muffin("chocolate", 2.50, "MercatorBakery")

// Comparisons and their results
println(chocolateMuffin == blueberryMuffin)           // false - Different `flavour` field values
println(chocolateMuffin == vanillaMuffin)             // false - Different `flavour` field values
println(chocolateMuffin == anotherChocolateMuffin)    // true  - All field values are identical
println(chocolateMuffin == oneMoreChocolateMuffin)    // false - `flavour` field values differ by case sensitivity ("chocolate" vs. "Chocolate")
println(chocolateMuffin == finalChocolateMuffin)      // false - Different `flavour` and `price` field values, and `storeBoughtFrom` has slight difference ("Mercator Bakery" vs. "MercatorBakery")

println(blueberryMuffin == vanillaMuffin)             // false - Different `flavour` field values
println(blueberryMuffin == anotherChocolateMuffin)    // false - Different `flavour` field values
println(blueberryMuffin == oneMoreChocolateMuffin)    // false - Different `flavour` field values
println(blueberryMuffin == finalChocolateMuffin)      // false - Different `flavour` and `price` field values, and `storeBoughtFrom` has slight difference

println(vanillaMuffin == anotherChocolateMuffin)      // false - Different `flavour` field values
println(vanillaMuffin == oneMoreChocolateMuffin)      // false - Different `flavour` field values
println(vanillaMuffin == finalChocolateMuffin)        // false - Different `flavour` and `price` field values, and `storeBoughtFrom` has slight difference

println(anotherChocolateMuffin == oneMoreChocolateMuffin) // false - `flavour` field values differ by case sensitivity ("chocolate" vs. "Chocolate")
println(anotherChocolateMuffin == finalChocolateMuffin)   // false - Different `flavour` and `price` field values, and `storeBoughtFrom` has slight difference

println(oneMoreChocolateMuffin == finalChocolateMuffin)   // false - Different `flavour` and `price` field values, and `storeBoughtFrom` has slight difference
