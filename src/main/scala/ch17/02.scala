package Ch17 {
  package Ex02 {
    object Main extends App {
      class Pair[T](var first: T, var second: T) {
        def swap: Pair[T] = {
          var x = first
          first = second
          second = x
          this
        }
        def == (other: Pair[T]) : Boolean = (first == other.first) && (second == other.second)
      }

      val p = new Pair[Int](5, 6)
      assert(p.swap == new Pair[Int](6, 5))
    }
  }
}

