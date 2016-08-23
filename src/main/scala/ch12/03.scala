package Ch12 {
  package Ex03 {
    object Main extends App {
      def factorial(n: Int) = (1 to n).reduceLeft(_ * _)
      assert(factorial(5) == 120)
    }
  }
}


