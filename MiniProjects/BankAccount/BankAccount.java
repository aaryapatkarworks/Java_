public class BankAccount {

    private String accountHolder;
    private long accountNumber;
    private double balance;

    // Default Constructor
    BankAccount() {

        accountHolder = "Unknown";
        accountNumber = 0;
        balance = 1000;

    }

    // Parameterized Constructor
    BankAccount(String accountHolder,
                long accountNumber,
                double balance) {

        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.balance = balance;

    }

    // Deposit Method
    void deposit(double amount) {

        if (amount > 0) {

            balance = balance + amount;
            System.out.println("₹" + amount + " deposited successfully.");

        }

        else {

            System.out.println("Invalid Deposit Amount.");

        }

    }

    // Withdraw Method
    void withdraw(double amount) {

        if (amount <= balance) {

            balance = balance - amount;
            System.out.println("₹" + amount + " withdrawn successfully.");

        }

        else {

            System.out.println("Insufficient Balance.");

        }

    }

    // Getters
    String getAccountHolder() {

        return accountHolder;

    }

    long getAccountNumber() {

        return accountNumber;

    }

    double getBalance() {

        return balance;

    }

    // Setter
    void setAccountHolder(String accountHolder) {

        this.accountHolder = accountHolder;

    }

    // Display Method
    void displayAccount() {

        System.out.println("Account Holder : " + getAccountHolder());
        System.out.println("Account Number : " + getAccountNumber());
        System.out.println("Balance        : ₹" + getBalance());

        System.out.println();

    }

    public static void main(String[] args) {

        BankAccount account1 = new BankAccount();

        BankAccount account2 =
                new BankAccount(
                        "Aarya Patkar",
                        123456789012L,
                        90000
                );

        account1.displayAccount();

        account2.displayAccount();

        account2.deposit(5000);

        account2.withdraw(10000);

        account2.displayAccount();

        account2.setAccountHolder("Pahel Patkar");

        System.out.println("Updated Name : "
                + account2.getAccountHolder());

    }

}