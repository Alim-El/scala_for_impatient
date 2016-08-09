import scala.collection.mutable.ArrayBuffer

package Ch08 {
  package Ex04 {
    abstract class Item {
      def price: Double
      def description: String
    }

    class SimpleItem(override val price: Double, override val description: String) extends Item {}
    class Bundle {
      var items: ArrayBuffer[SimpleItem] = new ArrayBuffer[SimpleItem]()

      def addItem(item: SimpleItem) = {
        items += item
      }

      def price: Double = {
        items.foldLeft(0.0)(_ + _.price)
      }

      def description: String = {
        items.map(_.description).mkString(", ")
      }
    }
    object Main extends App {
      var b = new Bundle()
      b.addItem(new SimpleItem(1.0, "first"))
      b.addItem(new SimpleItem(2.0, "second"))
      b.addItem(new SimpleItem(3.0, "third"))

      assert(b.price == 6.0)
      assert(b.description == "first, second, third")
    }
  }
}


