package Ch05 {
  package Ex06 {
    object Main extends App {
      class Person(private var age: Int) {
        if (age < 0) age = 0

        def getAge() = age
      }

      var p = new Person(-9)
      assert(p.getAge() == 0)
    }
  }
}




