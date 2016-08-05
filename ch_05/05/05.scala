import scala.reflect.BeanProperty

object Main extends App {
  class Student(@BeanProperty var name: String, @BeanProperty var id: String) {}
  var s = new Student("Petrov", "1")
  s.setName("Ivanov")
  assert(s.getName() == "Ivanov")
}


