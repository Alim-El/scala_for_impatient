import scala.collection.immutable.StringOps

object Main extends App {
  java.util.TimeZone.getAvailableIDs()
    .filter(_.startsWith("America/"))
    .map(_.stripPrefix("America/"))
    .sorted
    .foreach(println(_))
}

