package bankaccount;

import java.util.List;
import java.util.ArrayList;

/**
 * Represents a bank account with deposit, withdrawal,
 * balance, and account-freezing operations.
 */

public class BankAccount {
    private double balance;
    private boolean isFrozen;
    List<Transaction> transactionHistory;

    public BankAccount() {
        balance = 0.0;
        isFrozen = false;
        transactionHistory = new ArrayList<>();
    }

    public void deposit(double amount) {
        if (isFrozen()) {
            System.out.printf("Account is FROZEN. Unable to transact.\n\n");
            return;
        }
        if (amount > 0) {
            balance += amount;
            System.out.printf("Amount deposited: %.2f%n", amount);
            System.out.printf("Current balance: %.2f%n%n", getBalance());
            transactionHistory.add(new Transaction("Deposit", amount));
        } else {
            System.out.printf("Amount deposited: %.2f%n", amount);
            System.out.printf("Invalid amount. Must be greater than 0.%n");
            System.out.printf("Current balance: %.2f%n%n", getBalance());
        }
    }

    public void withdraw(double amount) {
        if (isFrozen()) {
            System.out.printf("Account is FROZEN. Unable to transact.\n\n");
            return;
        }
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.printf("Amount withdrawn: %.2f%n", amount);
            System.out.printf("Current balance: %.2f%n%n", getBalance());
            transactionHistory.add(new Transaction("Withdraw", amount));
        } else if (amount <= 0) {
            System.out.printf("Amount withdrawn: %.2f%n", amount);
            System.out.printf("Invalid amount. Must be greater than 0.%n");
            System.out.printf("Current balance: %.2f%n%n", getBalance());
        } else if (amount > balance) {
            System.out.printf("Amount withdrawn: %.2f%n", amount);
            System.out.printf("Insufficient balance.%n");
            System.out.printf("Current balance: %.2f%n%n", getBalance());
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

    public List<Transaction> getTransactionHistory() {
        return transactionHistory;
    }

}