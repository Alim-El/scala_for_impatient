package Ch10 {
  package Ex07 {
    // Трейт "Животные"
    trait Animal {
      var IQ: Int                               // уровень интеллекта - абстрактное поле
      def says: String                          // абстрактный метод

    }

    trait Mammals extends Animal {
      val warmBloded = true       // признак теплокровности, конкретное поле
    }

    trait Dogs extends Mammals {
      val bites = true          // конкретное поле
      override def says: String = "bow-wow!"  // конкретный метод
    }

    trait Horse extends Mammals {
      val kick = true   // конкретное поле
      override def says: String = "neigh!"  //конкретный метод
    }

    trait Dogtaur extends Horse with Dogs  { // многоуровневый трейт
      val strange = true
    }

    object Main extends App {
      class Henry extends Dogtaur {
        var IQ = 100
        def stinks = true
      }
      val henry = new Henry
      assert(henry.strange) // догатавр получился странным существом
      println(henry.says)   // который лает
      assert(henry.kick)    // лягает
      assert(henry.bites)   // кусает
      assert(henry.stinks)  // и жутко воняет
    }
  }
}

