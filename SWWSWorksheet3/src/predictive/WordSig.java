package predictive;

public class WordSig implements Comparable<WordSig> {
	
	private String signature;
	private String word;
	/**
	 * Constructs an WordSig object, which contains a pair of Strings:
	 * word and corresponding signature.
	 * @param word A string containing a single word.
	 */
	public WordSig(String word) {
		this.word = word;
		this.signature = PredictivePrototype.wordToSignature(word);
	}
	public WordSig(String word, String sig) {
		this.word = word;
		this.signature = sig;
	}
	/**
	 * Returns a String of the word contained in WordSig Object
	 * @return A String
	 */
	public String getWord() {
		return word;
	}
	/**
	 * Returns a String of the signature contained in WordSig Object
	 * @return A String
	 */
	public String getSignature() {
		return signature;
	}
	
	/**
	 * Compares this WordSig's signature with the specified WordSig's signature for order.
	 * Returns -1, 0, 1 as this WordSig's signature is less than, equal to or greater than
	 * the specified WordSig's signature.
	 * @param ws A WordSig Object
	 * @return A -1, 0, 1 as this WordSig's signature is less than, equal to or greater than
	 * the specified WordSig's signature.
	 */

	public int compareTo(WordSig ws){
	
		if(this.signature.length()<ws.signature.length()){
			return -1;
		}else if(this.signature.length()>ws.signature.length()){
			return 1;
		}else{
			return this.signature.compareTo(ws.signature);
		}		
		
	}

	/**
	 * This method returns a string representing the word and signature of the WordSig Object.
	 * EXAMPLE: "aaa : 222"
	 */
	@Override
	public String toString() {
		return word + " : " + signature;
	}
	
	/**
	 * Compares this WordSig's signature with given WordSig's signature.
	 * Returns true if the two signatures are the same.
	 * @param other A WordSig Object
	 * @return If signatures of the two WordSig's are equal returns true, else false.
	 */
	public boolean equals(WordSig other) {
		if((this.signature.equals(other.signature))){
			return true;
		}
		return false;
	}
	
	
}
