//Sequences - seq
val seq1: Seq[Int] = Seq(1, 2, 3)

//Lists - list
val list1: List[Int] = List(1, 2, 3)

//Maps - map
// Key Value pairs : key -> value
val map1: Map[String, Int] = Map(
  "one" -> 1,
  "two" -> 2,
  "three" -> 3
)

//Calling an index position using Sequence
val getSeqData: Int = seq1(0)

//.head gives you the first position
val getSeqHead: Int = seq1.head

//.tail gives you everything but the head (first value index = 0)
val getSeqTail = seq1.tail

//Calling an index position using List
val getListData: Int = list1(1)
val getListTail: Int = list1.head
val getListTail: List[Int] = list1.tail

//Calling an index position using Maps
val getMapData = map1("one")

//Sequence tripled
val tripledSequence: Seq[Int] = seq1.map{
  number => number * 3
}

//List tripled
val tripledList: List[Int] = list1.map{
  number => number * 3
}


// Map tripled
val map1: Map[String, Int] = Map("one" -> 1, "two" -> 2, "three" -> 3)

// Triple the values in the map
val tripledMap: Map[String, Int] = map1.view.mapValues(_ * 3).toMap

val tripledMap: Map[String, Int] = map1.map {
  case (key, value) => (key, value *3)
}

//Changing key
val map1: Map[String, Int] = Map("one" -> 1, "two" -> 2, "three" -> 3)

val changedKeysMap: Map[String, Int] = map1.map {
  case (key, value) => (key + "_key", value)
}

//Changing key and value
val map1: Map[String, Int] = Map("one" -> 1, "two" -> 2, "three" -> 3)

val changedKeysAndValuesMap: Map[String, Int] = map1.map {
  case (key, value) => ("new_" + key, value * 2)
}

//Filtering a Sequence
val filteredSeq: Seq[Int] = seq1.filter{
  number => number > 1
}

//Filtering a List
val filteredList: List [Int] = list1.filter(
  number => number >1
)

filteredSeq == filteredList

//Filtering a Map - [String, Int] is a tuple
val filteredMap: Map[String, Int] = {
  map1.filter(number => number._2 > 1)
}

// Filter not
val filternot: List[Int] =
  list1.filterNot(number => number >= 2)

// Exists
// Boolean

val listExists: Boolean = list1.exists{
  number => number > 9
}

val seqExists: Boolean = seq1.exists{
  number => number > 2
}

val mapExists: Boolean = map1.exists{
  number => number._2 > 2
}

// Contains
// Check for one parameter
val containsSeq: Boolean = seq1.contains(2)
val containsSeq: Boolean = seq1.contains(5)

// List contains
val containsList: Boolean = list1.contains(3)

// Map contains
val containsMap: Boolean = map1.contains("two")

// Task 1
//Sequences - seq
// 1
val seq1: Seq[String] = Seq("April", "Muhammad", "Bilal", "Tom", "Tay", "Spencer", "Arie", "Roshan", "Antony", "Joe", "Jamie")

//Maps - map
// Key Value pairs : key -> value
// 2
val map2: Map[String, Int] = Map(
  "red" -> 1,
  "yellow" -> 2,
  "blue" -> 3,
  "green" -> 4
)

//Calling an index position using Maps
val getMapData = map2("blue")

// 3, 4, 5

//Sequences - seq
val seq1: Seq[Int] = Seq(1, 2, 3, 4, 5, 6)

//Sequence + 1
val addone: Seq[Int] = seq1.map{
    number => number + 1
  }

val filteredSeq: Seq[Int] = addone.filter(_ % 2 != 0)

val seq3: Seq[String] = Seq("cherry","banana", "apple", "pears")

val containsSeq: Boolean = seq3.exists(_.contains('r'))

// Arrays
val array1: Array[Int] = Array(1, 2, 3)
val plusTwo: Array[Int] = array1.map{
  _ + 2
}

val x = Seq[Int]()
  x :+ 1
  x :+ 2
  println(x)

val x = Seq[Int]()
val x1 = x :+ 1
val x2 = x1 :+ 2
println(x2)

val y = Seq(3,4,5)

val y = Seq(3, 4, 5)
val yAppended = y :+ 6








