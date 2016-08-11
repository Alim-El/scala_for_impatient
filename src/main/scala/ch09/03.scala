package Ch09 {
  package Ex03 {

    import scala.io.Source

    object Main extends App {
      val src = Source.fromFile("C:\\testFiles\\Ch09ex03.txt", "UTF-8")
      src.mkString.split("\\s+").toArray.filter(_.length >= 12).map(println(_))
      src.close()
    }
  }
}

