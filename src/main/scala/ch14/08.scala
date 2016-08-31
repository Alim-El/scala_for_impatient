package Ch14 {
  package Ex08 {
    object Main extends App {

      sealed abstract class BinaryTree
      case class Leaf(value: Int) extends BinaryTree
      case class Node(op: Char, leafs: BinaryTree*) extends BinaryTree

      def eval(tree: BinaryTree): Int = tree match {
        case Leaf(v) => v
        case Node('+', t  @ _*)  => t.map(eval).sum
        case Node('*', t  @ _*)  => t.map(eval).product
        case Node('-', t  @ _*)  => t.map(eval).foldLeft(0)(_ - _)
        case _ => 0
      }

      val t = Node('+', Node('*', Leaf(3), Leaf(8)), Leaf(2), Node('-', Leaf(5)))
      assert(eval(t) == 21)

    }
  }
}

