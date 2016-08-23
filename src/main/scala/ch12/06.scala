package Ch12 {
  package Ex06 {
    object Main extends App {
      def largestAt(fun: (Int) => Int, inputs: Seq[Int]): Int = inputs.map(x => (x, fun(x))).maxBy(_._2)._1
      assert(largestAt(x => x * 10 - x * x, 1 to 10) == 5)
    }
  }
}
