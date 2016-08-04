import scala.collection.mutable.ArrayBuffer

object Main extends App {
  def replaceElsInArray(arr: Array[Int]): Array[Int] = {
    (arr.filter(_ > 0).toBuffer ++= arr.filter(_ <= 0)).toArray
  }
  assert(replaceElsInArray(Array(-3, 0, 1, 2, -2, 0, 3, -1)).deep == Array(1, 2, 3, -3, 0, -2, 0, -1).deep)
}

