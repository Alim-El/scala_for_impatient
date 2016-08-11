package Ch09 {
  package Ex08 {

    import scala.io.Source

    object Main extends App {
      val src = Source.fromFile("C:\\testFiles\\Ch09ex08.txt", "UTF-8")
      // <img.*\ssrc\s*=\s*"(.+)"
      //  <img      - начинается с img
      //  .*        - далее любойсимвол от 0 и более раз
      //  \s        - далее какой-нибудь пробельный символ
      //  src       - затем src
      //  \s*       - далее какой-нибудь пробельный символ от 0 и более раз
      //  =         - равно
      //  \s*       - далее какой-нибудь пробельный символ от 0 и более раз
      //  "         - кавычка
      // (.+)       - подвыражение, содержащее от 1 и более любых символов
      // "          - заканчивается "
      val pattern = """<img.*\ssrc\s*=\s*"(.+)"""".r
      for(pattern(s) <- pattern.findAllIn(src.mkString)) println(s)
      src.close
    }
  }
}



