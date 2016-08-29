package Ch13 {
  package Ex01 {

    import scala.collection.SortedSet
    import scala.collection.mutable.LinkedHashMap

    object Main extends App {
      // LinkedHashMap обеспечит вывод элементов в порядке их добавления
      // SortedSet обеспечит вывод индексов в порядке возрастания
      def indexes(s: String): LinkedHashMap[Char, SortedSet[Int]] =
        s.zipWithIndex.foldLeft(LinkedHashMap[Char, SortedSet[Int]]())((res, el) =>
          res += (el._1 -> (res.getOrElse(el._1, SortedSet[Int]()) + el._2)))
      println(indexes("Mississippi").toString)
    }
  }
}

