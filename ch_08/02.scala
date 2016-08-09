package Ch08 {
  package Ex02 {

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

    class SavingAccount(initialBalance: Double) extends BankAccount(initialBalance) {
      private var count: Int = 1

      private def getComission = {
        balance -= 1.0
      }

      override def deposit(amount: Double) = {
        super.deposit(amount)
        if (count > 3) {
          getComission
        }
        count += 1
      }

      override def withdraw(amount: Double) = {
        super.withdraw(amount)
        if (count > 3) {
          getComission
        }
        count += 1
      }

      def earnMonthlyInterest(rate: Double) = {
        balance += rate * balance
        count = 1
      }
    }

    object Main extends App {
      var acc = new SavingAccount(0.0)
      acc.deposit(10.0)
      assert(acc.current == 10.0)
      acc.withdraw(3)
      assert(acc.current == 7.0)
      acc.deposit(10.0)
      assert(acc.current == 17.0)
      acc.deposit(10.0)
      assert(acc.current == 26.0)
      acc.earnMonthlyInterest(0.1)
      assert(acc.current == 28.6)
      acc.deposit(10.0)
    }

  }

}


