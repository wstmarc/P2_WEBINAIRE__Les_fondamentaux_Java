package exceptions;

/**
 * EmptyFileException est une classe d'exception personnalisée.
 * */
public class EmptyFileException extends Exception {

	public EmptyFileException(String error) {
		
		super("Fichier vide");
		
	}
	
}