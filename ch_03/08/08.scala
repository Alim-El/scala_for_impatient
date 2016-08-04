import scala.collection.mutable.ArrayBuffer

object Main extends App {
  var array = ArrayBuffer(1, -5, 0, -5, 8, 6, 0, -6, -89, 0, 10, -6)
  var indexes = (for(i <- 0 until array.length if array(i) < 0) yield i).toBuffer.sortWith(_ > _).dropRight(1)
  for(i <- 0 until indexes.length) array.remove(indexes(i))
  assert(array == ArrayBuffer(1, -5, 0, 8, 6, 0, 0, 10))
}


