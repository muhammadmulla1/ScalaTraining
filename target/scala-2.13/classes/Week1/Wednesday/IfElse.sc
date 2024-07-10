val weather:String = "cold"
val season:String = "winter"

//if(weather == "cold" && season == "winter")
//{
//  println(s"It is $weather" + "! Take a coat.")
//}
//else
//{
//  println("Don't take a coat")
//}
//
//if(weather == "warm")
//{
//  println(s"It is $weather" + "! Take a coat.")
//}
//else
//{
//  println("Don't take a coat")
//}

if (weather == "cold")
{
  println("Take a coat.")
}

else if (weather == "rain.")
{
  println("take an umbrella.")
}
else
{
  println("Take nothing.")
}

// Task 1

val percentage: Double = 92.0

val grade: String = if (percentage >= 90) {
  "A"
} else if (percentage >= 80) {
  "B"
} else if (percentage >= 70) {
  "C"
} else if (percentage >= 60) {
  "D"
} else if (percentage >= 50) {
  "E"
} else {
  "F"
}

println(s"A score of $percentage% results in a grade of $grade")

//Task 2

val age: Int = 18

val filmRating: String = if (age >= 18) {
  "18"
} else if (age >= 15) {
  "15"
} else if (age >= 12) {
  "12A"
} else if (age >= 8) {
  "PG"
} else if (age >= 4) {
  "U"
} else {
  "Not suitable for any film rating"
}

println(s"At age $age, you can watch films rated $filmRating")


