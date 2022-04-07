package exceptions;

/**
 * NotAllowedCharacterException is a custom exception class.
 * */
public class NotAllowedCharacterException extends Exception {

	public NotAllowedCharacterException(String error) {
		
		super("Numbers are not allowed characters !!!");
		
	}
	
}