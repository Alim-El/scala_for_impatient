package Ch11 {
  package Ex10 {

    object RichFile {
      def unapplySeq(s: String): Option[Seq[String]] = {
        if (s.trim == "") None else Some(s.split("""[\/|\\]""").filter(_ !=""))
      }
    }

    object Main extends App {
      // переменной s присваивается некая последовательность
      val RichFile(s @ _*) = """C:\\logs\\proxy-2016-06-24.log"""
      println(s.toString)
    }
  }
}



