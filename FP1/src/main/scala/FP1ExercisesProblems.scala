trait FP1ExercisesProblems {


  val epsilon: Double = 1e-6

  def inc(n: Int): Int = n + 1

  def dec(n: Int): Int = n - 1

  /**
   * Compute the absolute value |a| of the number |a|.
   *
   * Berechnen Sie den Absolutwert |a| der Zahl a.
   *
   * @param a a number
   * @return absolute value of input
   */
  def abs(a : Double) : Double =
    if (a > 0) a else -a

  /**
   * Compute the maximum value of three numbers a,b, and c.
   *
   * Berechnen Sie den größten Wert von drei Zahlen a,b und c.
   * @param a an integer
   * @param b an integer
   * @param c an integer
   * @return maximum of the three inputs
   */
  def max(a : Int, b : Int, c : Int) : Int =
    if (a >= b && a >= c) a else
    if (b >= a && b >= c) b else c

  /**
   * Write a recursive implementation of addition that only subtracts or adds
   * 1 via the methods inc and dec.
   * That is, use the inductive definition of addition:
   * a + 0 = a
   * a + b = (a + (b-1)) + 1 = inc(a,dec(b))
   * For example (2 + 2) should be evaluated as (2 + 1) + 1 = ((2 + 0) + 1) + 1
   * Assume that the function is only called with natural numbers including
   * zero.
   *
   * Implementieren Sie die addition zweier natuerlicher Zahlen
   * via Rekursion auf Basis der oben gegebenen induktiven Definition der
   * Addition mit Hilfe der Methoden inc und dec.
   * Nehmen Sie an, dass die Funktionargumente natuerliche Zahlen inklusive Null
   * sind.
   *
   * @param a natural number
   * @param b natural number
   * @return a + b
   */
  def recursiveAddition(a : Int, b : Int) : Int

  /**
   * Write a function that checks whether the given input is prime number.
   * Hint: Use simple trial division and a recursive helper function.
   * {@code isPrime(n : Int, divisor : Int) : Boolean}
   *
   * Implementieren Sie eine Funktion, die überprüft ob ihr Argument eine
   * Primzahl ist. Tipp: Verwenden Sie einfach Probedivision, die Sie in einer
   * rekursiven Hilfs-Funktion {@code isPrime(n : Int, divisor : Int) : Boolean}
   * implementieren.
   *
   * @param n a natural number not including zero
   * @return true if n is prime
   */
  def isPrime(n : Int) : Boolean

  /**
   * Implement a recursive function that computes the digit sum of its input
   * argument. Assume that the input is a natural number including 0.
   *
   * Implementieren Sie eine rekursive Funktion, die die Ziffernsumme des
   * Parameters x berechnet. Nehmen Sie an, dass die Eingabe eine natürliche
   * Zahlen inklusive null ist.
   *
   * @param x a number number
   * @return digit sum of input
   */
  def digitSum(x: Int): Int

  /**
   * Implement a recursive that counts the number of to walk up stairs with
   * {@code numSteps} steps, when you take either one step or two steps at once.
   * For example, there are 5 way to walk 4 steps, because
   * * You may take 2 steps then another 2 steps
   * * 2 then 1 then 1
   * * 1 then 2 then 1
   * * 1 then 1 then 2
   * * 1 then 1 then 1 then 1
   *
   * Implementieren Sie eine rekursive Funktion, die berechnet auf wie viele
   * Arten man Treppen hinaufgehen kann, wenn man entweder zwei Stufen oder
   * eine Stufe auf einmal nimmt.
   * Zum Beispiel gibt es 5 Arten 4 Stufen zu gehen, weil
   * * Man geht 2 dann nochmal 2
   * * 2 dann 1 dann 1
   * * 1 dann 2 dann 1
   * * 1 dann 1 dann 2
   * * 1 dann 1 dann 1 dann 1
   *
   * @param n a number >= 0
   * @return number of ways to take stairs
   */
  def waysToWalkStairs(numSteps : Int) : Int

  /**
   * Write a recursive a function that reverse a natural number given as input.
   * For example: reverse(123) shall evaluate to 321
   *
   * Hint: try to come up with an inductive definition and think about how to
   * "shift" numbers mathematically.
   *
   * Implementieren Sie eine rekursive Function die eine natürliche Zahl
   * umdreht.
   * Zum Beispiel: reverse(123) soll zu 321 evaluieren
   *
   * Tipp: Versuchen Sie eine induktive Definition zu entwickeln und überlegen
   * Sie wie man Ziffern durch mathematische Operationen "verschiebt".
   *
   * @param n a natural number
   * @return reverse of the input
   */
  def reverse(n : Int) : Int

  /**
   * Compute the square of x using Newton's method (also Babylonian method),
   * where you iteratively calculate approximations of the root using:
   * x{i} = 1/2 (x{i-1} + x/x{i}).
   * Stop the iteration when computation converges by checking
   * |x{i} - x{i-1}| < epsilon.
   *
   * The initial value x{0} shall be set to the input x.
   *
   * Hint: you can use a helper function and define local values.
   *
   * Berechnen Sie Quadratwurzel von x über das Newtonverfahren. In diesem
   * Verfahren werden iterativ Approximationen der Quadratwurzel berechnet
   * über die Berechnungsvorschrift:
   * x{i} = 1/2 (x{i-1} + x/x{i})
   * Beenden Sie die Iteration, when die Berechnung konvergiert in dem
   * überprüfen ob |x{i} - x{i-1}| < epsilon.
   *
   * Der Initialwert x{0} soll auf den Wert der Eingabe x gesetzt werden.
   *
   * See also: https://en.wikipedia.org/wiki/Newton%27s_method
   *
   * @param x a number
   * @return square root of x
   */
  def sqrt(x : Double) : Double

  /**
   * Implement a recursive computation of the fibonacci number @param a. Use the
   * definition fib(0)=0, fib(1)=1, fib(n)=fib(n-1)+fib(n-2).
   * 
   * Schreiben Sie eine rekursive Berechnung der Fibonacci Zahl @param a. Nutzen Sie
   * die gegebene Definition.
   * 
   * @see https://en.wikipedia.org/wiki/Fibonacci_number
   * @see https://de.wikipedia.org/wiki/Fibonacci-Folge
   *
   * @param a number
   * @return fib(a)
   */
  def fib(a : Int) : Int
  def fibTail(a : Int) : Int

  /**
   * Implement the maximum of two numbers without relational operators like >,
   * but only through pattern matching and the methods {@code inc} and
   * {@code dec}. You can assume the method arguments to be natural numbers
   * including zero.
   * Note that:
   * x >= y <=> x - 1 >= y - 1 and
   * x >= 0 always holds for natural numbers
   * You can pattern match pairs and tuples in Scala like: (x,y) match {
   * case(1, 5) => println("x is equal to 1 and y is equal to 5"
   * ...}
   *
   * Implementieren Sie eine Funktion, die das Maximum zweier Zahlen, ohne
   * Vergleichoperatoren wie > zu verwenden. Stattdessen sollen Sie nur pattern
   * matching und die Methoden {@code inc} und {@code dec} verwenden.
   * Beachten Sie, dass
   * x >= y <=> x - 1 >= y - 1 und
   * x >= 0 von allen natürlichen Zahlen erfüllt wird.
   * Pairs können über patterns der folgenden Form in Scala gematcht werden:
   * (x,y) match {
   * case(1, 5) => println("x is equal to 1 and y is equal to 5"
   * ...}
   *
   * @param x a natural number
   * @param y a natural number
   * @return the maximum of the inputs
   */
  def maxRecursive(x : Int, y: Int) : Int

  /**
   * Implement a recursive function that computes the number of primes between
   * {@code from} and {@to} (including these limits).
   *
   * Implementieren Sie eine rekursive Funktion, die die Anzahl an Primzahlen
   * im geschlossenen Interval zwischen {@code from} und {@to} berechnet.
   *
   * @param from lower limit from for computation (inclusive)
   * @param to upper limit from for computation (inclusive)
   * @return number of primes in range
   */
  def numberOfPrimes(from : Int, to : Int) : Int



  /**
   * Write a function that takes an integer and applies a given function to that
   * integer. Return true if @param f leaves the number unchanged.
   * For example, given f : a => a, this should always return true, as the function
   * always returns the parameter.
   * 
   * Schreiben Sie eine Function, welche eine Zahl annimmt und darauf eine gegebene
   * Funktion anwendet. Geben Sie true zurück, wenn @param f die Zahl nicht verändert.
   * Beispielsweise soll für f : a => a immer true zurück gegeben werden, da f immer
   * den Parameter zurückgibt.
   *
   * @param a number
   * @param f number mapping
   * @return a == f(a)
   */
  def integerMap(a : Int, f: Int => Int) : Boolean

  /**
   * Implement a function that takes an integer @param a and returns a function
   * that takes an integer @param b and returns the multiplication a * b.
   * Example:
    <pre>{@code
      val timesTwo = premultiply(2)
      println(timesTwo(5)) // prints 10
      println(timesTwo(2)) // prints 4
    }</pre>
   * 
   * Implementieren Sie eine Funktion, welche eine Zahl @param a nimmt und eine
   * Funktion zurückgibt, welche wiederum eine Zahl @param b nimmt und a * b zurückgibt.
   *
   * @param a number
   * @return f(b) => a * b
   */
  def premultiply(a : Int) : Int => Int
  def premultiply2(a : Int)(b: Int) : Int

  /**
   * Implement a function that takes a String and reverse it.
   * Do not use the standard reverse function, instead have a look at head and tail.
   *
   * Schreiben Sie eine Function, welche einen String annimmt und diesen invertiert.
   * Verwenden Sie nicht die standard funktion "reverse". Arbeiten Sie stattdessen mit "head" und "tail".
   *
   * @param s String
   * @return s in reverse char order
   */
  def reverseString(s: String): String
}
