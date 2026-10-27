package exception;

public class InsufficientFundsException extends Exception {
    private String message;

    public InsufficientFundsException(String message) {
        super(message);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
