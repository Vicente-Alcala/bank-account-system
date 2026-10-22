public class BankAccount {
    double balance;
    boolean isFrozen;
    byte counter = 1;

    public BankAccount() {
        balance = 0.0;
        isFrozen = false;
    }

    public void deposit(double amount) {
        counter++;
        if (isFrozen) {
            System.out.println("Test case " + counter + " - Account is FROZEN. Unable to transact.\n");
            return;
        }
        if (amount > 0) {
            balance += amount;
            System.out.printf("Test case %d - Amount deposited: %.2f%n", counter, amount);
            System.out.printf("Test case %d - Current balance: %.2f%n%n", counter, getBalance());
        } else if (amount <= 0) {
            System.out.printf("Test case %d - Amount deposited: %.2f%n", counter, amount);
            System.out.printf("Test case %d - Invalid amount. Must be greater than 0.%n", counter);
            System.out.printf("Test case %d - Current balance: %.2f%n%n", counter, getBalance());
        } else {
            System.out.printf("Test case %d - Invalid amount. Must be greater than 0.%n", counter);
            System.out.printf("Test case %d - Current balance: %.2f%n%n", counter, getBalance());
        }

    }

    public void withdraw(double amount) {
        counter++;
        if (isFrozen) {
            System.out.println("Test case " + counter + " - Account is FROZEN. Unable to transact.\n");
            return;
        }
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            // Changed println to printf, and + to ,
            System.out.printf("Test case %d - Amount withdrawn: %.2f%n", counter, amount);
            System.out.printf("Test case %d - Current balance: %.2f%n%n", counter, getBalance());
        } else if (amount <= 0) {
            System.out.printf("Test case %d - Amount withdrawn: %.2f%n", counter, amount);
            System.out.printf("Test case %d - Invalid amount. Must be greater than 0.%n", counter);
            System.out.printf("Test case %d - Current balance: %.2f%n%n", counter, getBalance());
        } else if (amount > balance) {
            System.out.printf("Test case %d - Amount withdrawn: %.2f%n", counter, amount);
            System.out.printf("Test case %d - Insufficient balance.%n", counter);
            System.out.printf("Test case %d - Current balance: %.2f%n%n", counter, getBalance());
        }
    }

    public double getBalance() {
        return balance;
    }

    public void freezeAccount() {
        isFrozen = true;
    }

    public void unfreezeAccount() {
        isFrozen = false;
    }

    public boolean isFrozen() {
        return isFrozen;
    }

}