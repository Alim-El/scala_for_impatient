package Ch04 {
  package Ex08 {

    object Main extends App {
      def minmax(arr: Array[Int]): (Int, Int) = {
        (arr.sorted.head, arr.sorted.last)
      }

      assert(minmax(Array(6, 4, 7, 3, 15, 7)) == (3, 15))
    }

  }

}

