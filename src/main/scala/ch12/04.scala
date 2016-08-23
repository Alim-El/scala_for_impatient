package Ch12 {
  package Ex04 {
    object Main extends App {
      def factorial(n: Int) = (1 to n).foldLeft(1)(_ * _)
      assert(factorial(5) == 120)
    }
  }
}




