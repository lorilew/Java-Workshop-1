package predictive;

import static org.junit.Assert.*;

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

}
