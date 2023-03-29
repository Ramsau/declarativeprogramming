import org.scalactic.TolerantNumerics
import org.scalatest.funsuite.AnyFunSuite

class FP1Test extends AnyFunSuite {
  val testObject : FP1ExercisesProblems = new FP1Exercise()

  test("recursiveAddition(5,4) should evaluate to 9") {
    assert(testObject.recursiveAddition(5, 4) == 9)
  }
  test("recursiveAddition(5,0) should evaluate to 5") {
    assert(testObject.recursiveAddition(5, 0) == 5)
  }

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

  // this lets us check equality of double with some tolerance to avoid
  // floating point issues
  val doubleEquality = TolerantNumerics.tolerantDoubleEquality(1e-6)

  test("Sqrt of 2"){
    val sqrt2 = testObject.sqrt(2)
    assert(doubleEquality.areEqual(sqrt2 * sqrt2, 2.0))
  }

  // "Advanced Scala": implicit values let of use default functionality for
  // double comparison when using ===, which depends on context.
  implicit val implicitDoubleEq = doubleEquality
  test("Sqrt of 3") {
    val sqrt3 = testObject.sqrt(3)
    assert(sqrt3 * sqrt3 === 3.0)
  }
  test("Sqrt of 100") {
    val sqrt = testObject.sqrt(100)
    assert(sqrt === 10.0)
  }

  test("Max recursive x > y") {
    assert(testObject.maxRecursive(10, 5) == 10)
  }
  test("Max recursive x < y") {
    assert(testObject.maxRecursive(10, 15) == 15)
  }
  test("Max recursive x = 0") {
    assert(testObject.maxRecursive(0, 15) == 15)
  }

  test("Max recursive y = 0") {
    assert(testObject.maxRecursive(10, 0) == 10)
  }

  test("Max recursive both zero") {
    assert(testObject.maxRecursive(0, 0) == 0)
  }

  test("premultiply(2)(5) should evaluate to 10") {
    assert(testObject.premultiply(2)(5) == 10)
  }
  test("premultiply(0)(5) should evaluate to 0") {
    assert(testObject.premultiply(0)(5) == 0)
  }
  test("premultiply2(2)(5) should evaluate to 10") {
    assert(testObject.premultiply2(2)(5) == 10)
  }
  test("premultiply2(0)(5) should evaluate to 0") {
    assert(testObject.premultiply2(0)(5) == 0)
  }

  test("Digit sum some number") {
    assert(testObject.digitSum(321) == 6)
  }
  test("Digit sum some 0") {
    assert(testObject.digitSum(0) == 0)
  }

  test("number of primes, last is not prime") {
    assert(testObject.numberOfPrimes(5, 9) == 2)
  }
  test("number of primes, last is prime") {
    assert(testObject.numberOfPrimes(5, 11) == 3)
  }
  test("reverse 999") {
    assert(testObject.reverse(999) == 999)
  }
  test("reverse 123") {
    assert(testObject.reverse(123) == 321)
  }
  test ("reverse 12345") {
    assert(testObject.reverse(12345) == 54321)
  }
  test("reverse 1") {
    assert(testObject.reverse(1) == 1)
  }
  test("walking 3 stairs") {
    assert(testObject.waysToWalkStairs(3) == 3)
  }
  test("walking 4 stairs") {
    assert(testObject.waysToWalkStairs(4) == 5)
  }
  test("walking 5 stairs") {
    assert(testObject.waysToWalkStairs(5) == 8)
  }
  test("reverseString") {
    assert(testObject.reverseString("Hello World").equals("Hello World".reverse))
  }
}
