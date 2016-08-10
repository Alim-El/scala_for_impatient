import scala.collection.JavaConverters.asScalaBufferConverter
import scala.collection.mutable.Buffer
import java.awt.datatransfer._

package Ch03 {
  package Ex10 {
    object Main extends App {
      val flavors = SystemFlavorMap.getDefaultFlavorMap.asInstanceOf[SystemFlavorMap]
      val buff: Buffer[String] = asScalaBufferConverter(flavors.getNativesForFlavor(DataFlavor.imageFlavor)).asScala
      buff.foreach(println)
    }

  }

}

