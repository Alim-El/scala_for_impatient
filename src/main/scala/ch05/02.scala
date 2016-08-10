package Ch05 {
  package Ex02 {

    object Main extends App {

      class BankAccount(private var current: Int = 0) {
        def deposit(value: Int) {
          current += value
        }

        def withdraw(value: Int) {
          current -= value
        }

        def balance = current
      }

      var acc = new BankAccount(100)
      acc.deposit(10)
      acc.withdraw(30)
      assert(acc.balance == 80)
    }
  }
}

