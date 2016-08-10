package Ch02 {

  package Ex01 {

    object Main extends App {
      def signum(i: Int): Int = {
        if (i > 0) 1
        else if (i == 0) 0
        else -1
      }

      assert(signum(-9) == -1)
      assert(signum(0) == 0)
      assert(signum(9) == 1)
    }

  }

}
