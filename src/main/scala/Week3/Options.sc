
trait Pizza {
  val size: Int
  val crust: Option[String]
}

object Personal extends Pizza {
  val size: Int = 7
  val crust: Option[String] = None
}

object smallClassic extends Pizza {
  val size: Int = 9
  val crust: Option[String] = Some("classic")
}

object smallItalian extends Pizza {
  override val size: Int = 9
  override val crust: Option[String] = Some("Italian")
}

val pizzaOrder: Pizza = new Pizza {
  override val size: Int = 9
  override val crust: Option[String] = Some("Italian")
}

def whatCrust(pizza: Pizza): String = {
  pizza.crust match {
    case Some("classic") => "classic crust"
    case Some("italian") => "italian crust"
    case Some(x) => s"$x is not a valid crust type"
    case None => "Default crust - classic"
  }
}

whatCrust(pizzaOrder)


// .get
val getCrust: String = pizzaOrder.crust.get // bad practice

// .getOrElse - allows for default to be given
val getOrElseCrust: String = pizzaOrder.crust.getOrElse("classic")

// Task

// Task

case class ChocolateBar(filling: Option[String])

object ChocolateBar {
  def getFilling(chocolateBar: ChocolateBar): String = {
    chocolateBar.filling.getOrElse("Default Filling")
  }
}

// Demonstrating the functionality with some chocolate objects
val milkChocolate = ChocolateBar(Some("Hazelnut"))
val darkChocolate = ChocolateBar(Some("Pistachio"))
val whiteChocolate = ChocolateBar(Some("Wholenut"))
val plainChocolate = ChocolateBar(None)

