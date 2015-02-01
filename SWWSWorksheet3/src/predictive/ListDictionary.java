package predictive;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * This class holds is a dictionary that stores words and their signatures in an
 * ArrayList.
 * 
 * @author lxl667
 * @version 2015-01-29
 */
public class ListDictionary {
	private ArrayList<WordSig> dict;

	/**
	 * This constructs a new ListDictionary Object. It sets dict to a new
	 * ArrayList for the words and signatures to be stored as pairs in a WordSig
	 * object. This words are read from the dictionary file 'words' found in
	 * /usr/share/dict. If the word is invalid, it will not add to list. The
	 * list is then sorted by signature in a natural order using the Collections
	 * sort method. Warning: Duplicates exist in dictionary.
	 * 
	 * @param filename
	 */
	public ListDictionary() {
		
		BufferedReader reader = null;
		dict = new ArrayList<WordSig>();
		
		try {
			File file = new File("/usr/share/dict/words");
			reader = new BufferedReader(new FileReader(file));
			
			// Line of dictionary
			String line;
	
			// Loop through file containing list of words.
			while ((line = reader.readLine()) != null) 
			{
				line = line.toLowerCase();
				// If word is valid add to dict.
				if (isValidWord(line))
				{
					dict.add(new WordSig(line));
				}
			}
		} catch (IOException e) {
			System.out.println("File has not been found.");
		} finally {
			try {
				reader.close();
			} catch (IOException e) {
				System.out.println("An error occured when trying to close file ");
			}
		}
		// sort the list by signature ascending
		Collections.sort(dict);
	}

	/**
	 * This method returns the current object's dict variable.
	 * @return ArrayList Dict.
	 */
	public ArrayList<WordSig> getDict() {
		return dict;
	}

	/**
	 * This method prints the dictionary, with one word and it's corresponding
	 * signature per line of output.
	 */
	public void printDict() {
		for (WordSig ws : dict) {
			System.out.println(ws);
		}
	}
	/**
	 * This method searches the dictionary using a binary search method to find a given signature.
	 * The BS returns an index where the  signature can be found in the list. Then this method
	 * checks above and below this index for matching signatures. It adds all words to a List that
	 * have matching signature, and returns the list.
	 * @param sig A String representing the signature to convert to words.
	 * @return A list of Strings type words with matching signatures.
	 */
	public Collection<String> signatureToWords(String sig){
		ArrayList<String> words = new ArrayList<String>();
		WordSig searchSig = new WordSig("", sig);
		
		// use binary search to find signature in dict.
	    //int index = sigSearch(this.dict, 0, this.dict.size()-1, searchSig);
		
		int index = Collections.binarySearch(this.dict, searchSig);
		int max = this.dict.size();
	    if(index >=0){
		    words.add(this.dict.get(index).getWord());
		    
			// once found check above for matching sigs.
		    int tempIndex = index;
		    while(this.dict.get(tempIndex).getSignature().equals(sig)){
		    	if(!(words.contains(this.dict.get(tempIndex).getWord()))){
		    		words.add(this.dict.get(tempIndex).getWord());
		    	}
		    	tempIndex--;
		    	if(tempIndex == -1)
		    		break;
		    }
		    // and check below to check for matching sigs.
		    tempIndex = index;
		    while(this.dict.get(tempIndex).getSignature().equals(sig)){
		    	if(!(words.contains(this.dict.get(tempIndex).getWord()))){
		    		words.add(this.dict.get(tempIndex).getWord());
		    	}
		    	tempIndex++;
		    	if(tempIndex == max)
		    		break;
		    }
	    }
		return words;
	}

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
