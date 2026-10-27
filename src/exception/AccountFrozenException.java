package exception;

/**
 * Thrown to indicate that an operation was attempted on a frozen bank account.
 * 
 * @author Vicente Miguel Alcala
 */
public class AccountFrozenException extends Exception {
    private String message;

    /**
     * Constructs a new {@code AccountFrozenException} with the specified 
     * detail message.
     */
    public AccountFrozenException(String message) {
        this.message = message;
    }

    /**
     * Returns the detail message string of this exception.
     */
    @Override
    public String getMessage() {
        return message;
    }

}
