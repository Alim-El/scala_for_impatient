package Ch12 {
  package Ex09 {
    object Main extends App {
      def corresponds(a: Array[String], b: Array[Int], f: (String, Int) => Boolean): Boolean =
        (a zip b).map(x => f(x._1, x._2)).foldLeft(true)(_ && _)

      val a = Array("Hello", "world!")
      val b = Array(5, 6)
      assert(corresponds(a, b, (x, y) => x.length == y))
    }
  }
}


