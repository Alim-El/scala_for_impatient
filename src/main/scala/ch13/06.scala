package Ch13 {
  package Ex06 {
    object Main extends App {
      val lst = List[Int](1, 2, 3, 4)
      // def :\[B](z: B)(op: (A, B) => B): B = foldRight(z)(op)
      println((lst :\ List[Int]())(_ :: _).reverse.toString)
      // def /:[B](z: B)(op: (B, A) => B): B = foldLeft(z)(op)
      println((List[Int]() /: lst )(_ :+ _).reverse.toString)
    }
  }
}

