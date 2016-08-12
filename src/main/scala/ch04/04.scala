import java.util.Scanner
import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

package Ch04 {
  package Ex04 {

    object Main extends App {
      var in = new java.util.Scanner(new java.io.File("C:\\testFiles\\Ch04ex02.txt"))

      var words = ArrayBuffer[String]()
      while (in.hasNext()) words += in.next()

      var wordsCount = new scala.collection.immutable.TreeMap[String, Int]
      for (word <- words.distinct) wordsCount = wordsCount + (word -> words.count(_ == word))

      for ((k, v) <- wordsCount) printf("Word %s contains %d times\n", k, v)

    }

  }

}




