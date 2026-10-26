package bankaccount;

/**
 * Represents a savings account associated with an owner.
 */

public class SavingsAccount extends BankAccount {
    private String ownerName;

    public SavingsAccount(String ownerName) {
        super();
        this.ownerName = ownerName;
        System.out.println("Account Owner: " + ownerName + "\n");
    }

    public String getOwnerName() {
        return ownerName;
    }
}
