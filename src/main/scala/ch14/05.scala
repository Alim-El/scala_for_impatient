package Ch14 {
  package Ex05 {
    object Main extends App {
      def leafSum(l: List[Any]): Int = l.map({
        case l: List[Any] => leafSum(l)
        case i: Int => i
        case _ => 0
      }).sum
      assert(leafSum(List(List(3, 8), 2, List(5), "ewrwer")) == 18)
    }
  }
}

