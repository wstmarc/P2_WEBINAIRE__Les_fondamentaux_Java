package exceptions;

/**
 * NotAllowedCharacter est une classe d'exception personnalis�e.
 * */
public class NotAllowedCharacterException extends Exception {

	public NotAllowedCharacterException(String error) {
		
		super("Caract�re non autoris�");
		
	}
	
}