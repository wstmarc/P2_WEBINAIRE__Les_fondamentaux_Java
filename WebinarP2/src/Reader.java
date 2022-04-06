import java.io.*;
import java.util.*;
import exceptions.*;

/**
 * Gère la lecture de fichiers.
 * */
public class Reader {

    private final String path = ".\\WebinarP2\\src\\resources\\";
    
    //Remplacer le nom du fichier à lire ici
//    String fileToRead = "longText";
    String fileToRead = "invalidTextContainingNumber";
    
    /**
     * Lis un fichier dont le chemin (path) et le nom de fichier (fileToRead) sont indiqués dans les attributs de la classe Reader.
     * */
    public void readFile() {
        String completePath = path + fileToRead;

        //DONE>> Écrire le code pour lire ici
        //il faut lire le completePath
        try{
        	Scanner scan = new Scanner(new File(completePath));
            
        	int count = 0;
        	
        	while(scan.hasNextLine()){
                String line = scan.nextLine();
                
                if(count == 0 && line.equals("")) {
                	throw new EmptyFileException("");
                }else if(line.matches(".*\\d.*")) {
                	throw new NotAllowedCharacterException("Il y a des nombres");
                }
                count++;
                System.out.println(line);
            }
        }catch (FileNotFoundException e){
        	System.out.println("File Not Found Exception");
        	System.err.println(e);
        }catch (EmptyFileException e){
        	System.out.println("Empty File Exception");
        	System.err.println(e);
        }catch (NotAllowedCharacterException e){
        	System.out.println("Not Allowed Character");
        	System.err.println(e);
        }
    }
	
}