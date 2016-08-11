package Ch09 {
  package Ex05 {
    object Main extends App {
      var out = new java.io.PrintWriter("C:\\testFiles\\Ch09ex05.txt", "UTF-8")
      for (i <- 1 to 20) {
        out.println(math.pow(2, i).toString() +
                    " " * (16 - math.pow(2, i).toString().length) + // таким образом вычисляем место начала следующего столбца
                    math.pow(2, -i).toString())
      }
      out.close()
    }
  }
}

