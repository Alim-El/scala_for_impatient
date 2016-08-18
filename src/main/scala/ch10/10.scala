package Ch10 {
  package Ex10 {

    class InputStreamIterator(is: java.io.InputStream) extends Iterable[Byte] {
      override def iterator: Iterator[Byte] = new Iterator[Byte]{
        override def hasNext: Boolean = is.available() > 0
        override def next: Byte = is.read().toByte
      }
    }

    object Main extends App {
      val isi = new InputStreamIterator(new java.io.FileInputStream("C:\\testFiles\\Ch10ex08.txt"))
      val r = isi.iterator.map(_.toChar).mkString
    }
  }
}