import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordCheckerUtility {
    public static boolean isValidPassword(String password) throws LengthException, NoUpperAlphaException, NoLowerAlphaException, NoDigitException, NoSpecialCharacterException, InvalidSequenceException {
	if(!isValidLength(password)) return false;
	if(!hasDigit(password)) return false;
	if(!hasUpperAlpha(password)) return false;
	if(!hasLowerAlpha(password)) return false;
	if(!hasSpecialChar(password))return false;
	if(!noSameCharInSquenence(password)) return false;
	return true;
	 
    }

    public static boolean isWeakPassword(String password) throws WeakPasswordException, Exception{
	if(isValidPassword(password) && !hasBetweenSixAndNineChars(password))
	    return false;
	else
	    throw new WeakPasswordException();
    }

    public static boolean noSameCharInSquenence(String password) throws InvalidSequenceException {
	for(int i = 1; i < password.length(); i++)
	    if(password.charAt(i) == password.charAt(i-1))
		throw new InvalidSequenceException();
	return true;

    }

    public static void comparePasswords(String password, String passwordConfirm) throws UnmatchedException {
	if(!password.equals(passwordConfirm)) throw new UnmatchedException();	
    }

    public static boolean comparePasswordsWithReturn(String password, String passwordConfirm) {
	if(password.equals(passwordConfirm)) return true;
	else return false;
    }

    public static ArrayList<String> getInvalidPasswords(ArrayList<String> passwords) {
	ArrayList<String> invalidPasswords = new ArrayList<String>();
	for(String password : passwords) {
	    try { 
		isValidPassword(password);
	    } catch(Exception e) {
		invalidPasswords.add(password + " " + e.getMessage());
	    }
	}
	return invalidPasswords;
    }

    public static boolean hasBetweenSixAndNineChars(String password) {
	return password.length() >= 6 && password.length() <= 9;
    }

    public static boolean hasDigit(String password) throws NoDigitException {
	for(char ch : password.toCharArray())
	    if(Character.isDigit(ch))
		return true;
	throw new NoDigitException();
    }

    public static boolean hasLowerAlpha(String password) throws NoLowerAlphaException {
	for(char ch : password.toCharArray())
	    if(Character.isLetter(ch) && Character.isLowerCase(ch))
		return true;
	throw new NoLowerAlphaException();
    }

    public static boolean hasSpecialChar(String password) throws NoSpecialCharacterException {
	Pattern pattern = Pattern.compile("[a-zA-Z0-9]*");
	Matcher matcher = pattern.matcher(password);
	if(matcher.matches()) throw new NoSpecialCharacterException();
	else return true;
    }

    public static boolean hasUpperAlpha(String password) throws NoUpperAlphaException {
	for(char ch : password.toCharArray())
	    if(Character.isLetter(ch) && Character.isUpperCase(ch))
		return true;
	throw new NoUpperAlphaException();
    }

    public static boolean isValidLength(String password) throws LengthException {
	if(password.length() >= 6) return true;
	else throw new LengthException();
    }
}
