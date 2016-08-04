import scala.collection.mutable.ArrayBuffer

object Main extends App {
  def createArray(n: Int): Array[Int] = {
    var array = new ArrayBuffer[Int]()
    for (i <- 0 until n) array += i
    array.toArray
  }
  assert(createArray(5).deep == Array(0, 1, 2, 3, 4).deep)
}
