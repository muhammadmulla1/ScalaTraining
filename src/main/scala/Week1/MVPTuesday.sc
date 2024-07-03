// 1a - Three plus four, times fifty-seven is less than three-hundred
val three = 3
val four = 4
val fiftyseven = 57
val threehundred = 300
val sum = three + four
val sum2 = sum * fiftyseven
val answer = sum2 < threehundred

// 1b - One-hundred and forty-four, divided by 12 is greater than twelve or equal to twelve
val OneHundredAndFourtyFour = 144
val twelve = 12
val sum = OneHundredAndFourtyFour / 12
val answer = sum >= 12

// 1c - Cat is less than Dog (strings)
val string = "Cat"
val string = "Dog"
val sum = "Cat" < "Dog"

// 1d - Rabbit is less than Hamster (strings)
val string = "Rabbit"
val string = "Hamster"
val sum = "Rabbit" < "Hamster"

// 1e - Seventeen is odd (modulus)
val seventeen = 17
val isSeventeenOdd = seventeen % 2 != 0

// 1f - Seventy-five divided by nine is less than thirty and eighty-nine divided by six is less than twenty
val seventyfive = 75
val nine = 9
val thirty = 30

val sum = seventyfive / nine
val answer = sum > 30

val eightynine = 89
val six = 6
val twenty = 20

val sum = eightynine / six
val answer = sum < twenty


// 2
// Purpose:

//A string is for storing and manipulating text.
//println is for displaying text to the console.

//Usage:

//A string can be used in various contexts (assigned to variables, passed to functions, etc.).
//println is specifically used for outputting text.

//Functionality:

//A string does not produce any output by itself; it merely represents text data.
//println produces output to the console.

//3

// Storing values using val (immutable)
val num1: Int = 17
val num2: Int = 4

// Storing a variable using var (mutable)
var num3: Int = 10

// Defining some strings
val str1: String = "Hello"
val str2: String = "World"

// Arithmetic operations
val sum = num1 + num2        // 17 + 4 = 21
val difference = num1 - num2 // 17 - 4 = 13
val product = num1 * num2    // 17 * 4 = 68
val quotient = num1 / num2   // 17 / 4 = 4 (integer division)
val remainder = num1 % num2  // 17 % 4 = 1

// String concatenation
val greeting = str1 + " " + str2 // "Hello World"

// String comparison
val isEqual = str1 == str2    // false
val isLessThan = str1 < str2  // true, because "Hello" is lexicographically less than "World"

// Using the variable
num3 = num3 + 5               // num3 was 10, now it's 15

// Checking odd/even using modulus
val isNum1Odd = num1 % 2 != 0 // true, because 17 is odd

// Exploring type inference
val inferredInt = 42          // Scala infers this as Int
val inferredString = "Scala"  // Scala infers this as String

// Playing with more complex expressions
val complexExpression = (num1 + num2 * num3) < (num3 * 2)
println(s"Is (num1 + num2 * num3) < (num3 * 2)? $complexExpression")

// Checking type mismatches (commented out to prevent errors)
// val incorrectType: String = 123 // This will cause a type mismatch error

// Attempting to reassign a val (commented out to prevent errors)
// num1 = 20 // This will cause an error because num1 is a val and cannot be reassigned

// Exploring floating-point arithmetic
val floatingSum = 1.5 + 2.3  // 3.8
println(s"Floating-point sum: $floatingSum")

// Mixing types in expressions
val mixedSum = num1 + 1.5  // This will be inferred as a Double
println(s"Mixed type sum (Int + Double): $mixedSum")
