package bankaccount;

import java.util.List;

/**
 * Demonstrates the bank account system and its operations.
 *
 * @author Vicente Miguel Alcala
 */

public class Main {
    private static int exerciseNum = 1;
    private static int testNum = 1;

    private static void setExercise(int num) {
        exerciseNum = num;
        testNum = 1;
        System.out.printf("%n[TEST CASES FOR EXERCISE %d]%n%n", exerciseNum);
    }

    private static void printTestCase() {
        System.out.printf("Test case %d.%d%n", exerciseNum, testNum++);
    }

    private static void printTestCase(String details) {
        System.out.printf("Test case %d.%d%n%s%n", 
                          exerciseNum, testNum++, details);
    }

    public static void main(String[] args) {
        final int TRANSACTION_FILTER_AMOUNT = 200;

        // [TEST CASES FOR EXERCISE 1]
        setExercise(1);

        // Test case 1.1
        printTestCase();
        BankAccount acc1 = new SavingsAccount("Test0");

        // Test case 1.2
        printTestCase();
        acc1.deposit(1000.125);

        // Test case 1.3
        printTestCase();
        acc1.deposit(0);

        // Test case 1.4
        printTestCase();
        acc1.deposit(-500);

        // Test case 1.5
        printTestCase();
        acc1.withdraw(500);

        // Test case 1.6
        printTestCase();
        acc1.withdraw(1500);

        // Test case 1.7
        printTestCase();
        acc1.withdraw(-100);

        // Test case 1.8
        printTestCase();
        acc1.freezeAccount();
        acc1.deposit(11500);

        // Test case 1.9
        printTestCase();
        acc1.withdraw(500);

        // Test case 1.10
        printTestCase();
        acc1.unfreezeAccount();
        acc1.withdraw(100);


        // [TEST CASES FOR EXERCISE 2]
        setExercise(2);

        // Test case 2.1
        printTestCase("Transaction History:");
        for (Transaction t : acc1.getTransactionHistory()) {
            System.out.println(t);
        }
        System.out.println();

        // Test case 2.2
        printTestCase();
        Bank accM1 = new BankAccountManager();

        // Test case 2.3
        printTestCase();
        accM1.addAccount(acc1);

        // Test case 2.4
        printTestCase();
        accM1.addAccount(new SavingsAccount("Test1"));

        // Test case 2.5
        printTestCase();
        accM1.listAccounts();

        // [TEST CASES FOR EXERCISE 3]
        setExercise(3);
        BankAccount acc3 = new SavingsAccount("Test2");
        accM1.addAccount(acc3);
        acc3.deposit(500.13);

        // Test case 3.1
        printTestCase();
        acc3.deposit(-500);

        // Test case 3.2
        printTestCase();
        acc3.freezeAccount();
        acc3.deposit(11500);
        acc3.unfreezeAccount();
        
       // Test case 3.3
        printTestCase();
        acc3.withdraw(-100);

        // Test case 3.4
        printTestCase();
        acc3.withdraw(1500);

        // Test case 3.5
        printTestCase();
        acc3.freezeAccount();
        acc3.withdraw(500);
        acc3.unfreezeAccount();

        //Test case 3.6
        printTestCase("Filtering transactions at or above "
                        + TRANSACTION_FILTER_AMOUNT + "...");
        List<Transaction> filteredTransactions = 
        accM1.filterTransactionsAtOrAbove(
            (double) TRANSACTION_FILTER_AMOUNT, acc1.getTransactionHistory());
        for (Transaction t : filteredTransactions) {
            System.out.println(t);
        }
        System.out.println();

        //Test case 3.7
        printTestCase("Sorting by amount...");
        List<Transaction> sortedTransactions = 
        accM1.sortTransactionsByAmount(acc1.getTransactionHistory());
        for (Transaction t : sortedTransactions) {
            System.out.println(t);
        }
    }
}
