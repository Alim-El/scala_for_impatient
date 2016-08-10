package Ch05 {
  package Ex04 {

    object Main extends App {

      class Time(hrs: Int, mns: Int) {
        if (hrs < 0 || hrs > 24)
          throw new IllegalArgumentException("Hours value must be from 0 to 24.")
        if (mns < 0 || mns > 60)
          throw new IllegalArgumentException("Minutes value must be from 0 to 60.")

        private val time = 60 * hrs + mns

        def before(other: Time): Boolean = {
          time < other.time
        }
      }


      val time1 = new Time(21, 15)
      val time2 = new Time(20, 20)
      assert(time2.before(time1) == true)
      val time3 = new Time(21, 10)
      assert(time3.before(time1) == true)
      val time4 = new Time(21, 15)
      assert(time4.before(time1) == false)
      val time5 = new Time(21, 20)
      assert(time5.before(time1) == false)
    }
  }
}
