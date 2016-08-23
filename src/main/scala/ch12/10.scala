package Ch12 {
  package Ex10 {
    object Main extends App {
      def unless(condition: => Boolean)(block: => Unit): Unit = if (!condition) block
      val isSummer = false
      var putOnAHat = false
      // Если не лето - надень шапку
      unless (isSummer) {
        putOnAHat = true
      }
      assert(putOnAHat)
    }
  }
}

