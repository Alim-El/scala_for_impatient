package Ch14 {
  package Ex03 {
    object Main extends App {
      def swap(arr: Array[Int]): Array[Int] = arr match {
        case Array(x, y) => Array(y, x)
        case Array(x, y, t @ _*) => Array((y +: x +: t):_*) // преобразуем элементы в последовательность и из нее сделаем массив
        case i => i
      }

      assert(swap(Array(6, 3, 8)).deep == Array(3, 6, 8).deep)
      assert(swap(Array(6, 3)).deep == Array(3, 6).deep)
      assert(swap(Array(6)).deep == Array(6).deep)
    }
  }
}

