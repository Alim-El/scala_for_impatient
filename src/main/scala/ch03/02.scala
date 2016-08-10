import scala.collection.mutable.ArrayBuffer

package Ch03 {

  package Ex02 {

    object Main extends App {
      def replaceElsInArray(arr: Array[Int]): Array[Int] = {
        var result = new ArrayBuffer[Int]()
        for (i <- 0 until arr.length by +2) {
          if (i + 1 < arr.length) {
            result += arr(i + 1)
            result += arr(i)
          }
          else {
            result += arr(i)
          }
        }
        result.toArray
      }

      assert(replaceElsInArray(Array(1, 2, 3, 4)).deep == Array(2, 1, 4, 3).deep)
      assert(replaceElsInArray(Array(1, 2, 3)).deep == Array(2, 1, 3).deep)
    }

  }

}
