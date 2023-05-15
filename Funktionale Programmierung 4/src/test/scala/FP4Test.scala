import org.scalatest.funsuite.AnyFunSuite

class FP4Test extends AnyFunSuite {
  val testObject : FP4ExercisesProblems = new FP4Solution()

  test("add returns group with new student") {
    assert(testObject.addStudent(Group(Set("1", "2", "3")), "4") == Group(Set("1", "2", "3", "4")))
  }

  test("merge returns group with merged sets") {
    assert(testObject.mergeGroups(List(Group(Set("1", "2", "3")), Group(Set("4", "5", "6")))) == Group(Set("1", "2", "3", "4", "5", "6")))
  }

  test("evaluate(3*(6+2)) should be 24") {
    assert(testObject.evaluate(Mul(Literal(3), Add(Literal(6), Literal(2)))) == 24)
  }

  test("mapTree should convert to strings") {
    val tree = Inner(Inner(Leaf(1), Leaf(2)), Leaf(3))
    val expected = Inner(Inner(Leaf("1"), Leaf("2")), Leaf("3"))
    assert(testObject.mapTree[Int, String](tree, _.toString()) == expected)
  }

  test("treeDepth should find the longest branch left") {
    val tree = Inner(Inner(Leaf(1), Leaf(2)), Leaf(3))
    assert(testObject.treeDepth(tree) == 2)
  }

  test("treeDepth should find the longest branch right") {
    val tree = Inner(Leaf(3), Inner(Leaf(1), Leaf(2)))
    assert(testObject.treeDepth(tree) == 2)
  }

  test("invertTree should invert") {
    val tree = Inner(Inner(Leaf(1), Leaf(2)), Leaf(3))
    val expected = Inner(Leaf(3), Inner(Leaf(2), Leaf(1)))
    assert(testObject.invertTree(tree) == expected)
  }

  test("foldTree should sum the leaves") {
    val tree = Inner(Inner(Leaf(1), Leaf(2)), Leaf(3))
    assert(testObject.foldTree(tree)(0)(_+_) == 6)
  }

  test("foldTree should append the leaves in order") {
    val tree = Inner(Inner(Inner(Leaf(1), Leaf(2)), Leaf(3)), Inner(Leaf(4), Leaf(5)))
    assert(testObject.foldTree(tree)(List[Int]())(_++List(_)) == List(1,2,3,4,5))
  }
}
