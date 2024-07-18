//1

import java.time.LocalDate

val country: String = "spain"

if (country.toLowerCase() == "england") {
  println("london")
} else if (country.toLowerCase() == "spain") {
  println("madrid")
} else if (country.toLowerCase() == "france") {
  println("paris")
} else if (country.toLowerCase() == "germany") {
  println("berlin")
} else if (country.toLowerCase() == "portugal") {
  println("lisbon")
} else {
  println(s"$country is not valid")
}

country.toLowerCase match {
  case "england" => println("London")
  case "spain" => println("Madrid")
  case "france" => println("Paris")
  case "germany" => println("Berlin")
  case "portugal" => println("Lisbon")
  case _ => println(s"$country is not valid")
}

//2
import java.time.LocalDate

// Define the calculateStarSign function
def calculateStarSign(date: LocalDate): String = {
  val (month, day) = (date.getMonthValue, date.getDayOfMonth)

  (month, day) match {
    case (1, _) if day <= 19 => "Capricorn"
    case (1, _) if day >= 20 => "Aquarius"
    case (2, _) if day <= 18 => "Aquarius"
    case (2, _) if day >= 19 => "Pisces"
    case (3, _) if day <= 20 => "Pisces"
    case (3, _) if day >= 21 => "Aries"
    case (4, _) if day <= 19 => "Aries"
    case (4, _) if day >= 20 => "Taurus"
    case (5, _) if day <= 20 => "Taurus"
    case (5, _) if day >= 21 => "Gemini"
    case (6, _) if day <= 20 => "Gemini"
    case (6, _) if day >= 21 => "Cancer"
    case (7, _) if day <= 22 => "Cancer"
    case (7, _) if day >= 23 => "Leo"
    case (8, _) if day <= 22 => "Leo"
    case (8, _) if day >= 23 => "Virgo"
    case (9, _) if day <= 22 => "Virgo"
    case (9, _) if day >= 23 => "Libra"
    case (10, _) if day <= 22 => "Libra"
    case (10, _) if day >= 23 => "Scorpio"
    case (11, _) if day <= 21 => "Scorpio"
    case (11, _) if day >= 22 => "Sagittarius"
    case (12, _) if day <= 21 => "Sagittarius"
    case (12, _) if day >= 22 => "Capricorn"
    case _ => "Unknown"
  }
}

//3
// Define the horoscope method
def horoscope(date: LocalDate): (String, String) = {
  val starSign = calculateStarSign(date)

  starSign match {
    case "Capricorn" => (starSign, "You will have a productive day.")
    case "Aquarius" => (starSign, "New opportunities are coming your way.")
    case "Pisces" => (starSign, "Listen to your intuition.")
    case "Aries" => (starSign, "Focus on your goals and take action.")
    case "Taurus" => (starSign, "Enjoy the comforts of life today.")
    case "Gemini" => (starSign, "Communicate clearly to avoid misunderstandings.")
    case "Cancer" => (starSign, "Spend time with loved ones.")
    case "Leo" => (starSign, "Show your creativity and leadership.")
    case "Virgo" => (starSign, "Organize your tasks and stay disciplined.")
    case "Libra" => (starSign, "Seek harmony in your relationships.")
    case "Scorpio" => (starSign, "Trust your instincts.")
    case "Sagittarius" => (starSign, "Embrace adventure and explore new ideas.")
    case _ => ("Unknown", "No horoscope available for this star sign.")
  }
}

// Example usage
val today = LocalDate.now()
val (sign, message) = horoscope(today)
println(s"Today's horoscope for $sign: $message")

//4
trait Animal

case class Dog(name: String, breed: String) extends Animal
case class Cat(name: String, color: String) extends Animal
case class Bird(name: String, species: String) extends Animal

def animalFacts(animal: Animal): String = {
  animal match {
    case Dog(name, breed) => s"$name is a $breed breed of dog."
    case Cat(name, color) => s"$name is a $color cat."
    case Bird(name, species) => s"$name is a $species bird."
    case _ => "Unknown animal."
  }
}

val myDog = Dog("Buddy", "Golden Retriever")
val myCat = Cat("Whiskers", "Tabby")
val myBird = Bird("Polly", "Parrot")

println(animalFacts(myDog))
println(animalFacts(myCat))
println(animalFacts(myBird))

// Extension

// List of Critically Endangered Species
val criticallyEndangered: List[String] = List(
  "Black Rhino", "African forest Elephant", "Orangutan",
  "Hawksbill Turtle", "Sunda Tiger", "Javan Rhino"
)

// Animal Trait and Case Classes
sealed trait Animal {
  val speciesName: String
}

case class Whale(speciesName: String) extends Animal
case class Rhino(speciesName: String) extends Animal
case class Elephant(speciesName: String) extends Animal
case class Turtle(speciesName: String) extends Animal
case class Tiger(speciesName: String) extends Animal
case class Orangutan(speciesName: String) extends Animal

// Other animals without endangered species
case class Dog(speciesName: String) extends Animal
case class Cat(speciesName: String) extends Animal

// Animal Facts Function with Pattern Matching and Guards
def animalFacts(animal: Animal): String = {
  animal match {
    case Rhino(speciesName) if criticallyEndangered.contains(speciesName) =>
      s"The $speciesName is a critically endangered species."
    case Rhino(speciesName) =>
      s"The $speciesName is a species of rhino."

    case Elephant(speciesName) if criticallyEndangered.contains(speciesName) =>
      s"The $speciesName is a critically endangered species."
    case Elephant(speciesName) =>
      s"The $speciesName is a species of elephant."

    case Turtle(speciesName) if criticallyEndangered.contains(speciesName) =>
      s"The $speciesName is a critically endangered species."
    case Turtle(speciesName) =>
      s"The $speciesName is a species of turtle."

    case Tiger(speciesName) if criticallyEndangered.contains(speciesName) =>
      s"The $speciesName is a critically endangered species."
    case Tiger(speciesName) =>
      s"The $speciesName is a species of tiger."

    case Orangutan(speciesName) if criticallyEndangered.contains(speciesName) =>
      s"The $speciesName is a critically endangered species."
    case Orangutan(speciesName) =>
      s"The $speciesName is a species of orangutan."

    case Whale(speciesName) =>
      s"The $speciesName is a species of whale."

    // Non-endangered species
    case Dog(speciesName) =>
      s"The $speciesName is a species of dog."
    case Cat(speciesName) =>
      s"The $speciesName is a species of cat."

    // Exhaustive case for other animals
    case _ =>
      s"Unknown animal species: ${animal.speciesName}"
  }
}

// Example usage
val animals = List(
  Rhino("Black Rhino"),
  Elephant("African forest Elephant"),
  Turtle("Hawksbill Turtle"),
  Tiger("Sunda Tiger"),
  Orangutan("Orangutan"),
  Whale("Blue Whale"),
  Dog("German Shepherd"),
  Cat("Siamese Cat")
)

animals.foreach(animal => println(animalFacts(animal)))
