import scala.collection.mutable.ArrayBuffer

package Ch03 {

  package Ex01 {

    object Main extends App {
      def createArray(n: Int): Array[Int] = {
        (0 until n).toArray
      }

      assert(createArray(5).deep == Array(0, 1, 2, 3, 4).deep)
    }

  }

}