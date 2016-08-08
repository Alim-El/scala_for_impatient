object RGBCube extends Enumeration {
  type RGBCube = Value
  val White = Value(0xFFFFFF)
  val Cyan = Value(0x00FFFF)
  val Green = Value(0x00FF00)
  val Yellow = Value(0xFFFF00)
  val Red = Value(0xFF0000)
  val Magenta = Value(0xFF00FF)
  val Blue = Value(0x0000FF)
  val Black = Value(0x000000)
}

object Main extends App {
  for(rgb <- RGBCube.values) println(rgb.id  + ": " + rgb)
}



