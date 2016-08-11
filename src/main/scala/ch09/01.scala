import scala.io.Source
import java.io.PrintWriter

package Ch09 {
  package Ex01 {
    object Main extends App {
      val src = Source.fromFile("C:\\testFiles\\Ch09ex01.txt", "UTF-8")
      var lines = src.getLines.toArray.reverse
      src.close()
      var out = new PrintWriter("C:\\testFiles\\Ch09ex01reverse.txt", "UTF-8")
      for(line <- lines) out.println(line)
      out.close()
    }
  }
}

