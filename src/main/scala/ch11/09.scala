package Ch11 {
  package Ex09 {

    object RichFile {
      def unapply(s: String): Option[(String, String, String)] = {
        // (.*[\/\\])*(.+)[.]([^.]+)
        // (        - группируем
        // .*       - любое количество любых знаков
        // [\/ \\]  - заканчивающееся \ или /
        // *        - любое количество раз
        // )        - закончилась группа пути
        // (.+)[.]  - группа имени файла - от 1 до бесконечности любых символов заканчивается точкой
        // ([^.]+)  - группа расширения - любые символы кроме точки от одного до бесконечности
        val r = """(.*[\/\\])*(.+)[.]([^.]+)""".r
        val r(p, n, e) = s
        Some(p, n, e)
      }
    }

    object Main extends App {
      val RichFile(path, name, extension) = """C:\\logs\\proxy-2016-06-24.log"""
      assert(path == """C:\\logs\\""")
      assert(name == "proxy-2016-06-24")
      assert(extension == "log")
    }
  }
}

