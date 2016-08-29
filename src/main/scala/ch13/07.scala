package Ch13 {
  package Ex07 {
    object Main extends App {
      val prices = List(0.5, 1, 1.5, 2, 2.5)
      val quantities = List(1, 2, 3, 4, 5)
      assert(prices.zip(quantities).map(Function.tupled(_*_)).sum == 27.5.toDouble)
    }
  }
}

