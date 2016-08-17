package Ch10 {
  package Ex04 {

    /*
    Алгоритм Цезаря
    Шифрование:
          y = (x + k) % n
    Дешифрование:
          x = (y - k + n) % n
      , где y - зашифрованный символ
            x - символ открытого текста
            k - ключ шифра (смещение)
            n - мощность множества (т.е. количество символов в алфавите)
    */
    // вообще трейт depricated, но раз уж задача требует...
    class CryproLogger(private val key: Int = 3) extends scala.util.logging.ConsoleLogger {
      private val cyrillic = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя"
      private val latin = "abcdefghijklmnopqrstuvwxyz"
      private val numbers = "0123456789"

      // зашифровать символ алфавита
      private def caesar(x: Char, alphabet: String): Char = {
        // индекс зашифрованного элемента в алфавите
        //    (индекс_X + k) % n
        val index = (alphabet.indexOf(x.toLower) + key) % alphabet.length
        // Если индекс отрицательный, то смещаем символ влево относительно конца алфавита,
        // если положительный - вправо относително начала алфавита
        val res = if (index < 0) alphabet.charAt(alphabet.length + index)
        else alphabet.charAt(index)
        if (x.isUpper) res.toUpper
        else res
      }

      // расшифровать символ алфавита
      private def decaesar(y: Char, alphabet: String): Char = {
        // Индекс расшифрованного символа в алфавите:
        //    (индекс_Y - k + n) % n
        val index = (alphabet.indexOf(y.toLower) - key + alphabet.length) % alphabet.length
        // Если индекс отрицательный, то смещаем символ влево относительно конца алфавита,
        // если положительный - вправо относително начала алфавита
        val res = if (index < 0) alphabet.charAt(alphabet.length + index)
        else alphabet.charAt(index)
        // Если символ был в верхнем регистре - преобразуем его
        if (y.isUpper) res.toUpper
        else res
      }

      // зашифровать строку
      def encrypt(msg: String): String =
      msg.map {
        case x if cyrillic.contains(x.toLower) => caesar(x, cyrillic)
        case x if latin.contains(x.toLower) => caesar(x, latin)
        case x if numbers.contains(x.toLower) => caesar(x, numbers)
        case x => x
      }
      // расшировать строку
      def decrypt(msg: String): String =
      msg.map {
        case y if cyrillic.contains(y.toLower) => decaesar(y, cyrillic)
        case y if latin.contains(y.toLower) => decaesar(y, latin)
        case y if numbers.contains(y.toLower) => decaesar(y, numbers)
        case y => y
      }
      // зашифрованное логирование
      override def log(msg: String) = super.log(encrypt(msg))
    }

    object Main extends App {
      val cl = new CryproLogger()
      assert(cl.encrypt("az/AZ.ая/АЯ.09") == "dc/DC.гв/ГВ.32")
      assert(cl.decrypt("dc/DC.гв/ГВ.32") == "az/AZ.ая/АЯ.09")
      cl.log("az/AZ.ая/АЯ.09")

      val cl_minus3 = new CryproLogger(-3)
      assert(cl_minus3.encrypt("az/AZ.ая/АЯ.09") == "xw/XW.эь/ЭЬ.76")
      assert(cl_minus3.decrypt("xw/XW.эь/ЭЬ.76") == "az/AZ.ая/АЯ.09")
      cl_minus3.log("az/AZ.ая/АЯ.09")
    }
  }
}
