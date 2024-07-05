// Task 1
val numbersList: List[Int] = List(1, 2, 3, 4, 5)
val primaryColoursSeq: Seq[String] = Seq("Red", "Blue", "Yellow")

// Task 1a
val multipliedList: List[Int] = numbersList.map(_ * 3)
println(s"Multiplied List: $multipliedList")

// Task 1b
val coloursWithoutBlue: Seq[String] = primaryColoursSeq.filter(_ != "Blue")
println(s"Colours without Blue: $coloursWithoutBlue")

// Task 1c
val colorsWithoutBlue: Seq[String] = primaryColoursSeq.filter(_ != "Blue")
println(s"Colors without Blue: $colorsWithoutBlue")

// Task 1d
val containsOrange: Boolean = primaryColoursSeq.contains("Orange")
println(s"Does Seq contain Orange? $containsOrange")

// Task 2
val oddEvenList: List[Boolean] = numbersList.map(num => num % 2 != 0)
println(s"Odd/Even List: $oddEvenList")

// Task 3

val davidsPets: Map[String, String] = Map(
  "dog1" -> "Dave",
  "cat1" -> "Fluffy",
  "parrot1" -> "Percy"
)

// Task 4
val davidsDogNames: List[String] = davidsPets.collect {
  case (name, "Dave") => name
}.toList
println(s"David's Dog Name: $davidsDogNames")


// Extension 1

val seq1to9: Seq[Int] = Seq(1, 2, 3, 4, 5, 6, 7, 8, 9)

// Filter 1: Keep elements less than or equal to 2
val filtered1: Seq[Int] = seq1to9.filter(_ <= 2)

// Filter 2: Keep elements that are 5 or 7
val filtered2: Seq[Int] = seq1to9.filter(num => num == 5 || num == 7)


val resultSeq: Seq[Int] = filtered1.intersect(filtered2)

println(s"Filtered Sequence: $resultSeq")


// Extension 2
val numbersList: List[Int] = List(1, 2, 3, 4, 5)

val thirdElement: Int = numbersList.tail.head

println(s"Third Element: $thirdElement")







