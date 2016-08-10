import java.util.Scanner
import java.util.TreeMap

import scala.collection.mutable.ArrayBuffer
import scala.collection.JavaConversions.mapAsScalaMap
import scala.collection.mutable.Map

package Ch04 {
  package Ex05 {

    object Main extends App {
      var in = new java.util.Scanner(new java.io.File("C:\\11.txt"))
      val treeWordsCounter = new TreeMap[String, Int]()

      while (in.hasNext()) {
        var k = in.next()
        if (treeWordsCounter.contains(k)) treeWordsCounter(k) += 1 else treeWordsCounter(k) = 1
      }
      val wordsCount: Map[String, Int] = treeWordsCounter
      for ((k, v) <- wordsCount) printf("Word %s contains %d times\n", k, v)
    }

  }

}

