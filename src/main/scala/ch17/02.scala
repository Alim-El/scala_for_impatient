package Ch17 {
  package Ex02 {
    object Main extends App {
      class Pair[T](val first: T, val second: T) {
        def swap: Pair[T] = new Pair[T](second, first)
        def == (other: Pair[T]) : Boolean = (first == other.first) && (second == other.second)
        override def toString: String = "(" + first.toString + ", " + second.toString + ")"
      }

      val p = new Pair[Int](5, 6)
      assert(p.swap == new Pair[Int](6, 5))
    }
  }
}

