import scala.math.BigDecimal

abstract class Conversions {
  def convert(v: Double): Double
}

object InchesToCentimeters extends Conversions {
  override def convert(inch: Double): Double = {
    BigDecimal(inch * 2.54).setScale(3, math.BigDecimal.RoundingMode.UP).doubleValue()
  }
}

object GallonsToLiters extends Conversions {
  override def convert(gals: Double): Double = {
    BigDecimal(gals * 3.78541).setScale(3, math.BigDecimal.RoundingMode.UP).doubleValue()
  }
}

object MilesToKilometers extends Conversions {
  override def convert(miles: Double): Double = {
    BigDecimal(miles * 1.60934).setScale(3, math.BigDecimal.RoundingMode.UP).doubleValue()
  }
}

object Main extends App {
  assert(InchesToCentimeters.convert(3.5) == 8.89)
  assert(GallonsToLiters.convert(3.5) == 13.249)
  assert(MilesToKilometers.convert(3.5) == 5.633)
}

