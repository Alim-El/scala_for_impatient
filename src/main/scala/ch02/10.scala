import scala.math.pow

package Ch02 {

  package Ex10 {

    object Main extends App {
      def powX(x: Double, n: Int): Double = {
        if (n % 2 == 0 && n > 0) pow(pow(x, n / 2), 2)
        else if (n > 0 && n % 2 != 0) x * pow(x, n - 1)
        else if (n < 0) 1 / pow(x, -n)
        else 1
      }

      assert(powX(5, 2) == 25)
      assert(powX(5, -2) == 0.04)
      assert(powX(5, 0) == 1)
    }

  }

}
