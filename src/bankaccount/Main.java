package bankaccount;

/**
 * Demonstrates the bank account system and its operations.
 *
 * @author Vicente Miguel Alcala
 */

public class Main {
    public static void main(String[] args) {
        byte counter = 1;

        // Test case 1
        System.out.printf("Test case %d", counter);
        BankAccount acc1 = new SavingsAccount("Test0");
        counter++;

        // Test case 2
        System.out.printf("Test case %d\n", counter);
        acc1.deposit(1000.125);
        counter++;

        // Test case 3
        System.out.printf("Test case %d\n", counter);
        acc1.deposit(0);
        counter++;

        // Test case 4
        System.out.printf("Test case %d\n", counter);
        acc1.deposit(-500);
        counter++;

        // Test case 5
        System.out.printf("Test case %d\n", counter);
        acc1.withdraw(500);
        counter++;

        // Test case 6
        System.out.printf("Test case %d\n", counter);
        acc1.withdraw(1500);
        counter++;

        // Test case 7
        System.out.printf("Test case %d\n", counter);
        acc1.withdraw(-100);
        counter++;

        // Test case 8
        System.out.printf("Test case %d\n", counter);
        acc1.freezeAccount();
        acc1.deposit(11500);
        counter++;

        // Test case 9
        System.out.printf("Test case %d\n", counter);
        acc1.withdraw(500);
        counter++;

        // Test case 10
        System.out.printf("Test case %d\n", counter);
        acc1.unfreezeAccount();
        acc1.withdraw(100);
        counter++;
    }
}
