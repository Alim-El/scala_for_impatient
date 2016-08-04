object Main extends App {
  var goods = Map("zero" -> 1, "one" -> 10, "two" -> 100, "three" -> 1000)
  var sale = for((k, v) <- goods) yield (k, v*0.9)
  println(goods.mkString(", "))
  println(sale.mkString(", "))
}


