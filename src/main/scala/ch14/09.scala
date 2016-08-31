package Ch14 {
  package Ex09 {
    object Main extends App {
      def sumOption(l: List[Option[Int]]) = l.flatMap(x => x).sum

      val l = List(Some(3), None, Some(5))
      assert(sumOption(l) == 8)
    }
  }
}

