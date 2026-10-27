package bankaccount;

import java.util.List;

/**
 * Interface defining the core operational contract for 
 * bank account management systems.
 * 
 * @author Vicente Miguel Alcala
 */
public interface Bank {
    BankAccount addAccount(BankAccount account);
    BankAccount getAccount(int id);
    void listAccounts();

    List<Transaction> filterTransactionsAtOrAbove(
        double amount, List<Transaction> txList);
    List<Transaction> sortTransactionsByAmount(
        List<Transaction> txList);
}
