package predictive;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class Worksheet3Tests {
	/*
	 * Testing word to Signature method - empty string
	 */
	@Test
	public void ex1test1() {
		String word = "";
		String expected = "";
		assertEquals(expected, PredictivePrototype.wordToSignature(word));
	}
	/*
	 * Testing word to Signature method - space
	 */
	@Test
	public void ex1test2() {
		String word = " ";
		String expected = " ";
		assertEquals(expected, PredictivePrototype.wordToSignature(word));
	}
	/*
	 * Testing word to Signature method - expected string lowercase
	 */
	@Test
	public void ex1test3() {
		String word = "abcdefghijklmnopqrstuvwxyz";
		String expected = "22233344455566677778889999";
		assertEquals(expected, PredictivePrototype.wordToSignature(word));
	}
	/*
	 * Testing word to Signature method - expected string uppercase
	 */
	@Test
	public void ex1test4() {
		String word = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String expected = "22233344455566677778889999";
		assertEquals(expected, PredictivePrototype.wordToSignature(word));
	}
	/*
	 * Testing word to Signature method - non-/alphabetical mixed 
	 */
	@Test
	public void ex1test5() {
		String word = "h&m";
		String expected = "4 6";
		assertEquals(expected, PredictivePrototype.wordToSignature(word));
	}
//////////////////////////////////////////////////////////////////////////
	/*
	 * Testing signatureToWords() 
	 */
	@Test
	public void ex2test1() {
		String sig = "2";
		HashSet<String> expected = new HashSet<String>();
		expected.add("a");
		expected.add("b");
		expected.add("c");
		Set<String> result = PredictivePrototype.signatureToWords(sig);
		assertEquals(expected, result);
	}
	/*
	 * Testing signatureToWords()  empty string
	 */
	@Test
	public void ex2test2() {
		String sig = "";
		HashSet<String> expected = new HashSet<String>();
		Set<String> result = PredictivePrototype.signatureToWords(sig);
		assertEquals(expected, result);
	}
	/*
	 * Testing signatureToWords() invalid signature
	 */
	@Test
	public void ex2test3() {
		String sig = "1";
		HashSet<String> expected = new HashSet<String>();
		Set<String> result = PredictivePrototype.signatureToWords(sig);
		assertEquals(expected, result);
	}
	/*
	 * Testing signatureToWords() "4663" - "home"
	 */
	@Test
	public void ex2test4() {
		String sig = "4663";
		HashSet<String> expected = new HashSet<String>();
		expected.add("good");
		expected.add("home");
		expected.add("gone");
		expected.add("hood");
		expected.add("hone");
		expected.add("goof");
		expected.add("hoof");
		Set<String> result = PredictivePrototype.signatureToWords(sig);
		assertEquals(expected, result);
	}
	///////////////////////////////////////////////////////////
	/*
	 * Testing Words2SigProto class
	 */
	@Test
    public void shouldVerifyParameters() {
        Words2SigProto.main(new String[]{"home", "cat"});
        
    }
}
