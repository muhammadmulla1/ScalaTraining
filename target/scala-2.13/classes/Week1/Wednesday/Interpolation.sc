// S

val name: String = "Muhammad"
println(s"My name is $name")

println(s"3 x 3 = ${3*3}")

val number: Int = 7
println((s"$number x $number = ${number*number}"))

//F
// %f - floating point number
// %d - decimal
// %i - int

val pi: Double = 3.141592635897
println((f"Pi to 2dp is $pi%.2f"))
println((f"Pi to 4dp is $pi%.4f")) // after the dot is how many characters
println((f"Pi to 2dp but with 16 width is $pi%16.4f")) // before the dot is how many characters

println("Hello \nWorld")

printf("'%s", "Hello")
printf("'%s'", name)
printf("'%16s'", name)
//printf("'%+16s+'", name)
printf("'%-16s'", name) // positive and negative before and after

// Raw
println(raw"hello /nworld")

// 1

// Define the names
val name1 = "Muhammad"
val name2 = "Bilal"

println(s"$name2 is older than $name1")

// 2
// Define the names
val name1 = "Muhammad"
val name2 = "Bilal"

// Define the ages
val ageMuhammad = 22
val ageBilal = 26

// Calculate the age difference
val ageDifference = ageBilal - ageMuhammad

// Use string interpolation to print the statement
println(s"$name2 is $ageDifference years older than $name1")

//3
// Define the names
val name1 = "Muhammad"
val name2 = "Bilal"

// Define the ages as doubles
val ageMuhammad: Double = 22.50
val ageBilal: Double = 26.84

// Calculate the age difference
val ageDifference: Double = ageBilal - ageMuhammad

// Use string interpolation to print the statement
println(s"$name2 is $ageDifference years older than $name1")

// 4
println(raw"/n/n/n/n/n/n/nsameline/n/n")


val name = "Muhammad"
val height: Double = 1.6

println(s"$name is $height meters tall")




