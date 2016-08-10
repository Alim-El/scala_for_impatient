import scala.io

package Ch02 {

  package Ex05 {

    object Main extends App {
      def countdown(n: Int): Unit = {
        for (i <- n to 0 by -1) println(i)
      }

      countdown(10)
    }

  }

}
