package Ch14 {
  package Ex10 {
    object Main extends App {
      def compose(f1: Double => Option[Double], f2: Double => Option[Double]): Double => Option[Double] =
        (x:Double) => f2(x) match {
          case Some(f2x) => f1(f2x)
          case None => None
        }

      def f1(x:Double) = if (x >= 0) Some(math.sqrt(x)) else None
      def f2(x:Double) = if (x != 1) Some(1 / (x - 1)) else None
      val h = compose(f1, f2)
      assert(h(2) == Some(1.0))
      assert(!h(1).isDefined)
      assert(!h(0).isDefined)
    }
  }
}

