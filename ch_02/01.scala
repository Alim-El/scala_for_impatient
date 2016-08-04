import java.util
import scala.io
import scala.BigInt
import scala.collection.mutable.ArrayBuffer
import scala.math.pow
import scala.collection.immutable.StringOps
import scala.collection.JavaConversions.asScalaBuffer
import scala.collection.mutable.Buffer
import java.awt.datatransfer._



object Main extends App {
  def signum(i: Int): Int = {
    if (i > 0) 1
    else if (i == 0) 0
    else -1
  }
  val num: Int = readInt()
  printf("Signum of %d is %d", num, signum(num))
}
