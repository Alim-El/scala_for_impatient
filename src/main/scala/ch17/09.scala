package Ch17 {
  package Ex09 {
    class Pair[T](val first: T, val second: T) {
      def replaceFirst(newFirst: T) = new Pair[T](newFirst, second)
    }

    object Main extends App {
      class NastyDoublePair(first: Double, second: Double) extends Pair[Double](first, second) {
        override def replaceFirst(newFirst: Double) = new NastyDoublePair(scala.math.sqrt(newFirst), second)
      }

      var p = new NastyDoublePair(1.0, 10.0)
      val p1 = p.replaceFirst(9.0)
      assert(p1.first == 3.0)

      // А вот это не компилляется, и это есть good
      /*val p2: Pair[Any] = new NastyDoublePair(5.0 , 6.0)
      val p3 = p2.replaceFirst("hello")*/
    }
  }
}

