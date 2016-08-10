import java.awt.Point
import java.awt.Dimension

package Ch08 {
  package Ex07 {
    class Rectangle(p: Point, w: Int) extends java.awt.Rectangle(p, new Dimension(w, w)) {
      def this(w: Int) {
        this(new Point(0, 0), w)
      }
      def this() {
        this(0)
      }

    }

    object Main extends App {
      var r1 = new Rectangle(new Point(1, 2), 4)
      var r2 = new Rectangle(4)
      var r3 = new Rectangle()
    }
  }
}


