// Task 1
val numberOfWatermelons: Int = 4

// Task 2:
if (numberOfWatermelons <= 3) {
  println(s"John doesn't need a bag to carry $numberOfWatermelons watermelons.")
} else if (numberOfWatermelons <= 5) {
  println(s"John needs a bag to carry $numberOfWatermelons watermelons.")
} else {
  println(s"John can't carry $numberOfWatermelons watermelons.")
}

// Task 3: Use string interpolation to add to each message the number of watermelons John is trying to buy
// Already done in Task 2 using the `s` interpolator

// Task 4:
val hasBag: Boolean = true

// Task 5:
if ((hasBag && numberOfWatermelons <= 5) || (!hasBag && numberOfWatermelons <= 3)) {
  println(s"John can carry $numberOfWatermelons watermelons.")
} else {
  println(s"John cannot carry $numberOfWatermelons watermelons.")
}

// Task 6:
val pricePerWatermelon: Double = 1.397
val totalCost: Double = numberOfWatermelons * pricePerWatermelon

// Using string interpolation to display the total cost to 2 decimal places
println(f"The total cost of $numberOfWatermelons watermelons is £$totalCost%.2f")

//Extension

//1. Order of Precedence for Logical Operators
//  The order of precedence for logical operators in Scala (and many other programming languages) is as follows:
//
//  ! (NOT)
//&& (AND)
//|| (OR)
//This means that ! has the highest precedence, followed by &&, and then ||. Parentheses can be used to explicitly control the order of evaluation.
//
//2. Evaluating (true || false && false)
//Based on the order of precedence:
//
//  && has higher precedence than ||.
//So, let's evaluate step by step:
//
//  false && false evaluates to false.
//true || false evaluates to true.
//  Therefore, (true || false && false) results in true.
//
//3. Evaluating ((true || false) && false)
//Here, the parentheses (true || false) are evaluated first:
//
//  true || false evaluates to true.
//  Then, true && false is evaluated:
//
//  true && false evaluates to false.
//  Therefore, ((true || false) && false) results in false.

//4
// Corrected expression: (1 < 48) && (71 == 10 || 19 + 10 == 29)
val result: Boolean = (1 < 48) && (71 == 10 || 19 + 10 == 29)

// Print the result
println(s"The result of (1 < 48) && (71 == 10 || 19 + 10 == 29) is $result")


