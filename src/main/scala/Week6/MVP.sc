// Task 1a: Passing Functions as Arguments

def increment(x: Int): Int = x + 1

def applyTwice(x: Int, f: Int => Int): Int = f(f(x))

val result = applyTwice(3, increment)
println(s"Result after applying increment function twice: $result")

// Task 1b: Creating Mathematical Operations and Using a Function

def addition(a: Double, b: Double): Double = a + b
def subtraction(a: Double, b: Double): Double = a - b
def multiplication(a: Double, b: Double): Double = a * b
def division(a: Double, b: Double): Double = a / b

def mathFunc(a: Double, b: Double, operation: (Double, Double) => Double): Double = {
  operation(a, b)
}

val addResult = mathFunc(10.0, 5.0, addition)
println(s"Addition Result: $addResult") // Output: 15.0

val subtractResult = mathFunc(10.0, 5.0, subtraction)
println(s"Subtraction Result: $subtractResult") // Output: 5.0

val multiplyResult = mathFunc(10.0, 5.0, multiplication)
println(s"Multiplication Result: $multiplyResult") // Output: 50.0

val divideResult = mathFunc(10.0, 5.0, division)
println(s"Division Result: $divideResult") // Output: 2.0

// Task 2a: Returning Functions

// Step 1: Convert a string to uppercase
def convertToUpperCase(str: String): String = {
  str.toUpperCase
}

// Step 2: Convert a string to lowercase
def convertToLowerCase(str: String): String = {
  str.toLowerCase
}

// Step 3: Return the appropriate function based on the boolean input
def convertString(makeStringUpperCase: Boolean): String => String = {
  if (makeStringUpperCase) convertToUpperCase
  else convertToLowerCase
}

// Step 4: Test the convertString function
val testString = "cOnVeRtMe"

// Applying convertString method when the input is 'true'
val toUpperCaseFunc = convertString(makeStringUpperCase = true)
println(s"Uppercase Conversion: ${toUpperCaseFunc(testString)}") // Output: "CONVERTME"

// Applying convertString method when the input is 'false'
val toLowerCaseFunc = convertString(makeStringUpperCase = false)
println(s"Lowercase Conversion: ${toLowerCaseFunc(testString)}") // Output: "convertme"

// Task 2b: Returning Arithmetic Methods

// Define arithmetic functions
def addition(a: Double, b: Double): Double = a + b
def subtraction(a: Double, b: Double): Double = a - b
def multiplication(a: Double, b: Double): Double = a * b
def division(a: Double, b: Double): Double = a / b

// Step 1: Calculate method using pattern matching to return an arithmetic function
def calculate(operation: String): (Double, Double) => Double = {
  operation match {
    case "add" => addition
    case "subtract" => subtraction
    case "multiply" => multiplication
    case "divide" => division
    case _ => throw new IllegalArgumentException("Unknown operation")
  }
}

// Step 2: Test the calculate method

// Testing calculate method with "add"
val addFunc = calculate("add")
println(s"Addition Result: ${addFunc(10.0, 5.0)}") // Output: 15.0

// Testing calculate method with "subtract"
val subtractFunc = calculate("subtract")
println(s"Subtraction Result: ${subtractFunc(10.0, 5.0)}") // Output: 5.0

// Testing calculate method with "multiply"
val multiplyFunc = calculate("multiply")
println(s"Multiplication Result: ${multiplyFunc(10.0, 5.0)}") // Output: 50.0

// Testing calculate method with "divide"
val divideFunc = calculate("divide")
println(s"Division Result: ${divideFunc(10.0, 5.0)}") // Output: 2.0

try {
  val unknownFunc = calculate("unknown")
  println(s"Result: ${unknownFunc(10.0, 5.0)}")
} catch {
  case e: IllegalArgumentException => println(e.getMessage) // Output: "Unknown operation"
}

