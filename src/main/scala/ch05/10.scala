package Ch05 {
  package Ex10 {

    object Main extends App {
      class Employee(private val name: String = "John Q. Public", private var salary: Double = 0.0) {}
      var e = new Employee("Jane", 1000.0)
    }

  }
}

