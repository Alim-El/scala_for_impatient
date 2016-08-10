import scala.reflect.BeanProperty

package Ch05 {
  package Ex05 {

    object Main extends App {

      class Student(@BeanProperty var name: String, @BeanProperty var id: String) {}

      var s = new Student("Petrov", "1")
      s.setName("Ivanov")
      assert(s.getName() == "Ivanov")
    }
  }
}


