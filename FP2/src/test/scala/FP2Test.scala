import org.scalactic.TolerantNumerics
import org.scalatest.funsuite.AnyFunSuite

class FP2Test extends AnyFunSuite {
  val testObject : FP2ExercisesProblems = new FP2Solution()


  test("fib(1) should evaluate to 1") {
    assert(testObject.fib(1) == 1)
  }
  test("fib(5) should evaluate to 5") {
    assert(testObject.fib(5) == 5)
  }
  test("fib(7) should evaluate to 13") {
    assert(testObject.fib(7) == 13)
  }
  test("fibTail(1) should evaluate to 1") {
    assert(testObject.fibTail(1) == 1)
  }
  test("fibTail(5) should evaluate to 5") {
    assert(testObject.fibTail(5) == 5)
  }
  test("fibTail(7) should evaluate to 13") {
    assert(testObject.fibTail(7) == 13)
  }

  test("integerMap returns true with identity") {
    assert(testObject.integerMap(5, a => a) == true)
    assert(testObject.integerMap(0, a => a) == true)
    assert(testObject.integerMap(-1, a => a) == true)
  }
  test("integerMap complex fn") {
    def f(a: Int): Int = if (a >= 10) a else Int.MinValue
    assert(testObject.integerMap(5, f) == false)
    assert(testObject.integerMap(-1, f) == false)
    assert(testObject.integerMap(10, f) == true)
    assert(testObject.integerMap(50, f) == true)
  }

  test(" flatten 1") {
    val input = List(List(1,2), Nil, List(3,4,5), List(6))
    val expected = List(1,2,3,4,5,6)
    assert(testObject.flatten(input) == expected)
    assert(testObject.flattenTail(input) == expected)
  }

  test("isAscending") {
    assert(testObject.isAscending(List(1,3,5,6)) == true)
  }
  test("isAscending: in between a lower number") {
    assert(testObject.isAscending(List(1,7,5,8)) == false)
  }
  test("isAscending: in the end a lower number") {
    assert(testObject.isAscending(List(1,3,5,4)) == false)
  }
  test("dotProduct((0,0,0),(2,2,5)) should be 0") {
    assert(testObject.dotProduct(List(0,0,0), List(2,2,5)) == 0)
  }
  test("dotProduct((1,2,3),(2,2,5)) should be 21") {
    assert(testObject.dotProduct(List(1,2,3), List(2,2,5)) == 21)
  }
  test("dotProduct empty") {
    assert(testObject.dotProduct(List(), List()) == 0)
  }
  test("dotProduct vectors unequal length") {
    assert(testObject.dotProduct(List(1,2), List(2,2,5)) == 0)
  }
  test("bitwiseAnd 1 & 0") {
    assert(testObject.bitwiseAnd(List(1), List(0)) == List(0))
  }
  test("bitwiseAnd 1 & 1") {
    assert(testObject.bitwiseAnd(List(1), List(1)) == List(1))
  }
  test("bitwiseAnd 101 & 1100") {
    assert(testObject.bitwiseAnd(List(0,1,0,1), List(1,1,0,0)) == List(0,1,0,0))
  }
  test("bitwiseRightShift l>>0") {
    assert(testObject.bitwiseRightShift(List(0,1,0,1), 0) == List(0,1,0,1))
  }
  test("bitwiseRightShift l>>1") {
    assert(testObject.bitwiseRightShift(List(0,1,0,1), 1) == List(0,0,1,0))
  }
  test("bitwiseRightShift l>>2") {
    assert(testObject.bitwiseRightShift(List(0,1,0,1), 2) == List(0,0,0,1))
  }
  test("bitwiseRightShift l>>999") {
    assert(testObject.bitwiseRightShift(List(0,1,0,1), 999) == List(0,0,0,0))
  }

  test("keep only positive"){
    val input = List(1,2,3)
    val expected = List(1,2,3)
    assert(testObject.keepPositive(input) == expected)
    assert(testObject.keepPositiveFold(input) == expected)
  }

  test("keep only positive with only negative") {
    val input = List(-1, -2, -3)
    val expected = List()
    assert(testObject.keepPositive(input) == expected)
    assert(testObject.keepPositiveFold(input) == expected)
  }

