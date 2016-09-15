package Ch17 {
  package Ex10 {
    object Main extends App {
      // ev - неявный параметр подтверждения - S должен быть равен T
      class Pair[S, T](var first: S, var second: T) {
        def swap(implicit ev1: S =:= T, ev2: T =:= S) {
          val tmp = first
          first = second
          second = tmp
        }
      }
      val p = new Pair("one", "two")
      p.swap
      assert(p.first == "two")
    }
  }
}

