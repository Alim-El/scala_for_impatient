package Ch14 {
  package Ex04 {
    object Main extends App {
      abstract class Item
      case class Article(description: String, price: Double) extends Item
      case class Bundle(description: String, discount: Double, items: Item*) extends Item
      case class Multiple(quantity: Int, item: Item) extends Item

      def price(it: Item): Double = it match {
        case Article(_, p) => p
        case Bundle(_, disc, its @ _*) => its.map(price(_)).sum - disc
        case Multiple(q, i) => q * price(i)
      }

      val a1 = Article("Desc1", 10.5)
      val a2 = Article("Desc2", 1.5)
      val b = Bundle("B1", 2, a1, a2)
      val m = Multiple(3, b)
      assert(price(a1) == 10.5)
      assert(price(b) == 10.0)
      assert(price(m) == 30.0)
    }
  }
}

