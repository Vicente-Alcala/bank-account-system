package bankaccount;

import java.util.List;

/**
 * Demonstrates the bank account system and its operations.
 *
 * @author Vicente Miguel Alcala
 */

public class Main {
    public static void main(String[] args) {
        byte counter = 1;

        // [TEST CASES FOR EXERCISE 1]
        System.out.println("[TEST CASES FOR EXERCISE 1]\n");

        // Test case 1
        System.out.printf("Test case %d%n", counter);
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

        // [TEST CASES FOR EXERCISE 2]

        // Test case 2.1
        System.out.println("\n[TEST CASES FOR EXERCISE 2]\n\nTest case 1");
        System.out.println("Transaction History:");
        for (Transaction t : acc1.getTransactionHistory()) {
            System.out.println(t);
        }

        //Test case 2.2
        System.out.println("\nTest case 2");
        Bank accM1 = new BankAccountManager();

        //Test case 2.3
        System.out.println("Test case 3");
        accM1.addAccount(acc1);

        //Test case 2.4
         System.out.println("Test case 4");
         accM1.addAccount(new SavingsAccount("Test1"));

         //Test case 2.5
         System.out.println("Test case 5");
         accM1.listAccounts();


        // [TEST CASES FOR EXERCISE 3]
        System.out.println("[TEST CASES FOR EXERCISE 3]\n");
        BankAccount acc3 = new SavingsAccount("Test2");
        accM1.addAccount(acc3);
        acc3.deposit(500.13);

        // Test case 3.1
        System.out.println("Test case 1");
        acc3.deposit(-500);

        //Test case 3.2
        System.out.println("Test case 2");
        acc3.freezeAccount();
        acc3.deposit(11500);
        acc3.unfreezeAccount();

        //Test case 3.3
        System.out.println("Test case 3");
        acc3.withdraw(-100);

        //Test case 3.4
        System.out.println("Test case 4");
        acc3.withdraw(1500);

        //Test case 3.5
        System.out.println("Test case 5");
        acc3.freezeAccount();
        acc3.withdraw(500);
        acc3.unfreezeAccount();

        //Test case 3.6
        System.out.println("Test case 6\nFiltering transactions at or above 200...");
        List<Transaction> filteredTransactions = accM1.filterTransactionsAtOrAbove(200.0, acc1.getTransactionHistory());
        for (Transaction t : filteredTransactions) {
            System.out.println(t);
        }

        //Test case 3.7
        System.out.println("\nTest case 7\nSorting by amount...");
        List<Transaction> sortedTransactions = accM1.sortTransactionsByAmount(acc1.getTransactionHistory());
        for (Transaction t : sortedTransactions) {
            System.out.println(t);
        }
    }
}
