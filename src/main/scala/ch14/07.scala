package Ch14 {
  package Ex07 {
    object Main extends App {
      sealed abstract class BinaryTree
      case class Leaf(value: Int) extends BinaryTree
      case class Node(leafs: BinaryTree*) extends BinaryTree

      def leafSum(t: BinaryTree): Int = t match {
        case Leaf(v) => v
        case Node(l @ _*) => l.map(leafSum(_)).sum
        case _ => 0
      }

      val t = Node(Node(Leaf(3), Leaf(4), Node(Leaf(2), Leaf(1), Leaf(5))), Node(Leaf(4), Leaf(7)))
      assert(leafSum(t) == 26)
    }
  }
}



