import java.io.*;
import java.util.*;
import exceptions.*;

/**
 * Manages file reading and the displaying of its content.
 * 
 * @author Wilfried SAINT-MARC
 * */
public class Reader {

    private final String path = ".\\WebinarP2\\src\\resources\\";
    
    //Replace the file name to read here:
    public String fileToRead = "symptoms";

    
    /**
     * Reads a whole file, line after line, and displays its content into console.
     * Null characters are unconsidered as characters.
     * The path (path) and the file name (fileToRead) are specified into the Reader class attributes.
     */
    public void readFile() {
        String completePath = path + fileToRead;
        
        try{
            Scanner scan = new Scanner(new File(completePath));//(it is necessary to read the complete path)
            
            if(scan.hasNextLine() == false) {
        		throw new EmptyFileException("");
        	}
        	
        	while(scan.hasNextLine()) {
        		String line = scan.nextLine();
        		System.out.println(line);
            }
        }
        catch (FileNotFoundException e) {
        	System.err.println("The file was not found !!!");
        	System.err.println("Error : " + e);
        }
        catch (EmptyFileException e) {
        	System.err.println("The file is empty !!!");
        	System.err.println("Error : " + e);
		}
    }
    
    
    /**
     * Reads a whole file, line after line, then stock into a Map<String, Integer> all unique lines and their number of occurrences. 
     * Null characters are unconsidered as characters.
     * The path (path) and the file name (fileToRead) are specified into the Reader class attributes.
     * 
     * @return occurrence : A Map containing, as keys each unique line of the file read, and as values the number of occurrence for each lines.
     */
    public Map<String, Integer> readFileLineOccurrence() {
        String completePath = path + fileToRead;
        
//    	Map<String, Integer> occurrence = new HashMap<>();
    	Map<String, Integer> occurrence = new TreeMap<>();//A TreeMap object naturally (automatically) manages the sorting of its keys. (by alphabetical order).
        
        try{
            Scanner scan = new Scanner(new File(completePath));
        	
        	if(scan.hasNextLine() == false) {
        		throw new EmptyFileException("");
        	}
        	
        	while(scan.hasNextLine()) {
        		String line = scan.nextLine();
        		//Regular expression that checks if the string contains a subsequence composed of, in order:
        		// .*  -> zero or more of any character(s), before,
        		// \d+ -> one or more numbers, (the \\ permit the \ character to be considered as a simple character and not an escape character)
        		// .*  -> and if after this number(s), there is zero or more of any character(s).
        		if(line.matches(".*\\d+.*")) {
                	throw new NotAllowedCharacterException("");
                }
                occurrence.putIfAbsent(line, 0);//Adds text of line into occurrence Map keys, if it doesn't exists there yet; and puts 0 as its value.
                occurrence.put(line, occurrence.get(line) + 1);
            }
        }
        catch (FileNotFoundException e) {
        	System.err.println("The file was not found !!!");
        	System.err.println("Error : " + e);
        }
        catch (EmptyFileException e) {
        	System.err.println("The file is empty !!!");
        	System.err.println("Error : " + e);
		}
        catch (NotAllowedCharacterException e) { 
        	System.err.println("Numbers are not allowed characters !!!");
        	System.err.println("Error : " + e);
        }
        return occurrence;
    }
    
    
    /**
     * Reads a whole file, line after line, then stocks into a Map<String, Integer> all unique lines and their number of occurrences, and finally displays them. 
     * Null characters are unconsidered as characters.
     * */
    public void readFileLineOccurrenceAndDisplay() {
    	displayMap(readFileLineOccurrence());
    }
    
    
    /**
     * Displays each couple key-value of a Map<String, Integer> into the console.
     * 
     * @param mapToDisplay : The map itself.
     */
    public void displayMap(Map<String, Integer> mapToDisplay) {
    	if(!mapToDisplay.isEmpty()) {
    		for(Map.Entry<String, Integer> entry : mapToDisplay.entrySet()) {
        		System.out.print(entry.getValue());
        		System.out.println(" " + entry.getKey().toString());
        	}
    	} else {
    		System.err.println("No line to display.");
    	}
    }
}