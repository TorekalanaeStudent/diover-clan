package exceptions_lefleur;

/**
 * Group Members:
 * Arban, Jhave P.
 * De Juras, Clint Norbert P.
 * @author @jhavearban-ctrl @cdejuras
 *
 * Checked Exception — extends Exception
 * Must be declared with throws or handled with try-catch
 * Used when: dividing by zero with int values
 */
public class InvalidInputException extends Exception {

    public InvalidInputException(String message) {
        super(message);
    }
}