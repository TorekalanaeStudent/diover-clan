package exceptions_lefleur;

/**
 * Group Members:
 * Arban, Jhave P.
 * De Juras, Clint Norbert P.
 * @author @jhavearban-ctrl @cdejuras
 *
 * Unchecked Exception — extends RuntimeException
 * Does NOT need to be declared with throws
 * Used when: dividing by zero with double values
 */
public class DivisionByZeroException extends RuntimeException {

    public DivisionByZeroException(String message) {
        super(message);
    }
}