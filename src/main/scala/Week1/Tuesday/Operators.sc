//Arithmetic

// + (a+b)
// - (a-b)
// / (a/b)
// * (a*b)
// % (a%b) - modulus -  finds the remainder

val a:Int = 10
val b:Int = 5
val c:Int = 3

val add = a + b
val subtract = a - b
val divide = a/b
val multiply = a * b
val modulus = a % c

// Relational

// Compare 2 booleans
// == (Equality)
// != (Inequality)
// < (less than)
// <= (less than or equal to)
// > (Greater than)
// >= (Greater than or equal to)

val equality = a == a
val inequality = a != a
val lessThan = a < b
val lessThanOrEqualTo = a <= b
val greaterThan = a > b
val greaterThanOrEqualTo = a >= b

//Logical

//Combine Boolean

val and = true && true
val and = true && false //both
val or = true || false // only 1
val not = !false
val not = !true

//a
val four = 4
val three = 3
val fiftyFive = 55
val threeHundred = 300

val sum = four + three
val product = sum * fiftyFive

val isLessThanThreeHundred = product < threeHundred

//b

val ninetysix = 96
val twelve = 12
val eight = 8

val sum = ninetysix / twelve
val logical = sum >= eight

//c

val string = "Hippo"
val string = "Hamster"
val sum = "Hamster" < "Hippo"

//d - 8 is even
8 % 2 == 0

//e - 156 /8 is < 20 and 54 is < 20 and 54 / 4 is < 14
156 / 8 < 20 && 54 < 20 && 54 / 5 < 14