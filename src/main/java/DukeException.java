import  java.lang.Exception;
import java.lang.StringIndexOutOfBoundsException;


/**
 * Represents an exception thrown by Duke
 */
public class DukeException extends Exception {
    public DukeException (String message) {
        super(message);
    }
}
