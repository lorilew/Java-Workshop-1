package predictive;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PredictivePrototype {
	/**
	 * Keyboard layout for phone.
	 * +----+----+----+
	 * | 1  | 2  | 3  |
	 * |    |abc |def |
	 * +----+----+----+
	 * | 4  | 5  | 6  |
	 * |ghi |jkl |mno |
	 * +----+----+----+
	 * | 7  | 8  | 9  |
	 * |pqrs|tuv |wxyz|
	 * +----+----+----+
	 * 
	 * wordToSigniture() takes a word and returns a numeric signature as shown
	 * in the table above.
	 * 
	 * If the word has any non-alphabetic characters, it replaces them with
	 * a " " (space) in the resulting string. 
	 * 
	 * This method uses a bufferedString, as it is more efficient
	 * than just appending to a string. A String is an immutable object, 
	 * so every time it is "appended" a new String object is created, and the old String 
	 * object is left for GC. It takes more time to create a new object rather than change 
	 * an existing one. The bufferedString method just creates a single object, 
	 * which is mutable.
	 * 
	 * @param word A String containing a single word.
	 * @return A string representing the numeric signature of word.
	 */
	public static String wordToSignature(String word){
		StringBuffer buffer = new StringBuffer();
		word = word.toLowerCase();
		int letter;
		for(int i=0; i<word.length(); i++){
			// convert letter to numeric value a=0:z=25
			letter = word.charAt(i)-97;
			// if letters are not a:z replace with a SPACE
			if(letter<0 || letter > 25){
				buffer.append(" ");
			// for letters a:r
			}else if(letter<17){
				buffer.append(letter/3+2);
			// for letters s:y
			}else if(letter <25){
				buffer.append((letter-1)/3+2);
			// for z
			}else{
				buffer.append(9);
			}
		}
		return buffer.toString();
	}
	/**
	 * Given a numeric signature this method searches through a dictionary found in
	 * usr/share/dict/words and returns the list of possible matching words.
	 * The returned list is all lower case possible matches.
	 * 
	 * This method is inefficient because it has to open the file 'words' and 
	 * check every single word in the dictionary each time the method is called.
	 * (for each word it needs to predict). IO processes are quite slow in comparison
	 * to accessing data from stored variables.
	 * 
	 * @param signature A string of numbers representing the numeric signature of a word.
	 * @return A set of strings of all possible word matches.
	 */
	public static Set<String> signatureToWords(String signature){
		HashSet<String> sigMatches = new HashSet<String>();
		BufferedReader reader = null;
		
		try {
		    File file = new File("/usr/share/dict/words");
		    reader = new BufferedReader(new FileReader(file));

		    String line;
		    while ((line = reader.readLine()) != null) {
		        //System.out.println(line);
		    	if(line.length()==signature.length() && isValidWord(line)){
		    		if(wordToSignature(line).equals(signature)){
		    			line = line.toLowerCase();
		    			if(!(sigMatches.contains(line)))
		    				sigMatches.add(line);
		    		}
		    	}
		    }

		} catch (IOException e) {
		    System.out.println("Words file has not been found.");
		} finally {
		    try {
		        reader.close();
		    } catch (IOException e) {
		        System.out.println("An error occured when trying to close Words file.");
		    }
		}
		return sigMatches;
	}
	/**
	 * This method returns a boolean indicating that the given string is a valid word and 
	 * does not contain non-alphabetical characters.
	 * @param word A string containing a single word.
	 * @return A boolean indicating whether the word given is valid.
	 */
	protected static boolean isValidWord(String word){
		word = word.toLowerCase();
		char check;
		for(int i=0; i<word.length(); i++){
			check = word.charAt(i);
			if((check<97 || check>122)){
				return false;
			}
		}
		return true;
	}
}
