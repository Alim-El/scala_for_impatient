package Ch17 {
  package Ex03 {
    object Main extends App {
      class Pair[T, S](val first: T, val second: S) {
        def == (other: Pair[T, S]) : Boolean = (first == other.first) && (second == other.second)
      }
      def swap[T, S](p: Pair[T, S]): Pair[S, T] = new Pair[S, T](p.second, p.first)
      assert(swap(new Pair[Int, String](3, "three")) == new Pair[String, Int]("three", 3))
    }
  }
}

