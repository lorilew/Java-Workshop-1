package predictive;

import java.util.ArrayList;


public class Sigs2WordsList {
	public static void main(String[] args) {
		ListDictionary d = new ListDictionary();
for (String s: args) {
			
            System.out.print(s + " : ");
            @SuppressWarnings("unchecked")
			ArrayList<String> set = (ArrayList<String>) d.signatureToWords(s);
            for(String word:set){
            	System.out.print(word + " ");
            }
            System.out.println();
        }
	}
	
}
