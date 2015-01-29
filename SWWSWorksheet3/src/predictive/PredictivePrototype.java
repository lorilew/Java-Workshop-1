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
		    	if(line.length()==signature.length()){
		    		if(wordToSignature(line).equals(signature)){
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
	public static void main(String[] args) {
		
		System.out.println(signatureToWords(wordToSignature("william")));
	}
}