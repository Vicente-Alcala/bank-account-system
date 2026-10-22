public class Main {
    public static void main(String[] args) {
        // Test case 1
        BankAccount acc1 = new SavingsAccount("Test0");

        // Test case 2
        acc1.deposit(1000.125);

        // Test case 3
        acc1.deposit(0);

        // Test case 4
        acc1.deposit(-500);

        // Test case 5
        acc1.withdraw(500);

        // Test case 6
        acc1.withdraw(1500);

        // Test case 7
        acc1.withdraw(-100);

        // Test case 8
        acc1.freezeAccount();
        acc1.deposit(11500);

        // Test case 9
        acc1.withdraw(500);

        // Test case 10
        acc1.unfreezeAccount();
        acc1.withdraw(100);

    }
}
