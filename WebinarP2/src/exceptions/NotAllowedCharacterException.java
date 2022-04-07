package exceptions;

/**
 * Custom exception class.
 * */
public class NotAllowedCharacterException extends Exception {
	public NotAllowedCharacterException(String error) {
		super(error);
	}
}