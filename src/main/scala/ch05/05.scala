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
/*
C:\Maria\marty2002-git\scala_for_impatient\target\scala-2.10\classes\Ch05\Ex05>javap Main$Student.class
Compiled from "05.scala"
public class Ch05.Ex05.Main$Student {
  public java.lang.String name();
  public void name_$eq(java.lang.String);
  public void setName(java.lang.String);
  public java.lang.String id();
  public void id_$eq(java.lang.String);
  public void setId(java.lang.String);
  public java.lang.String getName();
  public java.lang.String getId();
  public Ch05.Ex05.Main$Student(java.lang.String, java.lang.String);
}
*/


