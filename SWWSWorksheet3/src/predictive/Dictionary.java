package predictive;

import java.util.ArrayList;

public interface Dictionary {
	/**
	 * The signatureToWords method must return all the words that correspond with a given signature.
	 * All words are then returned in an ArrayList of Strings.
	 * @param sig A String of numbers representing a numerical signature of a word.
	 * @return An arrayList of type String containing all the words that correspond to the given sig.
	 */
	public ArrayList<String> signatureToWords(String sig);
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
	
}
