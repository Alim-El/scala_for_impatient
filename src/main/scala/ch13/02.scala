package Ch13 {
  package Ex02 {

    import scala.collection.immutable.Set
    import scala.collection.immutable.HashMap

    object Main extends App {
      def indexes(s: String): HashMap[Char, Set[Int]] =
        s.zipWithIndex.foldLeft(HashMap[Char, Set[Int]]())((res, el) =>
          res + (el._1 -> (res.getOrElse(el._1, Set[Int]()) + el._2)))
      println(indexes("Mississippi").toString)
    }
  }
}

