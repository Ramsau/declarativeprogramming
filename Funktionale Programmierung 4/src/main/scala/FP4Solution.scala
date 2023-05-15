import scala.annotation.tailrec
import scala.collection.immutable

class FP4Solution extends FP4ExercisesProblems {
  def addStudent(group : Group, student : String) : Group = Group(group.students + student)

  def mergeGroups(groups : List[Group]) : Group = groups.reduceLeft[Group] {
    case (Group(sum_students), Group(a)) => Group(sum_students ++ a)
  }

  def evaluate(expr : ArithExpr) : Int = expr match {
    case Literal(lit) => lit
    case Mul(left, right) => evaluate(left) * evaluate(right)
    case Div(left, right) => evaluate(left) / evaluate(right)
    case Add(left, right) => evaluate(left) + evaluate(right)
    case Sub(left, right) => evaluate(left) - evaluate(right)
  }

  def mapTree[T, R](tree : Tree[T], f : T => R) : Tree[R] = tree match {
    case Leaf(value) => Leaf(f(value))
    case Inner(left, right) => Inner(mapTree(left, f), mapTree(right, f))
  }

  def treeDepth[T](tree : Tree[T]) : Int = tree match {
    case Leaf(_) => 0
    case Inner(left, right) =>
      val l = treeDepth(left)
      val r = treeDepth(right)
      (if (l > r) l else r) + 1
  }

  def invertTree[T](tree : Tree[T]) : Tree[T] = tree match {
    case leaf@Leaf(_) => leaf // give a name to the whole expression `Leaf(value)` and return that
    case Inner(left, right) => Inner(invertTree(right), invertTree(left))
  }

  def foldTree[T, R](tree : Tree[T])(zero : R)(fn : (R, T) => R) : R = tree match {
    case Leaf(value) => fn(zero, value)
    case Inner(left, right) =>
      val zl = foldTree(left)(zero)(fn)
      foldTree(right)(zl)(fn)
  }
}
