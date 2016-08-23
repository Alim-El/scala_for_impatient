package Ch12 {
  package Ex01 {
    object Main extends App {
      // До примера в задании выглядит все так, будто функция должна возвращать коллекцию Int
      // А в примере - коллекция пар (Int, Int)
      // Решила сделать две функции
      def values(fun: (Int) => Int, low: Int, high: Int) = (low to high).map(fun)
      def valuesTuples(fun: (Int) => Int, low: Int, high: Int) =
        (low to high).map(x => Tuple2(x, fun(x)))
      assert(values(x => x*x, -1, 3).toArray.deep == Array(1, 0, 1, 4, 9).deep)
      assert(valuesTuples(x => x*x, -1, 3).toArray.deep == Array((-1,1), (0,0), (1,1), (2,4), (3,9)).deep)
    }
  }
}

