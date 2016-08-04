import scala.collection.immutable.StringOps

object Main extends App {
	def productS(s: collection.immutable.StringOps): Long = {
    s.foldLeft(1L)(_ * _)
  }
  assert(productS("Hello") == 9415087488L)
}
