import scala.annotation.tailrec
import scala.collection.immutable.::

/**
  * Represents a student group
  * @param students
  */
case class Group(students : Set[String])

/**
  * Base trait for arithmetic expressions
  */
trait ArithExpr
/**
  * Represents a literal inside our arithmetic expressions
  * @param lit
  */
case class Literal(lit : Int) extends ArithExpr
/**
  * Represents a multiplication operation for our arithmetic expressions
  * @param left subtree
  * @param right subtree
  */
case class Mul(left : ArithExpr, right : ArithExpr) extends ArithExpr
/**
  * Represents a division operation for our arithmetic expressions
  * @param left subtree
  * @param right subtree
  */
case class Div(left : ArithExpr, right : ArithExpr) extends ArithExpr
/**
  * Represents a addition operation for our arithmetic expressions
  * @param left subtree
  * @param right subtree
  */
case class Add(left : ArithExpr, right : ArithExpr) extends ArithExpr
/**
  * Represents a subtraction operation for our arithmetic expressions
  * @param left subtree
  * @param right subtree
  */
case class Sub(left : ArithExpr, right : ArithExpr) extends ArithExpr

/**
  * Base trait for our binary tree
  */
trait Tree[T]
/**
  * A leaf node of the tree
  */
case class Leaf[T](value : T) extends Tree[T]
/**
  * Inner node of the tree
  */
case class Inner[T](left : Tree[T], right : Tree[T]) extends Tree[T]


//trait FP4ExercisesProblems {
  /**
    * Implement a function that takes a group, and adds a student
    * to this group. Note that classes are immutable, so return a
    * new instance.
    * 
    * Implementieren Sie eine Funktion, welche einen Studenten zu
    * einer Gruppe hinzufügt. Klassen sind unveränderbar, also geben
    * Sie eine neue Instanz zurück.
    *
    * @param group
    * @param student
    * @return group with new student
    */
  def addStudent(group : Group, student : String) : Group = Group(group.students + (student))

  /**
    * Implement a function that takes a list of immutable classes
    * and returns a new instance of that class that contains the
    * set of all students in all groups.
    * 
    * Implementieren Sie eine Funktion, welche eine Liste an
    * unveränderbaren Klassen übergeben bekommt, und eine neue Instanz
    * dieser Klasse zurückgibt, mit dem Set aller Studenten aller
    * Gruppen.
    *
    * @param groups
    * @return a group containing all students
    */
  def mergeGroups(groups : List[Group]) : Group = groups.foldLeft(Group(Set[String]()))((merged: Group, newG: Group) => Group(merged.students ++ newG.students))


  /**
    * Implement a function that evaluates a given arithmetic expression,
    * represented as nested `ArithExpr` classes.
    * 
    * Implementieren Sie eine Funktion, welche einen arithmetische
    * Ausdruck evaluiert.
    *
    * @param expr expression to evaluate
    * @return result
    */
//  def evaluate(expr : ArithExpr) : Int

  /**
    * Write a function that takes a tree, and applies a mapping function
    * to all it's leaves.
    * 
    * Schreiben Sie eine Funktion, welche eine Mapping-Funktion auf alle
    * Blätter eines gegebenen Baums anwendet.
    *
    * @param tree
    * @param f mapping
    * @return new tree with mapped leaves
    */
//  def mapTree[T, R](tree : Tree[T], f : T => R) : Tree[R]

  /**
    * Implement a function that measures the depth of a given tree. A tree
    * with just a leaf has depth 0. The function should return the maximal
    * depth, i.e. for an unbalanced tree, return the larger depth.
    * 
    * Implementieren Sie eine Funktion, die die Tiefe eines Baums berechnet.
    * Ein Blatt alleine hat Tiefe 0. Geben Sie das Maxiumum der Tiefen der
    * Subbäume zurück.
    *
    * @param tree
    * @return depth of tree
    */
//  def treeDepth[T](tree : Tree[T]) : Int

  /**
    * Given a binary tree, invert it; that is swap each node's subtrees.
    * 
    * Invertieren Sie den Binärbaum; dabei sollen je die Subbäume getauscht
    * werden.
    *
    * @param tree
    * @return
    */
//  def invertTree[T](tree : Tree[T]) : Tree[T]

  /**
    * Write a function that implements the fold operation on a binary tree.
    * Your function should visit the nodes in pre-order, that is use left-
    * recursion and process the leaves from left to right.
    * 
    * Schreiben Sie eine Funktion die die Fold-Operation auf einem Binärbaum
    * implementiert. Ihre Funktion soll die Knoten in Hauptreihenfolge ab-
    * arbeiten, d.h. die Blätter von links nach rechts ausgeben.
    *
    * @param tree
    * @param zero element
    * @param fn mapping function
    * @return folded tree
    */
  def foldTree[T, R](tree : Tree[T])(zero : R)(fn : (R, T) => R) : R = {
    def inner(sum: R, tree: Tree[T]): R = {
      tree match {
        case Leaf(v) => fn(sum, v)
        case Inner(left, right) => inner(inner(sum, left), right)
      }
    }
    inner(zero, tree)
  }
//}
