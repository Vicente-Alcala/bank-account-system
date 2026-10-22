public class SavingsAccount extends BankAccount {
    String ownerName;

    public SavingsAccount(String ownerName) {
        super();
        this.ownerName = ownerName;
        System.out.println("\nTest case 1 - Account Owner: " + ownerName + "\n");
    }

    public String getOwnerName() {
        return ownerName;
    }
}
