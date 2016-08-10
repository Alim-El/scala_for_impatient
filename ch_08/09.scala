package Ch08 {
  package Ex09 {
    class Creature {
      def range: Int = 10
      val env: Array[Int] = new Array[Int](range)
    }

    class Creature1 extends Creature {
      override def range = 3
    }
    class Creature2 extends Creature {
      override val range = 4
    }

    object Main extends App {
      assert(new Creature1().env.size == 3)
      assert(new Creature2().env.size == 0)
    }
  }

}

