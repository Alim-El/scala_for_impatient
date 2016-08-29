package Ch13 {
  package Ex08 {
    object Main extends App {
      def pac(arr: Array[Double], cols: Int): Array[Array[Double]] = arr.grouped(cols).toArray
      assert(pac(Array(1, 2, 3, 4, 5, 6, 7), 3).deep == Array(Array(1, 2, 3), Array(4, 5, 6), Array(7)).deep)
    }
  }
}

