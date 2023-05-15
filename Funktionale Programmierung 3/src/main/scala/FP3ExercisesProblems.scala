import scala.annotation.tailrec
import scala.collection.immutable.::

trait FP3ExercisesProblems {

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
  def premultiply2(a : Int)(b : Int) : Int

  /**
    * Compute the weighted sum of a given list of integers in a recursive function.
    * @param func is a user-defined function to apply weights to each element; do not use map.
    * 
    * In a separate function, use any fold function (but still do not use map).
    * The third function is curried, and may use either mechanism.
    * 
    * Berechnen Sie die gewichtete Summe einer Liste an Zahlen in einer rekursiven Function. 
    * @param func ist die Funktion, die auf jedes Element angewendet werden soll; verwenden Sie
    * map nicht.
    * 
    * In einer separaten Funktion, nutzen Sie eine beliebige fold Funktion (aber kein map).
    * Die dritte Funktion soll curried sein.
    * 
    * @param l list of numbers
    * @param func mapping function
    * @return Σf(x) for x ∈ l
    */
    def weightedSum(l : List[Int], func : Int => Int) : Int
    def weightedSumFold(l : List[Int], func : Int => Int) : Int
    def weightedSum2(func : Int => Int)(l : List[Int]) : Int

  /**
   * Implement a function that checks if a list contains exactly n elements
   * satisfying a given predicate. Use one of fold functions of the List class.
   *
   * Implementieren Sie eine Funktion die überprüft, ob eine Liste exakt n
   * Elemente beinhaltet, die ein gegebenenes Prädikate erfüllen. Verwenden
   * Sie eine der fold functions über Listen.
   * @param n number of elements
   * @param l a list
   * @param pred predicate to be checked on list element
   * @tparam T
   * @return true if list contains n elements satisfying pred
   */
  def hasNTimes[T](n : Int, l : List[T], pred : T => Boolean) : Boolean

  /**
   * Example to practice recursion with a helper function.
   *
   * Implement a function that checks if an integer i is a perfect square, i.e.,
   * check if there is an x such that x * x == i.
   *
   * Implementieren Sie eine Funktion die überprüft ob ein integer i
   * eine Quadratzahl ist, also es ein x gibt, sodass x * x == i.
   *
   * @param n some integer
   * @return true if n is a perfect square
   */
  def isPerfectSquare(n : Int) : Boolean

  /**
   * Use one of the fold function to turn a given list into a palindrom, i.e.,
   * a list that is equal to its reversed version.
   * E.g., makePalindrom(List(1,2)) == List(2,1,1,2)
   *
   * Verwenden Sie eine der fold-Funktionen, um die Eingabeliste in ein
   * Palindrom umzuwandeln, also Liste die gleich bleibt, wenn man sie umdreht.
   * Beispiel:  makePalindrom(List(1,2)) == List(2,1,1,2)
   *
   *
   * @param l an input list
   * @tparam T
   * @return palindrom created from input list
   */
  def makePalindrom[T](l : List[T]) : List[T]

  /**
   * Implement a function that removes all elements from a lists that are equal
   * to another given value. Use the List.filter function for this purpose.
   *
   * Implementieren Sie eine Funktion, die alle Elements einer Liste einer Liste
   * entfernt, die gleich einem angegebenen Wert sind.
   * Verwenden Sie dafür List.filter.
   *
   * @param l a list of any type
   * @param elem element that should be removed
   * @tparam T
   * @return list without occurences of elem
   */
  def remove[T](l : List[T], elem : T) : List[T]

  /**
   * Implement a function that removes all elements from a lists that are equal
   * to another given value. Use one of fold functions for this purpose.
   *
   * Implementieren Sie eine Funktion, die alle Elements einer Liste einer Liste
   * entfernt, die gleich einem angegebenen Wert sind.
   * Verwenden Sie dafür eine der fold-Funktionen.
   *
   * @param l    a list of any type
   * @param elem element that should be removed
   * @tparam T
   * @return list without occurences of elem
   */
  def removeFold[T](l : List[T], elem : T): List[T]

