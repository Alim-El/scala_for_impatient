package Ch06 {
  package Ex07 {

    object CardSuite extends Enumeration {
      type CardSuite = Value
      val Hearts = Value("\u2665")
      val Christen = Value("\u2663")
      val Diamonds = Value("\u2666")
      val Spades = Value("\u2660")
    }

    object Main extends App {
      def isRed(s: CardSuite.CardSuite): Boolean = {
        s == CardSuite.Hearts || s == CardSuite.Diamonds
      }

      assert(isRed(CardSuite.Hearts))
      assert(isRed(CardSuite.Diamonds))
      assert(!isRed(CardSuite.Christen))
      assert(!isRed(CardSuite.Spades))
    }
  }
}