  test("keep only positive with mixed") {
    val input = List(-1, 2, -3, 4)
    val expected = List(2,4)
    assert(testObject.keepPositive(input) == expected)
    assert(testObject.keepPositiveFold(input) == expected)
  }

  test("abs list only positive") {
    val input = List(1, 2, 3)
    val expected = List(1, 2, 3)
    assert(testObject.absList(input) == expected)
    assert(testObject.absListFold(input) == expected)
  }

  test("abs list with only negative") {
    val input = List(-1, -2, -3)
    val expected = List(1,2,3)
    assert(testObject.absList(input) == expected)
    assert(testObject.absListFold(input) == expected)
  }

  test("abs list positive with mixed") {
    val input = List(-1, 2, -3, 4)
    val expected = List(1,2,3, 4)
    assert(testObject.absList(input) == expected)
    assert(testObject.absListFold(input) == expected)
  }

  test("abs list empty"){
    assert(testObject.absList(Nil) == Nil)
    assert(testObject.absListFold(Nil) == Nil)
  }

  // this lets us check equality of double with some tolerance to avoid
  // floating point issues
  implicit val doubleEquality = TolerantNumerics.tolerantDoubleEquality(1e-6)
  test("mse one number") {
    assert(testObject.mse(List(1.0), List(2.0)) === 1.0)
  }
  test("mse one number - different sign") {
    assert(testObject.mse(List(1.0), List(-1.0)) === 4.0)
  }

  test ("mse one number same") {
    assert(testObject.mse(List(1.0), List(1.0)) === 0.0)
  }

  test("mse nominal"){
    assert(testObject.mse(List(0.5,2.0,-1.5), List(1.5,2.0,1.5)) === 3.3333333)
  }

  test("CheckEvenEven: 1"){
    assert(testObject.checkEvenEven(List()) == true)
  }
  test("CheckEvenEven: 2"){
    assert(testObject.checkEvenEven(List(1,2)) == true)
  }
  test("CheckEvenEven: 3"){
    assert(testObject.checkEvenEven(List(1,4)) == true)
  }
  test("CheckEvenEven: 4"){
    assert(testObject.checkEvenEven(List(1,2,1,4)) == true)
  }
  test("CheckEvenEven: 5"){
    assert(testObject.checkEvenEven(List(1)) == false)
  }
  test("CheckEvenEven: 6"){
    assert(testObject.checkEvenEven(List(1,1)) == false)
  }
  test("CheckEvenEven: 7"){
    assert(testObject.checkEvenEven(List(1,3)) == false)
  }
  test("CheckEvenEven: 8"){
    assert(testObject.checkEvenEven(List(1,6,6)) == false)
  }
  test("CheckEvenEven: 9"){
    assert(testObject.checkEvenEven(List(1,6,6,7)) == false)
  }

  test("CountChange: 1") {
    assert(testObject.countChange(2, List(1,2)) == 2)
  }
  test("CountChange: 2") {
    assert(testObject.countChange(5, List(1,2,5)) == 4)
  }
  test("CountChange: 3") {
    assert(testObject.countChange(20, List(1,2,5,10,20)) == 41)
  }

  test("MaxInPairs1") {
    assert(testObject.maxInPairs(List((3,1),(2,4),(1,2))) == List(3,4,2))
  }
  test("MaxInPairsTail") {
    assert(testObject.maxInPairsTail(List((3,1),(2,4),(1,2))) == List(3,4,2))
  }

  test("takeWhile") {
    assert(testObject.takeWhile(List(1,2,3,4,5), (x) => x <= 3) == List(1,2,3))
  }

  test("hasRoot: 1") {
    assert(testObject.hasRoot(0, 0, (x) => x) == true)
  }
  test("hasRoot: 2") {
    assert(testObject.hasRoot(0, 10, (x) => x - 10) == true)
  }
  test("hasRoot: 3") {
    assert(testObject.hasRoot(0, 10, (x) => {if(x >= 5) 0 else 1})  == true)
  }
  test("hasRoot: 4") {
    assert(testObject.hasRoot(0, 10, (x) => {if(x > 10) 0 else 1})  == false)
  }

  test("fill") {
    assert(testObject.fill(0, 5, (x) => x * x) == List(0, 1, 4, 9, 16, 25))
  }
}
