trait FP2ExercisesProblems {

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
   * Creates a list containing the integer interval [from .. to).
   *
   * Diese Funktion erzeugt eine Liste mit dem Ganzzahlinterval [from .. to).
   *
   * @param from interval start (inclusive)
   * @param to interval end (exclusive)
   *
   * @return list containing interval [from .. to)
   */
  def range(from : Int, to : Int) : List[Int] =
    if(from >= to) Nil else from :: range(from + 1, to)

  /**
   * Implement a tail-recursive version of the above function {@code range}.
   *
   * Implementieren Sie eine tail-rekursive Version der obigen Funktion
   * {@code range}.
   *
   * @param from interval start (inclusive)
   * @param to   interval end (exclusive)
   * @return list containing interval [from .. to)
   */
  def rangeTail(from : Int, to : Int) : List[Int]

  /**
   * Flatten the input list, i.e., concatenate all lists of the input list.
   *
   * @param l a list of lists
   * @return flattened list
   */
  def flatten(l : List[List[Int]]) : List[Int] = l match {
    case Nil => Nil
    case head :: tail => head ++ flatten(tail)
  }

  /**
   * Implement a tail-recursive version of the above function {@code flatten}.
   *
   * Implementieren Sie eine tail-rekursive Version der obigen Funktion
   * {@code flatten}.
   *
   * @param l a list of lists
   * @return flattened list
   */
  def flattenTail(l: List[List[Int]]): List[Int]

  /**
   * Implement the unzip function, which takes a list of pairs and returns
   * a pair of lists, where the left/right result list contains the
   * left/right pair elements from the input list.
   *
   * Implementieren Sie die unzip Funktion, welche eine Liste von Paare in ein
   * Paar von Listen umwandelt, wobei die linke/recht Liste im Ergebnispaar
   * die linken/rechten Paarelemente der Eingabeliste beinhalten soll.
   *
   * @param pairList a list of pairs
   * @return unzipped lists
   */
  def unzip(pairList : List[(Int, Int)]) : (List[Int], List[Int])

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
   * Implement a function which checks whether a list is in ascending order
   *
   * Schreiben Sie eine Function, die überprüft ob eine Liste aufsteigend sortiert ist.
   *
   * @param l List
   * @return true if l is ascending
   */
  def isAscending(l:List[Int]): Boolean

  /**
   * Implement a function to calculate the dot product of two vectors.
   *
   * Schreiben Sie eine Function, die das Dotprodukt zweier Vektoren berechnet.
   *
   * @param a_vec first vector
   * @param b_vec second vector
   * @return dot product of a_vec and b_vec or 0 if unequal length
   */
  def dotProduct(a_vec: List[Int], b_vec: List[Int]): Int

  /**
   * Implement a bitwise AND for two lists containing only 0s and 1s.
   *
   * Implementieren Sie ein bitweises UND für zwei Bitlisten.
   *
   * @param a bit List
   * @param b bit List
   * @return a & b
   */
  def bitwiseAnd(a: List[Int], b: List[Int]): List[Int]

  /**
   * Implement a bitwise shift (right shift) given a list, containing
   * only 0s and 1s, and the shift count.
   *
   * Implementieren Sie die binäre Shiftfunktion (nach Rechts). Gegeben ist eine Bitliste, die
   * nur 0 und 1 enthält, und die Anzahl der Verschiebungen.
   *
   * @param l bit List
   * @param count of shifts
   * @return l >> count
   */
  def bitwiseRightShift(l: List[Int], count: Int): List[Int]

  /**
   * Implement the mean squared error of two input lists with values using a
   * recursive function, i.e., average of the squared the difference of elements
   * at the same index in both lists.
   * Note: You may use List.length for computing the length of a list
   * but you may also create a recursive helper function. List.zip can be used
   * to combine two lists into a list of pairs.
   *
   * You can assume that both lists have the same length.
   *
   * Implementieren sie die mittlere quadratische Abweichung der Werte von zwei
   * Eingabelisten mithilfe einer rekursiven Funktion. D.h. es soll der
   * Durchschnittswert der quadratischen Differenzen von allen Paaren von Werten
   * an den gleichen Positionen in den Listen berechnet werden.
   *
   * Sie können die Funktion List.length verwenden, um die Länge einer Liste zu
   * berechnen oder eine Hilfsfunktion dafür implementieren. Die Funktion
   * List.zip kann verwendet verwenden, um zwei Listen zu einer Liste von Paaren
   * zu kombinieren.
   *
   * Sie können annehmen, dass die Eingabelisten die gleiche Länge haben.
   *
   *
   * @param measured a list of measured values
   * @param target a list of target values to which we compare
   * @return the mean squared error
   */
  def mse(measured : List[Double], target : List[Double]) : Double

  /**
   * Compute the absolute values of all elements in the input lists and return
   * them in a new list by using List.map.
   *
   * Berechnen Sie die Absolutwerte aller Elemente der Eingabeliste und geben
   * Sie diese als neue Liste zurück. Verwenden Sie dazu List.map.
   *
   * @param list a list of values
   * @return absolute values of the input list
   */
  def absList(list: List[Int]): List[Int]

