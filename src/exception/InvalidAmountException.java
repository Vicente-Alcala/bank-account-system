package exception;

/**
 * Thrown to indicate that a monetary transaction amount is invalid 
 * (e.g., zero or negative).
 * 
 * @author Vicente Miguel Alcala
 */
public class InvalidAmountException extends Exception {
    private String message;

    /**
     * Constructs a new {@code InvalidAmountException} with the specified 
     * detail message.
     */
    public InvalidAmountException(String message) {
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
