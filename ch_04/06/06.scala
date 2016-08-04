import java.util.Calendar._

object Main extends App {
 val daysOfTheWeek = scala.collection.mutable.LinkedHashMap(
   "MONDAY" -> java.util.Calendar.MONDAY,
   "TUESDAY" -> java.util.Calendar.TUESDAY,
   "WEDNESDAY" -> java.util.Calendar.WEDNESDAY,
   "THURSDAY" -> java.util.Calendar.THURSDAY,
   "FRIDAY" -> java.util.Calendar.FRIDAY,
   "SATURDAY" -> java.util.Calendar.SATURDAY,
   "SUNDAY" -> java.util.Calendar.SUNDAY
   )
  for(d <- daysOfTheWeek) println(d)
}


