package predictive;

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
	 * If the word has any non-alphabetic characters, it replaces them with
	 * a " " (space) in the resulting string. 
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
