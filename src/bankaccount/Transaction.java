package bankaccount;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Represents an individual financial transaction, capturing the transaction type,
 * monetary amount, and the exact timestamp when it occurred.
 * 
 * @author Vicente Miguel Alcala
 */
public class Transaction {
    String type;
    double amount;
    LocalDateTime time_stamp;

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    public Transaction(String type, double amount) {
        this.type = type;
        this.amount = amount;
        this.time_stamp = LocalDateTime.now();
    }

    // @Override
    // public String toString() {
    // return "Type: " + type + ", Amount: " + amount + ", Time Stamp: " +
    // time_stamp;
    // }

    // @Override
    // public String toString() {
    // return String.format("%-10s | Amount: %-8.2f | Date: %s", type, amount,
    // time_stamp);
    // }

    // @Override
    // public String toString() {
    //     return "type=" + type + ", amount=" + amount + ", time_stamp=" + time_stamp.format(FORMATTER) + "]";
    // }

    @Override
    public String toString() {
        return String.format("Type: %-8s | Amount: %-8.2f | Time Stamp: %s",
                type, amount, time_stamp.format(FORMATTER));
    }
}
