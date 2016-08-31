package Ch14 {
  package Ex06 {
    object Main extends App {
      sealed abstract class BinaryTree
      case class Leaf(value: Int) extends BinaryTree
      case class Node(left: BinaryTree, right: BinaryTree) extends BinaryTree

      def leafSum(t: BinaryTree): Int = t match {
        case l: Leaf => l.value
        case n: Node => leafSum(n.left) + leafSum(n.right)
        case _ => 0
      }

      val t = Node(Node(Leaf(3), Node(Leaf(2), Leaf(1))), Node(Leaf(4), Leaf(7)))
      assert(leafSum(t) == 17)
    }
  }
}

