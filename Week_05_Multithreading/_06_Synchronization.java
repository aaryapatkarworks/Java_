class Bank_Account {

    private int balance = 10000;

    // Only one thread can execute this method at a time
    public synchronized void withdraw(String name, int amount) {

        System.out.println(name + " is trying to withdraw ₹" + amount);

        if (balance >= amount) {

            System.out.println("Transaction Approved");

            balance -= amount;

            System.out.println("Remaining Balance : ₹" + balance);

        }

        else {

            System.out.println("Insufficient Balance");

        }

        System.out.println();

    }

}

class Customer extends Thread {

    Bank_Account account;
    int amount;

    public Customer(Bank_Account account, String name, int amount) {

        this.account = account;
        this.amount = amount;

        setName(name);

    }

    @Override
    public void run() {

        account.withdraw(getName(), amount);

    }

}

public class _06_Synchronization {

    public static void main(String[] args) {

        Bank_Account account = new Bank_Account();

        Customer customer1 = new Customer(account, "Aarya", 5000);
        Customer customer2 = new Customer(account, "Pranav", 7000);

        customer1.start();
        customer2.start();

    }

}