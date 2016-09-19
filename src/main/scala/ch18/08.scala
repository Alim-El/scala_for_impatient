package Ch18 {
  package Ex08 {
    object Main extends App {
      def printValues(f: {def apply(n: Int):Int}, from: Int, to: Int) = {
        (`from` to `to`).map(x => println(f(x)))
      }

      printValues((x: Int) => x*x, 3, 6)
      printValues(Array(1, 2, 3, 4, 5, 6, 7, 8), 2, 5)
    }
  }
}

