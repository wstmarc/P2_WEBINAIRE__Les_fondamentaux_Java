import java.io.*;
import java.util.*;

/**
 * Gère la lecture de fichiers.
 * */
public class Reader {

    private final String path = ".\\WebinarP2\\src\\resources\\";
    
    //Remplacer le nom du fichier à lire ici
    String fileToRead = "longText";
    
    public void readFile() {
        String completePath = path + fileToRead;

        //DONE>> Écrire le code pour lire ici
        //il faut lire le completePath
        try{
        	Scanner scan = new Scanner(new File(completePath));
            while(scan.hasNextLine()){
                String line = scan.nextLine();
                System.out.println(line);
            }
        }catch (Exception e){}
    }
	
}