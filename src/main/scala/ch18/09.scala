package Ch18 {
  package Ex09 {
    abstract class Dim[T](val value: Double, name: String) {
      this: T => // указываем конкретный тип, а не любого из потомков
        protected def create(v: Double): T
        def + (other: Dim[T]) = create(value + other.value)
        override def toString: String = value + " " + name
    }

    class Seconds(v: Double) extends Dim[Seconds](v, "s") {
      override def create(v: Double): Seconds = new Seconds(v)
    }

    /*class Metres(v: Double) extends Dim[Metres](v, "m") {
      override def create(v: Double): Seconds = new Seconds(v)
    }*/
    class Metres(v: Double) extends Dim[Metres](v, "m") {
      override def create(v: Double): Metres = new Metres(v)
    }

    object Main extends App {
      /* Так теперь нельзя
      val s = new Seconds(30)
      val m = new Metres(10)
      val sum = s + m
      println(sum.toString)*/
      // Зато можно вот так:
      val s1 = new Seconds(30)
      val s2 = new Seconds(10)
      val sum = s1 + s2
      println(sum.toString)
    }
  }
}

