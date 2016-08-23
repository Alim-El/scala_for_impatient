package Ch12 {
  package Ex05 {
    object Main extends App {
      def largest(fun: (Int) => Int, inputs: Seq[Int]): Int = inputs.map(fun).max
      assert(largest(x => x * 10 - x * x, 1 to 10) == 25)
    }
  }
}


