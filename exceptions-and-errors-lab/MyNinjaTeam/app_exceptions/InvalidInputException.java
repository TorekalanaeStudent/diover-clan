package app_exceptions;

/**
 * @author Trespeces, Guillermo II O.
 * @willj067
 */

// unchecked exception - extends Exception
public class InvalidInputException extends Exception {

    public InvalidInputException() {
        super("Invalid input provided.");
    }

    public InvalidInputException(String message) {
        super(message);
    }
}