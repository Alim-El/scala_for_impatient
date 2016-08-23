package Ch11 {
  package Ex03 {

    class Fraction(n: Int, d: Int) {
      private val num: Int = if (d == 0) 1 else n * sign(d) / gcd(n, d)
      private val den: Int = if (d == 0) 0 else d * sign(d) / gcd(n, d)

      private def sign(a: Int) = if (a > 0) 1 else if (a < 0) -1 else 0
      private def abs(a: Int): Int = if (a > 0) a else -a
      private def gcd(a: Int, b: Int): Int = if (b == 0) abs(a) else gcd(b, a % b) // НОД
      private def lcm(a: Int, b: Int): Int = abs(a * b) / gcd(a, b) // НОК

      override def toString: String = num + "/" + den

      def == (other: Fraction): Boolean = (num == other.num) && (den == other.den)
      def + (other: Fraction): Fraction = {
        val l = lcm(den, other.den)
        new Fraction(num * (l / den) + other.num * (l / other.den), l)
      }
      def - (other: Fraction): Fraction = {
        val l = lcm(den, other.den)
        new Fraction(num * (l / den) - other.num * (l / other.den), l)
      }
      def * (other: Fraction): Fraction = new Fraction(num * other.num, den * other.den)
      def / (other: Fraction): Fraction = this * new Fraction(other.den, other.num)
    }
  }

  object Fraction {
    def apply(n: Int, d: Int) = new Ch11.Ex03.Fraction(n, d)
  }

  object Main extends App {
    val a = Fraction(3, 6)
    assert(a == Fraction(1, 2))
    val b = Fraction(8, 15)
    assert(a + b == Fraction(31, 30))
    assert(a - b == Fraction(-1, 30))
    assert(a * b == Fraction(8, 30))
    assert(a / b == Fraction(15, 16))
  }

}


