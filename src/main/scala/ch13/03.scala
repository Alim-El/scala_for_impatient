package Ch13 {
  package Ex03 {
    object Main extends App {
      assert(List(1, 0, 5, 7, 0, 9).filter(_ != 0) == List(1, 5, 7, 9))
    }
  }
}

