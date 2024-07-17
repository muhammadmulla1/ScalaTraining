// Match of vals

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
  case _ => println(s"$weather is not valid")
}

// Match off int
val numOfWatermelons: Int = 3
numOfWatermelons match {
  case 0 => println("Must be more than 0")
  case x if x <= 0 => println("Must be more than 0")
  case 1 | 2 | 3 => println("John can carry these without a bag")
  case 4 | 5 => println("John needs a bag")
  case _ => println(s"$numOfWatermelons is not valid")
}

// if guard - be careful of ordering

//Matching off objects
sealed trait Temperature // can only be extended within the same file that it s defined in

object Cold extends Temperature

object Hot extends Temperature

object Mild extends Temperature

val weather: Temperature = Cold

weather match {
  case Cold => "Take a coat"
  case Hot => "Wear sun cream"
  case Mild => "Light jacket"
  case _ => "Not valid"
}

// Match using classes
abstract class Notification // Cannot be instantiated - must be extended

case class Email(sender: String, title: String, body: String) extends Notification

case class SMS(caller: String, message: String) extends Notification

case class VoiceRecording(contactName: String, link: String) extends Notification

val notification: Notification = SMS("Mum", "Are you home?")

notification match {
  case Email(sender, title, body) => "Email from " + sender + "Title " + title
  case SMS(caller, message) if caller == "Mum" => "SMS from " + caller + ". Don't ignore."
  case SMS(caller, message) => "SMS from " + caller
  case VoiceRecording(contactName, link) => "Recording form " + contactName + "With link " + link
  case _ => ""
}