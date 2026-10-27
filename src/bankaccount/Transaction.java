package bankaccount;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Represents an individual financial transaction, capturing the transaction 
 * type, monetary amount, and the exact timestamp when it occurred.
 * 
 * @author Vicente Miguel Alcala
 */
public class Transaction {
    private String type;
    private double amount;
    LocalDateTime timeStamp;

    private static final DateTimeFormatter FORMATTER = 
    DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    public Transaction(String type, double amount) {
        this.type = type;
        this.amount = amount;
        this.timeStamp = LocalDateTime.now();
    }

    public double getAmount() {
        return amount;
    }
    
    @Override
    public String toString() {
        return String.format("Type: %-8s | Amount: %-8.2f | Time Stamp: %s",
                type, amount, timeStamp.format(FORMATTER));
    }
}
