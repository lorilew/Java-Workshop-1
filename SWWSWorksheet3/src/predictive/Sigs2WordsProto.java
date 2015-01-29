package predictive;

import java.util.Set;

public class Sigs2WordsProto {
	public static void main(String[] args) {
		for (String s: args) {
			
            System.out.print(s + " : ");
            Set<String> set = PredictivePrototype.signatureToWords(s);
            for(String word:set){
            	System.out.print(word + " ");
            }
            System.out.println();
        }
	}

}