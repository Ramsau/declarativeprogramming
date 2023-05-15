import scala.annotation.tailrec
import scala.collection.immutable

class FP3Solution extends FP3ExercisesProblems {

  override def premultiply(a: Int): Int => Int = {
    (b: Int) => a * b
  }

  override def premultiply2(a: Int)(b: Int): Int = a * b

  def weightedSum(l: List[Int], func: Int => Int): Int = l match {
    case x::xs => func(x) + weightedSum(xs, func)
    case Nil => 0
  }

  def weightedSumFold(l: List[Int], func: Int => Int): Int = l.foldLeft(0)((accum, a) => accum + func(a))

  def weightedSum2(func : Int => Int)(l : List[Int]) : Int = l.foldLeft(0)((accum, a) => accum + func(a))

  override def hasNTimes[T](n: Int, l: List[T], pred: T => Boolean): Boolean =
    l.foldLeft(n){case (accu, elem) => if (pred(elem)) accu - 1 else accu } == 0

  override def isPerfectSquare(n: Int): Boolean = {
    @tailrec
    def perfectSquareHelper(valToCheck : Int, n : Int) : Boolean = {
      if(valToCheck * valToCheck > n) false
      else if(valToCheck * valToCheck == n) true
      else perfectSquareHelper(valToCheck+1, n)
    }
    if (n < 0) false else perfectSquareHelper(0,n)
  }

  override def makePalindrom[T](l: List[T]): List[T] = l.foldLeft(l){
    case (accu,elem) => elem :: accu
  }

  override def remove[T](l: List[T], elem: T): List[T] =
    l.filter(other => other != elem)

  override def removeFold[T](l: List[T], elem: T): List[T] =
    l.foldLeft(List[T]()) { case (accu, other) => if(other == elem) accu :+ other else accu }
  
  override def interleave[T](l1 : List[T], l2 : List[T]) : List[T] = (l1, l2) match {
    case (a::as, b::bs) => a::b::interleave(as, bs)
    case _ => Nil
  }
  
  override def interleaveTail[T](l1 : List[T], l2 : List[T]) : List[T] = {
    @tailrec
    def inner(l1 : List[T], l2 : List[T], acc : List[T]) : List[T] = (l1, l2) match {
      case (a::as, b::bs) => inner(as, bs, acc ++ List(a, b)) // careful: Using an accumulator inverts the order of operations!
      case _ => acc
    }
    inner(l1, l2, List())
  }

  def findIndex[T](l : List[T], e : T) : Int = l match {
    case `e` :: _ | Nil => 0
    case _ :: tail => 1 + findIndex(tail, e)
  }

  def findIndexTail[T](l : List[T], e : T) : Int = {
    @tailrec
    def inner(l : List[T], acc : Int) : Int = l match {
      case `e` :: _ | Nil => acc
      case _ :: tail => inner(tail, acc + 1)
    }
    inner(l, 0)
  }

  def findIndexFold[T](l : List[T], e : T) : Int = l.foldLeft((0, false)) {
    case ((idx, true), _) => (idx, true) // already found it -> keep index
    case ((idx, false), `e`) => (idx, true) // just found it -> save index
    case ((idx, _), _) => (idx + 1, false) // accumulate
  }._1 // take index from tuple

  // Alternative: use `List.zipWithIndex` to have the index of each element ready, and return that
  /*
  def findIndexFold[T](l : List[T], e : T) : Int = l.zipWithIndex.foldLeft(l.length) {
    case (_, (`e`, idx)) => idx
    case (acc, _) => acc
  }
  */

  override def bounded(bound: Int, l: List[Int]): List[Int] =
    l.foldLeft(List[Int]()){
    case (accu, elem) => if (elem > bound) accu else accu :+ elem
  }

  override def descending(l: List[Int]): Boolean = l match {
    case Nil => true
    case head :: tail =>
      val(isDesc, lastVal) = tail.foldLeft((true,head)){
      case ((desc, lastElem), newElem) =>
        (desc && lastElem >= newElem, newElem)
      }
      isDesc
  }

  override def max(l: List[Int]): Int = l.foldLeft(Int.MinValue)
  {case (currentMax, elem) => if(elem >= currentMax) elem else currentMax}
}
