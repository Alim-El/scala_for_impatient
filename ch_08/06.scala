import Ch08.Ex05.Point

package Ch08 {
  package Ex06 {
    abstract class Shape {
      def centerPoint: Point
    }

    class Rectangle(lowerLeft: Point, width: Double, height: Double) extends Shape {
      override def centerPoint: Point = {
        Point( (lowerLeft.x + width)/2, (lowerLeft.y + height)/2 )
      }
    }

    class Circle(override val centerPoint: Point, radius: Double) extends Shape{}

    object Main extends App {
      var rectangle = new Rectangle(Point(1.0, 2.5), 4.0, 3.0)
      assert(rectangle.centerPoint.x == 2.5)
      assert(rectangle.centerPoint.y == 2.75)

      var circle = new Circle(Point(3.5, 5.0), 2.25)
      assert(circle.centerPoint.x == 3.5)
      assert(circle.centerPoint.y == 5.0)
    }
  }
}

