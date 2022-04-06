package exceptions;

/**
 * NotAllowedCharacter est une classe d'exception personnalisée.
 * */
public class NotAllowedCharacterException extends Exception {

	public NotAllowedCharacterException(String error) {
		
		super("Caractère non autorisé");
		
	}
	
}