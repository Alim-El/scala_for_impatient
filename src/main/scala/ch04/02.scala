import java.util.Scanner
import scala.collection.mutable

package Ch04 {
  package Ex02 {

    object Main extends App {
      var in = new java.util.Scanner(new java.io.File("C:\\11.txt"))
      var words = new mutable.HashMap[String, Int]()
      while (in.hasNext()) {
        var k = in.next()
        words(k) = words.getOrElse(k, 0) + 1
      }
      for ((k, v) <- words) printf("Word %s contains %d times\n", k, v)
    }

  }

}

