package Ch09 {
  package Ex06 {

    import scala.io.Source

    object Main extends App {
      val src = Source.fromFile("C:\\testFiles\\Ch09ex06.txt", "UTF-8")
      // "([^\\"]|\\\\|\\")*"
      // "            - начинается с кавычки
      // (            - посредине вот эта группа...
      //    [^\\"]        - внутри группы не может содержаться \ или "
      //    |
      //    \\\\          - может содержаться \\
      //    |
      //    \\"           - может содержаться \"
      // )*           - повторяется сколько угодно раз
      // "            - заканчивается кавычкой
      var pattern = """"([^\\"]|\\\\|\\")*"""".r
      pattern.findAllIn(src.mkString).toArray.map(println(_))
      src.close
    }
  }
}
