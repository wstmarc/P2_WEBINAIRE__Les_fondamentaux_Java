import java.io.IOException;

/**
 * Lauching the file reading.
 * */
public class Application {

    public static void main(String[] args) throws IOException {

    	Reader readinator = new Reader();
    	
    	readinator.fileToRead = "emptyFile";
    	//readinator.fileToRead = "simpleText";
    	//readinator.fileToRead = "symptoms";

    	readinator.readFile();
//    	readinator.readFileLineOccurrenceAndDisplay();
    	
    }
    
}