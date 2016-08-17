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
    // Тут лежит решение, основанное только на таблице ASCII, а кириллица лежит отдельно в строке
    // тоже имеет право на существование, но потом я подумала, и решила, что раз уж использую алфавит в строке,
    // то логичнее использовать все три алфавита в строке
    // вообще трейт depricated, но раз уж задача требует...
    /*class CryproLogger(private val key: Int = 3) extends scala.util.logging.ConsoleLogger {
      private val cyrillic = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя"

      // зашифровать символ Кириллицы
      // Кириллица в таблице ASCII лежит вразброс, потому делаем через йоптвоюмать
      private def caesarCyrillic(x: Char): Char = {
        // индекс зашифрованного элемента в алфавите
        //    (индекс_X + k) % n
        val index = (cyrillic.indexOf(x.toLower) + key) % cyrillic.length
        // Если индекс отрицательный, то смещаем символ влево относительно конца алфавита,
        // если положительный - вправо относително начала алфавита
        val res = if (index < 0) cyrillic.charAt(cyrillic.length + index)
                  else cyrillic.charAt(index)
        if (x.isUpper) res.toUpper
        else res
      }

      // зашифровать символ латиницы или цифры по таблице ASCII
      private def caesar(x: Char, startChar: Char, n: Int): Char = {
        // Индекс открытого символа в алфавите:
        //    индекс_X = (ascii_код_X - ascii_код_начала_алфавита)
        // Индекс зашифрованного символа в алфавите
        //    (индекс_X + k) % n
        val index = (x.toLower - startChar + key) % n
        // Если индекс отрицательный, то смещаем символ влево относительно конца алфавита,
        // если положительный - вправо относително начала алфавита
        val res = if (index < 0) (startChar + n + index).toChar else (startChar + index).toChar
        // Если символ был в верхнем регистре - преобразуем его
        if (x.isUpper) res.toUpper
        else res
      }

      // расшифровать символ Кириллицы
      // Кириллица в таблице ASCII лежит вразброс, потому делаем через йоптвоюмать
      private def decaesarCyrillic(y: Char): Char = {
        // Индекс расшифрованного символа в алфавите:
        //    (индекс_Y - k + n) % n
        val index = (cyrillic.indexOf(y.toLower) - key + cyrillic.length) % cyrillic.length
        // Если индекс отрицательный, то смещаем символ влево относительно конца алфавита,
        // если положительный - вправо относително начала алфавита
        val res = if (index < 0) cyrillic.charAt(cyrillic.length + index)
                  else cyrillic.charAt(index)
        // Если символ был в верхнем регистре - преобразуем его
        if (y.isUpper) res.toUpper
        else res
      }
      // расшифровать символ латиницы или цифры по таблице ASCII
      private def decaesar(y: Char, startChar: Char, n: Int): Char = {
        // Индекс зашифрованного символа в алфавите:
        //    индекс_Y = ascii_код_Y - ascii_код_начала_алфавита
        // Индекс расшифрованного символа
        //    (индекс_Y - k + n) % n
        val index = (y.toLower - startChar - key + n) % n
        // Если индекс отрицательный, то смещаем символ влево относительно конца алфавита,
        // если положительный - вправо относително начала алфавита
        val res = if (index < 0) (startChar + n + index).toChar
                  else (startChar + index).toChar
        // Если символ был в верхнем регистре - преобразуем его
        if (y.isUpper) res.toUpper
        else res
      }

      // зашифровать строку
      def encrypt(msg: String): String =
        msg.map {
          case x if cyrillic.contains(x.toLower) => caesarCyrillic(x)
          case x if x.toLower >= 'a' && x.toLower <= 'z' => caesar(x, 'a', 26)
          case x if x >= '0' && x <= '9' => caesar(x, '0', 10)
          case x => x
        }
      // расшировать строку
      def decrypt(msg: String): String =
        msg.map {
          case y if cyrillic.contains(y.toLower) => decaesarCyrillic(y)
          case y if y.toLower >= 'a' && y.toLower <= 'z' => decaesar(y, 'a', 26)
          case y if y >= '0' && y <= '9' => decaesar(y, '0', 10)
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
    }*/
}
