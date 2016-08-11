import java.io._

package Ch09 {
  package Ex10 {
    @SerialVersionUID(42L) class Person(val name: String) extends Serializable {
      private val friends = new collection.mutable.ArrayBuffer[Person]
      def addFriend(p: Person) {friends += p}
      def isFriendOf(p: Person) = friends.contains(p)
    }

    object Main extends App {
      val kirill = new Person("Kirill")
      val mary = new Person("Mary")
      val dmitry = new Person("Dmitry")

      kirill.addFriend(mary)
      kirill.addFriend(dmitry)
      mary.addFriend(kirill)
      val persons = Array(kirill, mary, dmitry)

      val out = new ObjectOutputStream(new FileOutputStream("C:\\testFiles\\Ch09ex10.obj"))
      out.writeObject(persons)
      out.close

      val in = new ObjectInputStream(new FileInputStream("C:\\testFiles\\Ch09ex10.obj"))
      val Array(newKirill, newMary, newDmitry) = in.readObject().asInstanceOf[Array[Person]]
      in.close

      assert(newKirill.isFriendOf(newMary) == true)
      assert(newKirill.isFriendOf(newDmitry) == true)
      assert(newMary.isFriendOf(newDmitry) == false)
    }
  }
}

