package Ch18 {
  package Ex01 {
    class Bug {
      var pos: Int = 0
      var goForward: Boolean = true
      def turn() = {
        goForward = !goForward
        this
      }
      def move(steps: Int) = {
        pos = if (goForward) pos + steps else pos - steps
        this
      }
      def show() = {
        println(pos.toString)
        this
      }
    }

    object Main extends App {
      val bugsy = new Bug
      bugsy.move(4).show().move(6).show().turn().move(5).show()
    }
  }
}

