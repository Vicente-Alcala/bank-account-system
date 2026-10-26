package bankaccount;

import java.util.HashMap;
import java.util.Map;

/**
 * Manages bank accounts by assigning unique integer IDs and keeping track 
 * of accounts up to a maximum capacity of 100 entries. Implements {@link Bank}.
 * 
 * @author Vicente Miguel Alcala
 */
public class BankAccountManager implements Bank {
    Map<Integer, BankAccount> accounts;
    int id;

    public BankAccountManager() {
        accounts = new HashMap<>();
        id = 0;
        System.out.println("-\n");
    }

    @Override
    public BankAccount addAccount(BankAccount account) {
        if (accounts.size() < 100) {
            accounts.put(id, account);
            System.out.println("Account added successfully with ID: " + id +"\n");
            id++;
            return account;
        } else {
            System.out.println("The maximum limit of created accounts is 100.");
            return null;
        }
    }

    @Override
    public BankAccount getAccount(int id) {
        return accounts.get(id);
    }

    public void listAccounts() {
        for (Map.Entry<Integer, BankAccount> entry : accounts.entrySet()) {
            int accountId = entry.getKey();
            BankAccount acc = entry.getValue();

            String owner = "N/A";
            if (acc instanceof SavingsAccount) {
                owner = ((SavingsAccount) acc).getOwnerName();
            }

            // System.out.println("Account ID: " + accountId + ", Account Name: " + owner +
            // ", Balance: " + acc.getBalance());
            System.out.printf("Account ID: %d, Account Name: %s, Balance: %.2f%n", accountId, owner, acc.getBalance());
            //toString(accountId, owner, acc.getBalance());
        }
    }
}
