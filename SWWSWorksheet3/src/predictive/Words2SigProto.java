// NEED TO: change format for set words.

package predictive;

public class Words2SigProto {
	public static void main(String[] args) {
		for (String s: args) {
            System.out.println(s + " : " + PredictivePrototype.wordToSignature(s));
        }
	}

}
