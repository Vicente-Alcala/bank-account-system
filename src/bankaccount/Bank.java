package bankaccount;

/**
 * Interface defining the core operational contract for bank account management systems.
 * 
 * @author Vicente Miguel Alcala
 */
public interface Bank {
    BankAccount addAccount(BankAccount account);
    BankAccount getAccount(int id);
    void listAccounts();
}
