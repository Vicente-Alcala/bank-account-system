package exception;

/**
 * Thrown when a withdrawal operation fails due to insufficient account balance.
 * 
 * @author Vicente Miguel Alcala
 */
public class InsufficientFundsException extends Exception {
    private String message;

    /**
     * Constructs a new {@code InsufficientFundsException} with the specified 
     * detail message.
     */
    public InsufficientFundsException(String message) {
        super(message);
        this.message = message;
    }

    /**
     * Returns the detail message string of this exception.
     */
    @Override
    public String getMessage() {
        return this.message;
    }
}
