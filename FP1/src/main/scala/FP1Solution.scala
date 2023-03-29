import scala.annotation.tailrec

class FP1Solution extends FP1ExercisesProblems {

  override def recursiveAddition(a: Int, b: Int): Int =
    if (b == 0) a
    else inc(recursiveAddition(a,dec(b)))
  
  override def fib(n: Int): Int = n match {
    case 0 => 0
    case 1 => 1
    case _ => fib(n-1) + fib(n-2)
  }

  override def fibTail(a: Int): Int = {
    @tailrec
    def inner(n: Int, n1: Int, n2: Int): Int = if (n == a) n1 + n2 else inner(n + 1, n1 + n2, n1)
    a match {
      case 0 => 0
      case 1 => 1
      case _ => inner(2, 1, 0)
    }
  }

  override def integerMap(a: Int, f: Int => Int): Boolean =
    a == f(a)
  
  override def premultiply(a: Int): Int => Int = {
    def f(b: Int): Int = a * b
    f
  }

  override def premultiply2(a: Int)(b: Int): Int = a * b

  override def abs(a: Double): Double = if (a < 0) -a else a


  override def max(a: Int, b: Int, c: Int): Int =
  // very simple solution to practice if expressions
    if(a > b && a > c) a else
    if(b > a && b > c) b else c


  override def isPrime(n: Int): Boolean = {
    // simple trial division to practice recursion
    def isPrimeHelper(n : Int, divisor : Int):Boolean = {
      if (n % divisor == 0) false
      else if (divisor * divisor > n) true
      else isPrimeHelper(n, divisor + 1)
    }
    isPrimeHelper(n, 2)
  }


  override def sqrt(x: Double): Double = {
    def sqrtHelper(xi : Double, x : Double) : Double = {
      val xiPlus1 = 0.5 * (xi + x / xi)
      if (abs(xiPlus1 - xi) < epsilon)
        xiPlus1
      else sqrtHelper(xiPlus1,x)
    }
    sqrtHelper(x,x)
  }

  /**
   * Implement the maximum of two numbers without relational operators like >,
   * but only through pattern matching and the methods {@code inc} and
   * {@code dec}. You can assume the method arguments to be natural numbers
   * including zero.
   * Note that:
   * x >= y <=> x - 1 >= y - 1 and
   * x >= 0 always holds for natural numbers
   *
   * @param x a natural number
   * @param y a natural number
   * @return the maximum of the inputs
   */
  override def maxRecursive(x: Int, y: Int): Int = (x,y) match {
    case (x, 0) => x
    case (0, y) => y
    case (x,y) => inc(maxRecursive(dec(x),dec(y)))
  }

  override def numberOfPrimes(from: Int, to: Int): Int = {
    if (from > to) 0
    else if (isPrime(from)) 1 + numberOfPrimes(from + 1, to)
    else numberOfPrimes(from + 1, to)
  }


  override def waysToWalkStairs(numSteps: Int): Int = {
    numSteps match {
      case 0 => 0
      case 1 => 1
      case 2 => 2
      case n => waysToWalkStairs(n-1) + waysToWalkStairs(n - 2)
    }
  }

  override def reverse(n: Int): Int = {
    def powerOfTen(n: Int): Int = if (n < 10) 1 else 10 * powerOfTen(n / 10)

    if (n < 10) n
    else reverse(n / 10) + (n % 10) * powerOfTen(n)
  }
  override def digitSum(x: Int): Int =
    if(x < 10) x else x % 10 + digitSum(x / 10)


  override def reverseString(s: String): String = {
    if (s.length <= 1) s
    else reverseString(s.tail) + s.head
  }
}
