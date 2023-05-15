import org.scalatest.funsuite.AnyFunSuite

class FP3Test extends AnyFunSuite {
  val testObject : FP3ExercisesProblems = new FP3Solution()

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

  test("weightedSum([], a => 2 * a) should evaluate to 0") {
    assert(testObject.weightedSum(List(), a => 2 * a) == 0)
    assert(testObject.weightedSumFold(List(), a => 2 * a) == 0)
    assert(testObject.weightedSum2(a => 2 * a)(List()) == 0)
  }
  test("weightedSum([5], a => 2 * a) should evaluate to 10") {
    assert(testObject.weightedSum(List(5), a => 2 * a) == 10)
    assert(testObject.weightedSumFold(List(5), a => 2 * a) == 10)
    assert(testObject.weightedSum2(a => 2 * a)(List(5)) == 10)
  }
  test("weightedSum([1,2,3], a => 2 * a) should evaluate to 12") {
    assert(testObject.weightedSum(List(1,2,3), a => 2 * a) == 12)
    assert(testObject.weightedSumFold(List(1,2,3), a => 2 * a) == 12)
    assert(testObject.weightedSum2(a => 2 * a)(List(1,2,3)) == 12)
  }

  test("make palindrom empty"){
    assert(testObject.makePalindrom(Nil) == Nil)
  }

  test("make palindrom one") {
    assert(testObject.makePalindrom(List(1)) == List(1,1))
  }

  test("make palindrom 576") {
    assert(testObject.makePalindrom(List(5, 7, 6)) == List(6,7,5,5,7,6))
  }

  test("make palindrom 12") {
    assert(testObject.makePalindrom(List(1, 2)) == List(2, 1,1,2))
  }

  test("bounded no larger value") {
    assert(testObject.bounded(10, List(1, 2, 3)) == List(1, 2, 3))
  }
  test("bounded one larger value") {
    assert(testObject.bounded(10, List(1, 2, 13)) == List(1, 2))
  }

  test("bounded all larger values") {
    assert(testObject.bounded(10, List(11, 12, 13)) == List())
  }

  test("descending empty") {
    assert(testObject.descending(Nil) == true)
  }

  test("descending true") {
    assert(testObject.descending(List(5,2,1)) == true)
  }


  test("descending assending") {
    assert(testObject.descending(List(1, 2, 3)) == false)
  }

  test("descending almost") {
    assert(testObject.descending(List(5, 3, 1, 2)) == false)
  }

  test("max empty"){
    assert(testObject.max(Nil) == Int.MinValue)
  }


  test("max nominal") {
    assert(testObject.max(List(1,5,10,4,9)) == 10)
  }

  test("max one apart") {
    assert(testObject.max(List(9, 10, 9)) == 10)
    assert(testObject.max(List(9, 8, 9)) == 9)
    assert(testObject.max(List(9, 10, 11)) == 11)
  }

  test("interleave([1,3],[2,4]) should evaluate to [1,2,3,4]") {
    assert(testObject.interleave(List(1,3), List(2,4)) == List(1,2,3,4))
    assert(testObject.interleaveTail(List(1,3), List(2,4)) == List(1,2,3,4))
  }

  test("findIndex([1,2,3], 1) should evaluate to 0") {
    assert(testObject.findIndex(List(1,2,3), 1) == 0)
    assert(testObject.findIndexTail(List(1,2,3), 1) == 0)
    assert(testObject.findIndexFold(List(1,2,3), 1) == 0)
  }
  test("findIndex([1,2,3], 3) should evaluate to 2") {
    assert(testObject.findIndex(List(1,2,3), 3) == 2)
    assert(testObject.findIndexTail(List(1,2,3), 3) == 2)
    assert(testObject.findIndexFold(List(1,2,3), 3) == 2)
  }
  test("findIndex([1,2,3], 4) should evaluate to 3") {
    assert(testObject.findIndex(List(1,2,3), 4) == 3)
    assert(testObject.findIndexTail(List(1,2,3), 4) == 3)
    assert(testObject.findIndexFold(List(1,2,3), 4) == 3)
  }
}
