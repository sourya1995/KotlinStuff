import java.time.temporal.TemporalAmount

class BankOps {
    fun main(){
        println("Welcome to your banking system")
        println("What type of account would you like to create?")
        println("1. Debit account")
        println("2. Credit account")
        println("3. Checking account")
        var accountType = " "
        var userChoice = 0
        while(accountType == ""){
            println("Choose an option (1, 2 or 3)")
            userChoice = (1..5).random()
            println("The selected option is ${userChoice}.")
            when(userChoice){
                1 -> accountType = "debit"
                2 -> accountType = "credit"
                3 -> accountType = "checking"
                else -> continue
            }

        }
        println("you have created a ${accountType} account.")
        var accountBalance = (0..1000).random()
        println("The current balance is ${accountBalance} dollars.")
        val money = (0..1000).random()
        println("The amount you transferred is ${money} dollars.")

        fun withdraw(amount: Int): Int {
            accountBalance -= amount
            println("You successfully withdrew ${amount} dollars. The current balance is ${accountBalance} dollars.")
            return amount
        }

        fun debitWithdraw(amount: Int): Int {
            if(accountBalance == 0){
                println("Zero Balance. Cannot withdraw.")
                return accountBalance
            } else if(amount > accountBalance) {
                println("not enough funds to make withdrawal.")
                return 0
            } else {
                return withdraw(amount)
            }
        }

        fun deposit(amount: Int): Int{
            accountBalance += amount
            println("You successfully deposited ${amount} dollars. The current balance is ${accountBalance} dollars.")
            return amount
        }

        fun creditDeposit(amount: Int): Int {
            if (accountBalance == 0) {
                println("Do not deposit. This account has been paid off.")
                return accountBalance
            } else if (accountBalance + amount > 0) {
                println("deposit failed. You tried to pay an amount greater than the credit balance. The current balance is ${accountBalance} dollars.")
            } else if (amount == -accountBalance) {
                accountBalance = 0
                println("you have paid off this account")
                return amount
            } else {
                return deposit(amount)
            }
        }
    }
}