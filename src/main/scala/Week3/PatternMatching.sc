

val weather: String = "Cold"

if (weather == "cold") {
  println("Take a coat.")
} else if (weather == "rain") {
  println("Take an umbrella.")
} else {
  println(s"$weather is not valid")
}

weather.toLowerCase match {
  case "cold" => println("Take a coat.")
  case "rain" => println("Take an umbrella.")
  case _=> println(s"$weather is not valid")
}

// Match off int
val numOfWatermelons: Int = 3
numOfWatermelons match {
  case 0 => println("Must be more than 0")
  case x if x <=0 => println("Must be more than 0")
  case 1| 2 | 3 => println ("John can carry these without a bag")
  case 4| 5 => println ("John needs a bag")
  case _ => println(s"$numOfWatermelons is not valid")
}

// if guard - be careful of ordering