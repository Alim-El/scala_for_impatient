package Ch11 {
  package Ex08 {
    class Matrix(items: Array[Array[Int]]) {
      private val height = items.length
      private val width = items.map(_.length).max
      private val rows = items.map(x => {
        for (i <- 0 until width) yield x.isDefinedAt(i) match {
          case true => x(i)
          case _ => 0
        }
      })
      def mat(row: Int, col: Int) = rows(row)(col)

      def + (other: Matrix): Matrix = {
        if (height != other.height || width != other.width)
          throw new IllegalArgumentException("Сложение применимо только к матрицам одинаковой размерности!")
        val res: Array[Array[Int]] =
          (0 until height).map(i => (0 until width).map(j =>
            rows(i)(j) + other.rows(i)(j)).toArray).toArray
        Matrix(res)
      }

      def * (n: Int): Matrix = {
        val res: Array[Array[Int]] =
          (0 until height).map(i => (0 until width).map(j => rows(i)(j) * n).toArray).toArray
        Matrix(res)
      }

      def * (other: Matrix): Matrix  = {
        // Перемножать можно те матрицы, у которых количество столбцов первого сомножителя
        // равно числу строк второго сомножителя.
        if (width != other.height)
          throw new IllegalArgumentException("Количество столбцов первого сомножителя должно быть равно числу строк второго сомножителя!")
        // Формула перемножения матриц A => (l*m) и B => (m*n)
        // C = A*B => (l*n)
        // c(i)(j) = sum(a(i)(r)*b(r)(j)), где r <- 0 until m
        // В нашем случае, l = height, m = width = other.height, n = other.width
        val res = (0 until height).map(i => (0 until other.width).map(j => ({
          (0 until width).map(r => rows(i)(r) * other.rows(r)(j)).sum
        })).toArray).toArray
        Matrix(res)
      }

      def == (other: Matrix): Boolean = {
        if (height != other.height || width != other.width)
          throw new IllegalArgumentException("Сложение применимо только к матрицам одинаковой размерности!")
        var res = true
        (0 until height).map(i => (0 until width).map(
          j => if (rows(i)(j) != other.rows(i)(j)) res = false
        ))
        res
      }

      override def toString: String = rows.map(r => r.mkString(", ")).mkString("\r\n")
    }
    
    object Matrix {
      def apply(items: Array[Array[Int]]): Matrix = new Matrix(items)
    }
    object Main extends App {
      val m1 = Matrix(Array(Array(1), Array(2, 3), Array(4, 5, 6)))
      val m2 = Matrix(Array(Array(2), Array(3, 4), Array(5, 6, 7)))
      assert(m1 + m2 == Matrix(Array(Array(3), Array(5, 7), Array(9, 11, 13))))
      assert(m1 * 2 == Matrix(Array(Array(2), Array(4, 6), Array(8, 10, 12))))
      val m3 = Matrix(Array(Array(1, 2, 3), Array(4, 5, 6)))
      val m4 = Matrix(Array(Array(1, 2, 3, 4), Array(5, 6, 7, 8), Array(9, 10, 11, 12)))
      assert(m3*m4 == Matrix(Array(Array(38, 44, 50, 56), Array(83, 98, 113, 128))))
    }
  }
}
