/** Higher order functions */

//What does it mean to be a first class citizen?
//We can:

//1. assign functions to vals:
val addition: (Int, Int) => Int = (x, y) => x + y
addition(1, 2)
val subtract: (Int, Int) => Int = (x, y) => x - y

//2. store functions in collections (e.g. lists, maps, etc.)
val functionList = List(
  (a: Int, b: Int) => a + b,
  (a: Int, b: Int) => a * b,
  (a: Int, b: Int) => a - b
)
functionList.head(1, 2) // first function
functionList(1)(3, 4) // second function in index position 1
functionList(2)(10, 4) // third function

// 3. pass functions into arguments/params
def manipulateNumbers(x: Int, y: Int, function: (Int, Int) => Int): Int = {
  function(x, y)
}

manipulateNumbers(10, 10, addition)
manipulateNumbers(10, 5, subtract)

// as long as it follows the rule which is (x:Int, y:Int, function:(Int,Int)=>Int), any function can be passed through

// 4. return functions from other functions
def createAdditionFunction(x: Int): Int => Int = {
  //println(s"$x")
  (y: Int) => x + y
}
createAdditionFunction(1)
val addOne: Int => Int = createAdditionFunction(1)
addOne(7)

/** Functions as params */
def firstHOF(x: Int, function: Int => Int): Int = {
  function(x)
}

def addTwo(n: Int): Int = n + 2
firstHOF(3, addTwo)
def square(n: Int): Int = n * n
firstHOF(3, square)

def processTheList(list1: List[String], function: String => String): List[String] = {
  list1.map(function)
}
def addS(word: String): String = word + "s"
def upperCase(word: String): String = word.toUpperCase
val newList: List[String] = List("apple", "banana", "pear", "mango")
processTheList(newList, addS)
processTheList(newList, upperCase)

//map = common HOF
val numbers = Seq(1, 2, 3, 4, 5)
val doubledNumbers = numbers.map(num => num * 2)

//foldLeft - used to reduce a collection into a single value
val foldLeftExample = numbers.foldLeft(0)(_ + _) // (_ + _) - (acc + current value)

val stringList = List("we", "love", "scala")
val concatenatedString = stringList.foldLeft("")(_ + " " + _).trim

// foldRight
val foldRightExample = numbers.foldRight(0)(_ + _)
//val concatenatedString = stringList.foldRight("")(_ + " " + _).trim

case class Male(male: Boolean)

case class Animal(name: String, male: Male)

val animalList = List(Animal("Fred to Fox", Male(true)), Animal("Sally the Seahorse", Male(false)), Animal("Lucky the Lion", Male(true)))

val foldAnimalsLeft = animalList.foldLeft(List[String]()) { (acc, animal) =>
  val sirOrMadam = animal.male match {
    case Male(true) => "Sir"
    case Male(false) => "Madam"
  }
  acc :+ s"$sirOrMadam ${animal.name}"
}
println(foldAnimalsLeft)

val foldAnimalsRight = animalList.foldRight(List[String]()) { (animal, acc) =>
  val sirOrMadam = animal.male match {
    case Male(true) => "Sir"
    case Male(false) => "Madam"
  }
  acc :+ s"$sirOrMadam ${animal.name}"
}
println(foldAnimalsRight)

// Task 1
val numbers = Seq(1, 2, 3, 4, 5)

val product = numbers.fold(1)(_ * _)

val stringList = List("we", "love", "scala")

val totalCharacters = stringList.foldLeft(0)((acc, str) => acc + str.length)

val capitalisedList = stringList.map(word => word.capitalize)

val sentence = capitalisedList.mkString(" ")

/** Returning functions */

def smallRise(salary: Double): (Int, Double) => Double = {
  (lengthOfEmployment: Int, salary: Double) => salary * 1.1
}

def mediumRise(salary: Double): (Int, Double) => Double = {
  (lengthOfEmployment: Int, salary: Double) => salary * 1.2
}

def largeRise(salary: Double): (Int, Double) => Double = {
  (lengthOfEmployment: Int, salary: Double) => salary * 1.5
}

case class Employee(name: String, salary: Double, lengthOfEmployment: Int)

def getPayRise (employee: Employee): (Int, Double) => Double = {
  employee.lengthOfEmployment match {
    case year if year <= 3 => smallRise(employee.salary)
    case year if year <= 5 => mediumRise(employee.salary)
    case year if year >  5  => largeRise(employee.salary)
  }
}

val Amanda = Employee("Amanda", 30000.0, 2)
val choosePayRise = getPayRise(Amanda)
val getNewSalary = choosePayRise(Amanda.lengthOfEmployment, Amanda.salary)

def smallRise(salary: Double): (Int, Double) => Double = {
  (lengthOfEmployment: Int, salary: Double) => salary * 1.1
}

/** Task 2 */

def lowDiscount(price: Double): () => Double = {
  () => price * 0.20
}

def mediumDiscount(price: Double): () => Double = {
  () => price * 0.40
}

def highDiscount(price: Double): () => Double = {
  () => price * 0.50
}

def getDiscount(price: Double): () => Double = {
  price match {
    case p if p < 20 => lowDiscount(price)
    case p if p >= 20 && p <= 50 => mediumDiscount(price)
    case p if p > 50 => highDiscount(price)
  }
}

// Example usage:
val itemPrice1 = 15.0
val itemPrice2 = 35.0
val itemPrice3 = 60.0

val discountForItem1 = getDiscount(itemPrice1)
val discountForItem2 = getDiscount(itemPrice2)
val discountForItem3 = getDiscount(itemPrice3)