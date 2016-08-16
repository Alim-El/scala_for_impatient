package Ch10 {
  package Ex01 {
    trait RectangleLike extends java.awt.geom.RectangularShape{
      def translate(x: Int, y: Int) = {
        setFrame(getX() + x, getY() + y, getWidth(), getHeight())
      }
      def grow(x: Int, y: Int) = {
        setFrame(getX(), getY(), getWidth() + x, getHeight() + y)
      }
    }
    object Main extends App {
      val egg = new java.awt.geom.Ellipse2D.Double(5, 10, 20, 30) with RectangleLike
      egg.translate(2, 5)
      assert(egg.getBounds().getX() == 7)
      assert(egg.getBounds().getY() == 15)
      assert(egg.getBounds().getWidth() == 20)
      assert(egg.getBounds().getHeight() == 30)

      egg.grow(5, 10)
      assert(egg.getBounds().getX() == 7)
      assert(egg.getBounds().getY() == 15)
      assert(egg.getBounds().getWidth() == 25)
      assert(egg.getBounds().getHeight() == 40)
    }
  }
}
