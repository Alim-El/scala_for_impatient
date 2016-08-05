object Main extends App {
  def lteqgt(arr: Array[Int], v: Int): (Int, Int, Int) = {
    (arr.count(_ < v), arr.count(_ == v), arr.count(_ > v))
  }
  assert(lteqgt(Array(6, 4, 7, 3, 6, 1, 6, 15, 6), 6) == (3, 4, 2))
}

