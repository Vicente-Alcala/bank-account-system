package bankaccount;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Manages bank accounts by assigning unique integer IDs and keeping track 
 * of accounts up to a maximum capacity of 100 entries. 
 * Implements {@link Bank}.
 * 
 * @author Vicente Miguel Alcala
 */
public class BankAccountManager implements Bank {
    Map<Integer, BankAccount> accounts;
    private int id;
    private final int MAX_ACCOUNT_CREATION_LIMIT = 100;


    public BankAccountManager() {
        accounts = new HashMap<>();
        id = 0;
        System.out.println("-\n");
    }

    /**
     * Adds a bank account to the system if the maximum account capacity 
     * has not been reached, assigning it a unique integer ID.
     */
    @Override
    public BankAccount addAccount(BankAccount account) {
        if (accounts.size() < MAX_ACCOUNT_CREATION_LIMIT) {
            accounts.put(id, account);
            System.out.println("Account added successfully with ID: " 
            + id +"\n");
            id++;
            return account;
        } else {
            System.out.println("The maximum limit of created accounts is " 
            + MAX_ACCOUNT_CREATION_LIMIT +".");
            return null;
        }
    }

    @Override
    public BankAccount getAccount(int id) {
        return accounts.get(id);
    }

    /**
     * Displays details for all registered bank accounts, including account 
     * ID, owner name (if applicable), and current balance.
     */
    public void listAccounts() {
        for (Map.Entry<Integer, BankAccount> entry : accounts.entrySet()) {
            int accountId = entry.getKey();
            BankAccount acc = entry.getValue();

            String owner = "N/A";
            if (acc instanceof SavingsAccount) {
                owner = ((SavingsAccount) acc).getOwnerName();
            }

            System.out.printf("Account ID: %d%n" +
                              "Account Name: %s%n" +
                              "Balance: %.2f%n"
                              , accountId, owner, acc.getBalance());
            System.out.println();
        }
        
    }

    /**
     * Filters a list of transactions to include only those with a monetary 
     * amount greater than or equal to a specified minimum value.
     */
    public List<Transaction> filterTransactionsAtOrAbove(
        double amount, List<Transaction> txList) {
        List<Transaction> filtered = new ArrayList<>();
        if (txList == null) return filtered;

        for (Transaction tx : txList) {
            if (tx.getAmount() >= amount) {
                filtered.add(tx);
            }
        }
        return filtered;
    }

    /**
     * Sorts a list of transactions in ascending order based on their monetary 
     * amount.
     */
    public List<Transaction> sortTransactionsByAmount(
        List<Transaction> txList) {
        if (txList == null) return new ArrayList<>();

        List<Transaction> sortedList = new ArrayList<>(txList);

        sortedList.sort((tx1, tx2) -> Double.compare(
            tx1.getAmount(), tx2.getAmount()));

        return sortedList;
    }
}
