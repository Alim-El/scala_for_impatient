import scala.collection.mutable.ArrayBuffer

package Ch03 {

  package Ex06 {

    object Main extends App {
      var array = Array(5, 6, 85, 1)
      assert(array.sortWith(_ >= _).deep == Array(85, 6, 5, 1).deep)
      var arrayBuf = ArrayBuffer(5, 6, 85, 1)
      assert(arrayBuf.sortWith(_ >= _) == ArrayBuffer(85, 6, 5, 1))
    }

  }

}