  /**
   * Compute the absolute values of all elements in the input lists and return
   * them in a new list by using one of the fold functions of the List class.
   *
   * Berechnen Sie die Absolutwerte aller Elemente der Eingabeliste und geben
   * Sie diese als neue Liste zurück. Verwenden Sie dazu eine der
   * fold-Funktionen der List-Klasse.
   *
   * @param list a list of values
   * @return absolute values of the input list
   */
  def absListFold(list: List[Int]): List[Int]

  /**
   * Process the input list by filtering out all values that are less than or
   * equal to 0, i.e., return a list of all the positive values in the input
   * list. Use the function List.filter for this purpose.
   *
   * Implementieren Sie eine Funktion, die alle Werte aus der Eingabeliste
   * entfernt, die kleiner oder gleich null sind, und geben Sie die übrigen
   * positiven Werte als Ergebnisliste zurück. Verwenden Sie dazu List.filter.
   *
   * @param list a list of values
   * @return positive values from the input list
   */
  def keepPositive(list: List[Int]): List[Int]

  /**
   * Process the input list by filtering out all values that are less than or
   * equal to 0, i.e., return a list of all the positive values in the input
   * list. Use one of the fold functions of the List class for this purpose.
   *
   * Implementieren Sie eine Funktion, die alle Werte aus der Eingabeliste
   * entfernt, die kleiner oder gleich null sind, und geben Sie die übrigen
   * positiven Werte als Ergebnisliste zurück. Verwenden Sie dazu eine der
   * fold-Funktionen der List-Klasse.
   *
   * @param list a list of values
   * @return positive values from the input list
   */
  def keepPositiveFold(list: List[Int]): List[Int]

  /**
   * Given a list of integer pairs, create a solution list, which only
   * contains the largest element of each pair.
   *
   * Erstellen Sie aus einer Liste von Ganzzahlpaaren eine Lösungsliste,
   * die nur das größte Element eines jeden Paares enthält
   *
   * @param pairs a list pairs
   * @return list of largest element per pair
   */
  def maxInPairs(pairs : List[(Int,Int)]) : List[Int]
  def maxInPairsTail(pairs : List[(Int,Int)]) : List[Int]

  /**
   * The function takes a total amount of money and a list containing the
   * different coins that might be used to pay the amount. The functions returns
   * the amount of different ways to achieve this
   *
   * Die Funktion nimmt einen Gesamtbetrag an Geld und eine Liste mit den
   * verschiedenen Münzen, die zur Zahlung des Betrags verwendet werden können.
   * Die Funktion gibt die Anzahl der verschiedenen Möglichkeiten,
   * diesen Betrag zu begleichen, zurück.
   *
   * @param money total amount to be paid
   * @param coins possible coins that can be used
   * @return count of ways to achieve the total amount
   */
  def countChange(money: Int, coins: List[Int]): Int

  /**
   * The function takes a list of integers and should only evaluate to true
   * if every second element is even and the list is of even length.
   *
   * Die Funktion nimmt eine Liste von Ganzzahlen und
   * soll nur dann true ergeben, wenn jedes zweite Element gerade ist,
   * als auch die Länge der Liste.
   *
   * @param l list of integers
   * @return true if every second element is even else false
   */
  def checkEvenEven(l: List[Int]): Boolean

  /**
   * The function takes a list of integers and a predicate function as input and returns a new list
   * containing all the elements of the original list until the pred(e) != true.
   *
   * Die Funktion nimmt eine Liste von ganzen Zahlen und eine Prädikatsfunktion als Eingabe
   * und gibt eine neue Liste zurück, die alle Elemente der ursprünglichen Liste enthält,
   * bis pred(e) != true ist.
   *
   * @param list list of integers
   * @param pred function that takes one int and  returns bool
   * @return true if every second element is even else false
   */
  def takeWhile(list: List[Int], pred: Int => Boolean): List[Int]

  /**
   * The function should return true, if at least one f(x) == 0 for x between start and end (inclusive).
   *
   * Die Funktion soll true zurück geben, wenn f zwischen start und end (inklusive)
   * zu 0 evaluiert.
   *
   * @param start starting value
   * @param end end value (inclusive)
   * @param f function that returns 0 if param is a root
   * @return true if one f(x) == 0 for start <= x <= end
   */
  def hasRoot(start : Int, end : Int, f : Int => Int): Boolean

  /**
   * The function should return a list consisting of the solutions of f(x) for x between start and end
   *
   * Die Funktion soll eine Liste mit den Ergebnissen von f(x) für alle x zwischen "start" und "end"
   * zurückgeben.
   *
   * @param start starting value
   * @param end end value (inclusive)
   * @param f function that takes one arg and returns int
   * @return list(f(start), f(start+1), ..., f(end))
   */
  def fill(start : Int, end : Int, f : Int => Int) : List[Int]
}
