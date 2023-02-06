
public class NoUpperAlphaException extends Exception {
    public NoUpperAlphaException() {
        super("The password must contain at least on uppercase alphabetic character");
    }
}

