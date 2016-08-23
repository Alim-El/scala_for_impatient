package Ch11 {
  package Ex04 {
    class Money(d: Int, c: Int = 0) {
      private val dollars: Int = (d * 100 + c) / 100
      private val cents: Int = (d * 100 + c) % 100

      private def toCents: Int = dollars * 100 + cents

      override def toString: String = "$" + dollars + "." + (if (cents < 10) "0" + cents else cents)

      def + (other: Money): Money = new Money(dollars + other.dollars, cents + other.cents)
      def - (other: Money): Money = new Money(dollars - other.dollars, cents - other.cents)
      def == (other: Money): Boolean = (dollars == other.dollars) && (cents == other.cents)
      def * (n: Int): Money = new Money(dollars * n, cents * n)
      def / (n: Int): Money = new Money(0, toCents / n) // тут еще можно было заморочится с округлением, но я не стала
      // реализовывать методы * и / применительно к двум объектам класса Money смысла не имеет,
      // т.к. нет смысла делить и умножать деньги на деньги
    }

    object Money {
      def apply(d: Int, c: Int = 0): Money = new Money(d, c)
    }
    object Main extends App {
      val a = Money(50, 308)
      assert(a == Money(53, 8))
      val b = Money(1, 26)
      assert(a + b == Money(54, 34))
      assert(a - b == Money(51, 82))
      assert(a * 2 == Money(106, 16))
      assert((Money(0, 15) / 2 == Money(0, 7)))
    }
  }
}

