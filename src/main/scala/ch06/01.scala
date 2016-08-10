import scala.math.BigDecimal

package Ch08 {
  package Ex01 {

    object Conversions {
      def inchesToCentimeters(inch: Double): Double = {
        BigDecimal(inch * 2.54).setScale(3, math.BigDecimal.RoundingMode.UP).doubleValue()
      }

      def gallonsToLiters(gals: Double): Double = {
        BigDecimal(gals * 3.78541).setScale(3, math.BigDecimal.RoundingMode.UP).doubleValue()
      }

      def milesToKilometers(miles: Double): Double = {
        BigDecimal(miles * 1.60934).setScale(3, math.BigDecimal.RoundingMode.UP).doubleValue()
      }
    }

    object Main extends App {
      assert(Conversions.inchesToCentimeters(3.5) == 8.89)
      assert(Conversions.gallonsToLiters(3.5) == 13.249)
      assert(Conversions.milesToKilometers(3.5) == 5.633)
    }

  }

}

