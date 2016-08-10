import scala.collection.immutable.StringOps


package Ch02 {

  package Ex09 {

    object Main extends App {
      def productS(s: collection.immutable.StringOps): Long = {
        if (s.length == 0) 1
        else s.head * productS(s.tail)
      }

      assert(productS("Hello") == 9415087488L)
    }

  }

}
