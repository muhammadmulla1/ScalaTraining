/** Functions and Methods */

// Functions
//assigned to a val
//also methods
//no different to any other type
//don't have to name them (however if we don't, they aren't reusable)

//Methods
//keyword 'def'
//belong to class
// Can be overridden
// must be named

//Anonymous function
(number: Int) => number + 1

//Named function
val addition = (number: Int) => number + 1

//Method (also a function)
def addition (number: Int): Int = number + 1

//Override method
def addition (number: Int): Int = number + 10

//Example method
def makeACupOfTea(numOfSugars:Int): String = {
  s"You have made a tea with $numOfSugars spoons of sugar. Enjoy."
}
// calling the method
makeACupOfTea(8)

//VAT method
val vat: Double = 1.4
def priceWithVAT(price:Double): Double = {
  price * vat
}
priceWithVAT(5.0)

//TASK 1 AND 2 ON PPT
//1. Unit is printed – unit isn’t helpful. Avoid it.
//2. 42, last expression is what is expressed, if else if irrelevant.
val aValue = 2<3
def aDifferentValue: Int = {
  if (aValue) {
    564
  } else {
    865
  }
  42
}
aDifferentValue

//Methods within a class
class Number(num:Int){
  def addition(aDifferentNum: Int): Int = {
    num + aDifferentNum
  }
}
val newNumberClass = new Number(10)
val classAddition = newNumberClass.addition(7)

//TASK1
def getBigVal (input1: Int, input2: Int): String = {
  if (input1 > input2){
    "first"
  } else if (input1 < input2) {
    "second"
  } else if (input1 == input2) {
    "same"
  } else {
    "something has gone wrong here..."
  }
}
getBigVal(6,4)
getBigVal(2,4)
getBigVal(4,4)

//TASK2
def nameLength(firstName: String, surname: String): Int = {
  if(firstName.length > surname.length){
    firstName.length
  } else if (firstName.length < surname.length){
    surname.length
  } else {
    0
  }
}
nameLength("Tom", "Hiddleston")
nameLength("Elizabeth", "Olsen")
nameLength("Chris", "Pratt")

//Should have else as the error case here - 404 possibly.

/** Referential transparency */
//to be aware of
// a function's return value is based solely on the inputs
//For example, given an addition method that has inputs 1 and 1, the addition function will always return a result of 2.
//This means every reference to addition(1, 1) can be replaced with 2 and the application would continue to function as it did prior to the result replacement.

/** PURE */
val sentence: String = ""
def append(sentence:String, word:String): String = {
  sentence + "" + word.trim
}
val a = append(sentence, "Allo") // "Allo"
val b = append(sentence, "Allo") // "Allo"

/** IMPURE */
var sentence: String = ""
def append(word:String): String = {
  sentence = sentence + " " + word
  sentence.trim
}
val a = append("Allo") // "Allo"
val b = append("Allo") // "Allo Allo"

//AIM FOR PURE