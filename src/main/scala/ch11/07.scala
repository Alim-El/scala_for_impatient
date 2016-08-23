package Ch11 {
  package Ex07 {
    class BitSequence(var bits: Long = 0) {
      def apply(index:Byte):Boolean = (bits & (1 << index)) > 0
      def update(index:Byte, value:Boolean) {
        if (value)
          bits |= (1 << index)
        else
          bits &= ~(1 << index)
      }
    }
    object Main extends App {
      val bs = new BitSequence(5) // 101
      assert(bs(0) == true)
      assert(bs(1) == false)
      assert(bs(2) == true)
      assert(bs(3) == false)
      bs(3) = true                // 1010 == 13
      assert(bs.bits == 13)
    }
  }
}

