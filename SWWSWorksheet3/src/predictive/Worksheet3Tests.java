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
	 * Testing isValidWord(String word)
	 */
	@Test
	public void isValidWordtest1(){
		String word = "hello's";
		assertFalse(PredictivePrototype.isValidWord(word));
	}
	/*
	 * Testing isValidWord(String word)
	 */
	@Test
	public void isValidWordtest2(){
		String word = "Boo";
		assertTrue(PredictivePrototype.isValidWord(word));
	}
	/*
	 * Testing isValidWord(String word)
	 */
	@Test
	public void isValidWordtest3(){
		String word = "";
		assertTrue(PredictivePrototype.isValidWord(word));
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
	 * Testing Word2SigProto class 
	 * VISUAL TEST
	 */
	@Test
    public void verifyParamsForWords2SigProto() {
		System.out.println("Test: Words2SigProto Class");
        Words2SigProto.main(new String[]{"home", "cat"});
        System.out.println();
    }
	/*
	 * Testing Sigs2WordsProto
	 * VISUAL TEST
	 */
	@Test
    public void verifyParamsForSigs2WordsProto() {
		System.out.println("Test: Sigs2WordsProto Class");
        Sigs2WordsProto.main(new String[]{"4663", "228"});
        System.out.println();
    }
}
