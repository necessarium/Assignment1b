
public class NoDigitException extends Exception {
    public NoDigitException() {
	super("The passowrd must contain at least one digit");
    }
}
