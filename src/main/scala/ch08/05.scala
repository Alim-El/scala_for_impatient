package Ch08 {
  package Ex05 {
    class Point(val x: Double, val y: Double) {}
    object Point {
      def apply(x: Double, y: Double) = new Point(x, y)
    }
    class LabeledPoint(val label: String, override val x: Double, override val y: Double) extends Point(x, y) {}

    object Main extends App {
      var p = new LabeledPoint("Label", 1.0, 2.5)
    }
  }
}

