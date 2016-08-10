package Ch06 {
  package Ex06 {

    object CardSuite extends Enumeration {
      type CardSuite = Value
      val Hearts = Value("\u2665")
      val Christen = Value("\u2663")
      val Diamonds = Value("\u2666")
      val Spades = Value("\u2660")
    }

    object Main extends App {
      for (s <- CardSuite.values) println(s.id + ": " + s)
    }
  }
}

