import scala.collection.immutable.StringOps

object Main extends App {
	def productS(s: collection.immutable.StringOps): Long = {
    var res: Long = 1L
    for(i <- s) res *= i.toLong
    res
  }
  assert(productS("Hello") == 9415087488L)
}
