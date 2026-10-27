package bankaccount;

import exception.AccountFrozenException;
import exception.InsufficientFundsException;
import exception.InvalidAmountException;
import java.util.ArrayList;
import java.util.List;

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

    /**
     * Deposits a specified monetary amount into the account.
     * <p>
     * Validates that the account is unfrozen and that the deposit amount 
     * is greater than zero before updating the balance and recording the 
     * transaction.
     * </p>
     * @param amount the monetary value to deposit; must be greater than zero
     * @throws AccountFrozenException if the account is currently frozen
     * @throws InvalidAmountException if {@code amount} is less than or 
     *                                equal to zero
     */
    public void deposit(double amount) {
        try {
            if (isFrozen()) {
                throw new AccountFrozenException(
                    "Account is FROZEN. Unable to transact.");
            }
            if (amount <= 0) {
                throw new InvalidAmountException(
                    "Invalid amount. Must be greater than 0.");
            }
            balance += amount;
            System.out.printf("Amount deposited: %.2f%n", amount);
            System.out.printf("Current balance: %.2f%n%n", getBalance());
            transactionHistory.add(new Transaction("Deposit", amount));
        } catch (AccountFrozenException e) {
            System.out.println(e.getMessage() + "\n");
        } catch (InvalidAmountException e) {
            System.out.printf("Amount deposited: %.2f%n", amount);
            System.out.println(e.getMessage());
            System.out.printf("Current balance: %.2f%n%n", getBalance());
        }
    }

    /**
     * Withdraws a specified monetary amount from the account.
     * <p>
     * Validates that the account is unfrozen, the withdrawal amount is 
     * positive, and sufficient funds exist before deducting the balance 
     * and recording the transaction.
     * </p>
     * 
     * @param amount the monetary value to withdraw; must be greater than zero
     * @throws AccountFrozenException if the account is currently frozen
     * @throws InvalidAmountException if {@code amount} is less than or 
     *                                equal to zero
     * @throws InsufficientFundsException if {@code amount} exceeds the 
     *                                     current balance
     */
    public void withdraw(double amount) {
        try {
            if (isFrozen()) {
                throw new AccountFrozenException(
                    "Account is FROZEN. Unable to transact.");
            }
            if (amount <= 0) {
                throw new InvalidAmountException(
                    "Invalid amount. Must be greater than 0.");
            }
            if (amount > balance) {
                throw new InsufficientFundsException("Insufficient balance.");
            }
            balance -= amount;
            System.out.printf("Amount withdrawn: %.2f%n", amount);
            System.out.printf("Current balance: %.2f%n%n", getBalance());
            transactionHistory.add(new Transaction("Withdraw", amount));
        } catch (AccountFrozenException e) {
            System.out.println(e.getMessage() + "\n");
        } catch (InvalidAmountException e) {
            System.out.printf("Amount withdrawn: %.2f%n", amount);
            System.out.println(e.getMessage());
            System.out.printf("Current balance: %.2f%n%n", getBalance());
        } catch (InsufficientFundsException e) {
            System.out.printf("Amount withdrawn: %.2f%n", amount);
            System.out.println(e.getMessage());
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