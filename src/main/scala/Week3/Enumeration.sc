// Finite sets of data

/** Native */
object Weekday extends Enumeration {
  val Monday, Tuesday, Wednesday, Thursday, Friday, Saturday, Sunday = Value
}

println(Weekday.Monday.toString)

// Useful for acronyms
object BetterWeekday extends Enumeration {
  val Monday = Value(1)
  val Tuesday = Value(2)
  val Wednesday = Value(3)
  val Thursday = Value(4)
  val Friday = Value(5)
  val Saturday = Value(6)
  val Sunday = Value(0)
}

println(BetterWeekday.values)

// Weekday comparison example
println(Weekday.Monday.id < Weekday.Sunday.id)

def exhaustiveMatch(weekday: BetterWeekday.Value): String = {
  weekday match {
    case BetterWeekday.Monday => "Mon"
    case BetterWeekday.Tuesday => "Tue"
    case BetterWeekday.Wednesday => "Wed"
    case BetterWeekday.Thursday => "Thu"
    case BetterWeekday.Friday => "Fri"
    case BetterWeekday.Saturday => "Sat"
    case BetterWeekday.Sunday => "Sun"
  }
}

def nonExhaustiveMatch(weekday: BetterWeekday.Value): String = {
  weekday match {
    case BetterWeekday.Monday => "Mon"
    case BetterWeekday.Tuesday => "Tue"
    case BetterWeekday.Wednesday => "Wed"
    case BetterWeekday.Thursday => "Thu"
    case BetterWeekday.Friday => "Fri"
    case BetterWeekday.Saturday => "Sat"
    case BetterWeekday.Sunday => "Sun"
  }
}

// Example usage
val day: BetterWeekday.Value = BetterWeekday.Monday
println(exhaustiveMatch(day))

/** Sealed case objects */
sealed trait Weekday

case object Monday extends Weekday

case object Tuesday extends Weekday

case object Wednesday extends Weekday

case object Thursday extends Weekday

case object Friday extends Weekday

case object Saturday extends Weekday

case object Sunday extends Weekday

def caseObjectMatch(weekday1: Weekday): String = {
  weekday1 match {
    case Monday => "Yay it's Monday"
    case Tuesday => "T"
    case Wednesday => "W"
    case Thursday => "Thurs"
    case Friday => "Fri"
    case Saturday => "Sat"
    case Sunday => "Sun"
  }
}

// must be exhaustive - compilation warning if not
// no easy way to access all values
// no default ordering

abstract class Error (name: String, errorCode: Int)
case object WeekdayNotFound extends Error("Weekday not found", 404)



// Enumeration Task
object Family extends Enumeration {
  val Mum, Dad, Brother, Sister, Grandma, Grandad, Uncle = Value
}

println(Family.values)
println(Family.values.mkString(", "))


/** Sealed case objects */
sealed trait Family

case object Mum extends Family

case object Dad extends Family

case object Brother extends Family

case object Sister extends Family

case object Grandma extends Family

case object Grandad extends Family

case object Uncle extends Family

def caseObjectMatch(family1: Family): String = {
  family1 match {
    case Mum => "M"
    case Dad => "D"
    case Brother => "B"
    case Sister => "S"
    case Grandma => "GM"
    case Grandad => "GD"
    case Uncle => "U"
  }
}

val familyMember: Family = Brother
println(caseObjectMatch(familyMember))