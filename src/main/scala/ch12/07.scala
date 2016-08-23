package Ch12 {
  package Ex07 {
    object Main extends App {
      def adjustToPair(f: (Int, Int) => Int) = (t: (Int, Int)) => f(t._1, t._2)
      assert(((1 to 3) zip (4 to 6)).map(adjustToPair(_+_)).toArray.deep == Array(5, 7, 9).deep)
    }
  }
}
