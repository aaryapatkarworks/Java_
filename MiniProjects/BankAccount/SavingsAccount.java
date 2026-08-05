public class SavingsAccount extends BankAccount {

    private double interestRate;

    SavingsAccount(String accountHolder,
                   long accountNumber,
                   double balance,
                   double interestRate) {

        super(accountHolder,
                accountNumber,
                balance);

        this.interestRate = interestRate;

    }

    @Override
    void withdraw(double amount) {

        if (amount > 25000) {

            System.out.println("Withdrawal Limit Exceeded!");

        }

        else {

            super.withdraw(amount);

        }

    }

    void calculateInterest() {

        double interest =
                getBalance() * interestRate / 100;

        System.out.println("Current Balance : ₹" + getBalance());
        System.out.println("Interest Earned : ₹" + interest);

    }

    void displaySavingsAccount() {

        displayAccount();

        System.out.println("Interest Rate   : " + interestRate + "%");

        System.out.println();

    }

    public static void main(String[] args) {

        SavingsAccount account1 =
                new SavingsAccount(
                        "Pranav More",
                        987654321012L,
                        82000,
                        6.5
                );

        SavingsAccount account2 =
                new SavingsAccount(
                        "Swara Umredkar",
                        876543210987L,
                        72000,
                        7.2
                );

        account1.deposit(10000);

        account1.withdraw(15000);

        account1.calculateInterest();

        System.out.println();

        account2.withdraw(15000);

        account2.calculateInterest();

        System.out.println();

        account1.displaySavingsAccount();

        account2.displaySavingsAccount();

        account1.withdraw(30000);

        account1.displaySavingsAccount();

    }

}