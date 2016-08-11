import java.io.File

package Ch09 {
  package Ex09 {
    object Main extends App {
      def subdirs(dir: File): Iterator[File] = {
        val children = dir.listFiles.filter(_.isDirectory)
        children.toIterator ++ children.toIterator.flatMap(subdirs(_))
      }
      // .*(.class)\b - в начале - что угодно, заканчивается сочетанием .class
      val pattern = """(.class)\b""".r
      var count = 0

      for(dir <- subdirs(new File("C:\\testFiles\\"))) {
        count += dir.listFiles
          .filter(_.isFile)
          .filter((file: File) => file.getName().matches(".*(.class)\\b"))
          .length
      }
      println("Count = " + count.toString)
    }
  }
}