  /**
    * Implement a function that interleaves the elements from two given lists
    * into a new list, e.g. interleave([1,3], [2,4]) == [1,2,3,4], i.e. take
    * one element from the left, one from the right, repeat.
    * You can assume that both lists have the same length.
    * Implement it as regular recursion and as tail recursion.
    *
    * Implementieren Sie eine Funktion, die die Elemente zweier Listen ineinander
    * verschachtelt, z.B. interleave([1,3], [2,4]) == [1,2,3,4], d.h. ein Element
    * aus der linken Liste, dann eines von rechts, wiederholt.
    * Sie können annehmen, dass beide Listen die selbe Länge haben.
    * Implementieren Sie die Funktion sowohl als reguläre als auch als Tail-Rekursion.
    *
    * @param l1 First list
    * @param l2 Second list
    * @return List with @param l1 and @param l2 interleaved
    */
  def interleave[T](l1 : List[T], l2 : List[T]) : List[T]
  def interleaveTail[T](l1 : List[T], l2 : List[T]) : List[T]

  /**
    * Compute the (first) index of an element @param e in a given list @param l and return it.
    * If no such element is present, return `l.length`.
    * Implement the function in regular recursion, tail recursion, and via fold.
    * Hint for fold: You can use `List.zipwithindex` or use tuples.
    *
    * Berechnen Sie den (ersten) Index eines Elements @param e in einer Liste @param l
    * und geben Sie diesen zurück. Wenn es kein solches Element gibt, geben Sie `l.length`
    * zurück.
    * Implementieren Sie die Funktion als reguläre Rekursion, Tail-Rekursion, und mittels fold.
    * Tipp für fold: Sie können `List.zipwithindex` oder Tuples verwenden.
    *
    * @param l list
    * @param e element
    * @return index of e in l
    */
  def findIndex[T](l : List[T], e : T) : Int
  def findIndexTail[T](l : List[T], e : T) : Int
  def findIndexFold[T](l : List[T], e : T) : Int

  /**
   * Define a function that computes a list in which no element is greater than
   * the parameter bound. Implement the function without explicit recursion, but
   * using fold function from the List class.
   *
   * Definieren Sie eine Funktion, die eine Liste zurück gibt, in der kein
   * Element größer als bound ist. Implementieren Sie die Funktion ohne
   * explizite Rekursion, sondern mit einer eingebauten fold-Funktion von Scala.
   *
   * @param bound largest possible in result
   * @param l a list
   * @return input list without values larger than bound
   */
  def bounded(bound : Int, l : List[Int]) : List[Int]

  /**
   * Define a function that returns if the input is sorted in descending
   * order. Using an empty Nil as input should result in true as return value.
   * Implement the function without explicit recursion, but
   * using fold function from the List class.
   *
   * Definieren Sie eine Funktion descending, die true zurückgibt, wenn die
   * Liste l absteigend sortiert ist. Eine leere Liste sollte true zurückgeben.
   * Implementieren Sie descending ohne explizite Rekursion, sondern mit einer
   * eingebauten f old-Funktion von Scala
   *
   * @param l a list
   * @return true if values are sorted in descending order
   */
  def descending(l : List[Int]) : Boolean

  /**
   * Implement a function without explicit recursion that computes the largest
   * element in a list. Use one of Scala's fold functions. For an empty list,
   * you should return Int.MinValue.
   *
   * Implementieren Sie eine Funktion ohne explizite Rekursion, welche das
   * größte Element in einer Liste zurückgibt. Benutzen Sie eine der von
   * Scala zur Verfügung gestellten fold-Funktionen. Für eine leere Liste
   * soll Int.MinValue zurückgegeben werden.
   *
   * @param l list of values
   * @return largest element
   */
  def max(l : List[Int]) : Int
}
