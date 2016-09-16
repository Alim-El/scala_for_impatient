package Ch18 {
  package Ex02 {
    object show
    object then
    object around

    class Bug {
      var pos: Int = 0
      var goForward: Boolean = true

      def turn(obj: around.type) = {
        goForward = !goForward
        this
      }
      def move(steps: Int) = {
        pos = if (goForward) pos + steps else pos - steps
        this
      }
      def showPos = {
        println(pos.toString)
        this
      }

      def and(obj: show.type) = this.showPos
      def and(obj: then.type) = this
    }

    object Main extends App {
      val bugsy = new Bug
      bugsy move 4 and show and then move 6 and show turn around move 5 and show
    }
  }
}

