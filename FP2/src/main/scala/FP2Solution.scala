import scala.annotation.tailrec

class FP2Solution extends FP2ExercisesProblems {

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
  override def rangeTail(from: Int, to: Int): List[Int] = {
    @tailrec
    def rangeTailHelper(from : Int, to : Int, acc : List[Int]): List[Int] = {
      if (from > to) acc.reverse
      else rangeTailHelper(from + 1, to, from :: acc)
    }
    rangeTailHelper(from, to, Nil)
  }


  override def unzip(pairList: List[(Int, Int)]): (List[Int], List[Int]) =
    pairList match {
      case Nil => (Nil, Nil)
      case (headLeft, headRight) :: tail =>
        val (tailLeft, tailRight) = unzip(tail)
        (headLeft :: tailLeft, headRight :: tailRight)
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
  override def flattenTail(l: List[List[Int]]): List[Int] = {
    @tailrec
    def flattenTailHelper(l : List[List[Int]], acc : List[Int]) : List[Int]
    = l match {
      case Nil => acc
      case head :: tail => flattenTailHelper(tail, acc ++ head)
    }
    flattenTailHelper(l, Nil)
  }

  override def isAscending(l:List[Int]): Boolean = {
    l match {
      case first::Nil => true
      case first::second::tail if second < first => false
      case first::second::tail => isAscending(second::tail)
    }
  }

  override def dotProduct(a_vec: List[Int], b_vec: List[Int]): Int = {
    @tailrec
    def sumAndMultiply(a: List[Int], b: List[Int], sum: Int = 0): Int = (a, b) match {
      case (Nil, _) | (_, Nil) => sum
      case (a, b) if a.length != b.length => sum
      case (a_head::a_tail, b_head::b_tail) =>
        sumAndMultiply(a_tail, b_tail, sum + a_head * b_head)
    }

    sumAndMultiply(a_vec, b_vec)
  }

  override def bitwiseAnd(a: List[Int], b: List[Int]): List[Int] = (a, b) match {
    case (Nil, _) | (_, Nil) =>
      Nil
    case (1::as, 1::bs) =>
      1::bitwiseAnd(as, bs)
    case (a::as, b::bs) =>
      0::bitwiseAnd(as, bs)
  }

  override def bitwiseRightShift(l: List[Int], count: Int): List[Int] = {
    if (count <= 0 || l.isEmpty)
      l
    else
      bitwiseRightShift(0::l.init, count - 1)
  }

  override def mse(measured: List[Double], target: List[Double]): Double = {
    val zipped = measured.zip(target)
    zipped
      .foldLeft(0.0){case (acc,(m,t)) => acc + math.pow(m-t,2)} / zipped.length
  }

  override def absList(list: List[Int]): List[Int] =
    list.map(elem => if(elem < 0) -elem else elem)

  override def absListFold(list: List[Int]): List[Int] =
    list.foldLeft(List[Int]()){
      case(acc,elem) => acc :+ (if(elem<0) -elem else elem)}

  override def keepPositive(list: List[Int]): List[Int] =
    list.filter(elem => elem > 0)

  override def keepPositiveFold(list: List[Int]): List[Int] =
    list.foldLeft(List[Int]()) {
      case (acc, elem) => if (elem > 0) acc :+ elem else acc}

  override def maxInPairs(pairs : List[(Int,Int)]) : List[Int] = {
    pairs match {
      case Nil => Nil
      case (x,y) :: t if x > y => x :: maxInPairs(t)
      case (_,y) :: t => y :: maxInPairs(t)
    }
  }

  override def maxInPairsTail(pairs : List[(Int,Int)]) : List[Int] = {
    @tailrec
    def maxInPairsTailrec(pairs : List[(Int,Int)], accu : List[Int]):List[Int] = {
      pairs match {
        case Nil => accu.reverse
        case (x, y) :: t if x > y => maxInPairsTailrec(t, x::accu)
        case (_, y) :: t => maxInPairsTailrec(t,y :: accu)
      }
    }
    maxInPairsTailrec(pairs, Nil)
  }

  override def countChange(money: Int, coins: List[Int]): Int = (money, coins) match {
    case (0, _) => 1
    case (m, _) if m < 0 => 0
    case (_, cs)  if cs.isEmpty => 0
    case (m, cs) => countChange(m - cs.head, cs) + countChange(m, cs.tail)
  }

  override def checkEvenEven(l: List[Int]): Boolean = l match {
    case Nil => true
    case List(_) => false
    case x::y::tail=> (y % 2 == 0) && checkEvenEven(tail)
    case _ => false
  }

  override def takeWhile(list: List[Int], pred: Int => Boolean): List[Int] = list match {
      case Nil => Nil
      case x::xs if(pred(x)) => x::takeWhile(xs, pred)
      case _ => Nil
  }

  override def hasRoot(start : Int, end : Int, f : Int => Int): Boolean = start match {
    case `end` => f(start) == 0
    case x if(f(x) == 0) => true
    case x => hasRoot(x + 1, end, f)
  }

  override def fill(start : Int, end : Int, f : Int => Int) : List[Int] = start match {
    case `end` => f(end)::Nil
    case x => f(x)::fill(x + 1, end, f)
  }
}
