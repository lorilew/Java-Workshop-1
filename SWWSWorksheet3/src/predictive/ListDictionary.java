package predictive;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
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
				if (PredictivePrototype.isValidWord(line))
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
	public ArrayList<String> signatureToWords(String sig){
		ArrayList<String> words = new ArrayList<String>();
		WordSig searchSig = new WordSig("", sig);
		
		// use binary search to find signature in dict.
	    //int index = sigSearch(this.dict, 0, this.dict.size()-1, searchSig);
		int index = Collections.binarySearch(this.dict, searchSig);
	    if(index >=0){
		    words.add(this.dict.get(index).getWord());
		    
			// once found check above for matching sigs.
		    int tempIndex = index;
		    while(this.dict.get(tempIndex).getSignature().equals(sig)){
		    	if(!(words.contains(this.dict.get(tempIndex).getWord()))){
		    		words.add(this.dict.get(tempIndex).getWord());
		    	}
		    	tempIndex--;
		    }
		    // and check below to check for matching sigs.
		    tempIndex = index;
		    while(this.dict.get(tempIndex).getSignature().equals(sig)){
		    	if(!(words.contains(this.dict.get(tempIndex).getWord()))){
		    		words.add(this.dict.get(tempIndex).getWord());
		    	}
		    	tempIndex++;
		    }
	    }
		return words;
	}
	/**
	 * This method uses binary search to find the index of the given signature.
	 * If there are duplicate entries with the same signature, it could be any of them.
	 * @param dict An arrayList of WordSigs containing all the words in the dictionary.
	 * @param start The index number of the start of the search area.
	 * @param end The index number of the end of the search area.
	 * @param sig The String value of the signature being searched.
	 * @return The index of the element in the list that contains the given sig.
	 */
//	private static int sigSearch(ArrayList<WordSig> dict, int start, int end, WordSig sig){
//		int middle = (end-start)/2 + start;
//		WordSig temp = new WordSig("", dict.get(middle).getSignature());
//		if(end-start == 1){
//			return -1;
//		}else if(sig.compareTo(temp)==0){
//			return middle;
//		}else if(sig.compareTo(temp)<1){
//			return sigSearch(dict, start, middle, sig);
//		}else{
//			return sigSearch(dict, middle, end, sig);
//		}
//	}
	

}
