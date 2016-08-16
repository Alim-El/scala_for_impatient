import java.awt.Point

package Ch10 {
  package Ex02 {
    class OrderedPoint(x: Int, y: Int) extends Point(x, y) with scala.math.Ordered[java.awt.Point] {
      override def compare(other: java.awt.Point) = {
        if (getX() < other.getX() || (getX() == other.getX() && getY() < other.getY())) -1
        else if (getX() == other.getX() && getY() == other.getY()) 0
        else 1
      }
    }
    object Main extends App {
      var p  = new OrderedPoint(1, 2)

      var p1 = new OrderedPoint(1, 1)
      var p2 = new OrderedPoint(1, 2)
      var p3 = new OrderedPoint(1, 3)
      var p4 = new OrderedPoint(0, 2)
      var p5 = new OrderedPoint(2, 2)

      assert(p.compare(p1) == 1)
      assert(p.compare(p2) == 0)
      assert(p.compare(p3) == -1)
      assert(p.compare(p4) == 1)
      assert(p.compare(p5) == -1)

    }
  }
}

