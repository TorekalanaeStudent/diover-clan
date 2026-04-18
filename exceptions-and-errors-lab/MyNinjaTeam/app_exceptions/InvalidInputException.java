package app_exceptions;

/**
 * @author Trespeces, Guillermo II O.
 * @willj067
 */

// unchecked exception - extends RuntimeException
public class InvalidInputException extends RuntimeException {

    public InvalidInputException() {
        super("Invalid input provided.");
    }

    public InvalidInputException(String message) {
        super(message);
    }
}