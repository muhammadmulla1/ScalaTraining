package Week2.Wednesday

import org.scalatest.FlatSpec

class TwoNumbersSpec extends FlatSpec {

  "add" should "add numbers" in {
    val nums = new TwoNumbers(1,2) // new instance of the class
    assert(nums.add == 3)
  }

  "subtract" should "subtract numbers" in {
    val nums = new TwoNumbers(1,2) // new instance of the class
    assert(nums.subtract() == -1)
  }

  "multiply" should "multiple y and x" in {
    val nums = new TwoNumbers(1,2)
    assert((nums.multiply() == 2))
  }

  "divide" should "divide y and x" in {
    val nums = new TwoNumbers(1, 2)
    assert((nums.divide() == 0.5))
  }

    "isAMultiple" should "check if y is a multiple of x" in {
      val nums1 = new TwoNumbers(1, 2)
      assert(nums1.isAMultiple() == true)

      val nums2 = new TwoNumbers(2, 5)
      assert(nums2.isAMultiple() == false)
    }
}
