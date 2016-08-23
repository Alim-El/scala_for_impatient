package Ch11 {
  package Ex05 {

    import scala.collection.mutable.ArrayBuffer

    class Table() {
      // каждая строка - это массив ячеек
      private val rows = new ArrayBuffer[ArrayBuffer[String]]()

      // Добавление столбца.
      // Если строк еще нет - первую строку нужно тоже создать и уже в нее положить ячейку
      // Иначе - укладываем ячейку в последнюю строку
      def | (str: String) = {
        if (rows.length == 0) rows += (new ArrayBuffer[String]() += str)
        else rows(rows.length - 1) += str
        this
      }
      // Добавляем новую строку в таблицы
      def || (str: String) = {
        rows += (new ArrayBuffer[String]() += str)
        this
      }

      override def toString: String =
        "<table>" +
          rows.map(
            "<tr>" + _.map("<td>" + _ + "</td>").mkString + "</tr>").mkString + "</table>"
    }

    object Table {
      def apply(): Table = new Table()
    }

    object Main extends App {
      val t = Table() | "Java" | "Scala" || "Gosling" | "Odersky" || "JVM" | "JVM,.NET"
      println(t.toString)
    }
  }
}

