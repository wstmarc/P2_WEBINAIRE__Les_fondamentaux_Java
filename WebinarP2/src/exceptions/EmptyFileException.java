package exceptions;

/**
 * Custom exception class.
 * */
public class EmptyFileException extends Exception {
	public EmptyFileException(String error) {
		super(error);	
	}
}