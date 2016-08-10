package Ch05 {
  package Ex01 {

    object Main extends App {

      class Counter {
        private var value: Int = 0

        def increment() {
          if (value < Int.MaxValue) value += 1
        }

        def current = value
      }

      var c = new Counter()
      var i = 0L
      while (i <= Int.MaxValue) {
        c.increment()
        i += 1
      }
      assert(c.current == Int.MaxValue)
    }
  }
}
