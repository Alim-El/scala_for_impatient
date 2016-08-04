import scala.io 
object Main extends App {
	def countdown(n: Int): Unit = {
    for(i <- n to 0 by -1) println(i)
  }
  countdown(10)
}
