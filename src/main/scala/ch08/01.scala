package Ch06 {
  package Ex01 {

    class BankAccount(initialBalance: Double) {
      protected var balance = initialBalance

      def deposit(amount: Double) = {
        balance += amount
      }

      def withdraw(amount: Double) = {
        balance -= amount
      }

      def current = balance
    }

    class CheckingAccount(initialBalance: Double) extends BankAccount(initialBalance) {
      private def getComission = {
        balance -= 1.0
      }

      override def deposit(amount: Double) = {
        super.deposit(amount)
        getComission
      }

      override def withdraw(amount: Double) = {
        super.withdraw(amount)
        getComission
      }
    }

    object Main extends App {
      var acc = new CheckingAccount(0.0)
      acc.deposit(10.0)
      assert(acc.current == 9.0)
      acc.withdraw(3)
      assert(acc.current == 5.0)
    }

  }

}
