package Ch13 {
  package Ex04 {
    object Main extends App {
      def zipWithLength(coll: scala.collection.Traversable[String], m: Map[String, Int]) = coll.flatMap(m.get(_))

      val coll = Array("Tom", "Max", "Janis")
      val m = Map("Tom" -> 3, "Xander" -> 6, "Alex" -> 4, "Janis" ->5)
      assert(zipWithLength(coll, m).toArray.deep == Array(3, 5).deep)
    }
  }
}

