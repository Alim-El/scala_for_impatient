package Ch18 {
  package Ex07 {
    class Window {
      def close(): Unit = {
        println("window is closed")
      }
    }

    object Main extends App {
      def closeAfterProcess[T <: {def close()}](obj: T, process: T => Unit) = {
        try {
          process(obj)
        } finally {
          obj.close()
        }
      }
      val w = new Window()
      def ventilateRoom(w: Window) = {
        println("Open the window for ventilate the room")
      }
      closeAfterProcess(w, ventilateRoom)
    }
  }
}

