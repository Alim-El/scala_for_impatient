package Ch18 {
  package Ex06 {

    import scala.collection.SortedSet

    object Main extends App {
      def getValueIndex(set: SortedSet[Int], value: Int): Either[Int, Int] = {
        set.zipWithIndex.collectFirst({
          case (`value`, i) => Right(i)
          case (x, i) if (x > value) => Left(i)
        }).getOrElse(Left(set.size - 1))
      }

      assert(getValueIndex(SortedSet(1, 2, 3, 4, 5, 6, 7), 4) == Right(3))
      assert(getValueIndex(SortedSet(1, 2, 3, 5, 6, 7), 4) == Left(3))
      assert(getValueIndex(SortedSet(1, 2, 3, 5, 6, 7), 9) == Left(5))
    }
  }
}

