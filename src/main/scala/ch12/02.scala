package Ch12 {
  package Ex02 {
    object Main extends App {
      assert(Array(1, 5, 3, 6, 2).reduceLeft(math.max) == 6)
    }
  }
}

