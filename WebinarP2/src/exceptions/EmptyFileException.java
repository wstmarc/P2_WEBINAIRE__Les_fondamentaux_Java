package exceptions;

/**
 * EmptyFileException is a custom exception class.
 * */
public class EmptyFileException extends Exception {

	public EmptyFileException(String error) {
		
		super("The file is empty !!!");
		
	}
	
}