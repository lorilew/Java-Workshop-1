package predictive;

import static org.junit.Assert.*;

import org.junit.Test;

public class Worksheet3WordSigTest {
	ListDictionary d = new ListDictionary();
	/**
	 * Testing WordSig(String word)
	 */
	@Test
	public void WordSigTest1() {
		WordSig test = new WordSig("home");
		String expected = "4663";
		String result = test.getSignature();
		assertEquals(expected, result);
	}
	/**
	 * Testing WordSig(String word) - empty
	 */
	@Test
	public void WordSigTest2() {
		WordSig test = new WordSig("");
		String expected = "";
		String result = test.getSignature();
		assertEquals(expected, result);
	}
	/**
	 * Testing WordSig(String word, String sig) - testing getSignature
	 */
	@Test
	public void WordSigTest3() {
		WordSig test = new WordSig("home", "123");
		String expected = "123";
		String result = test.getSignature();
		assertEquals(expected, result);
	}
	/**
	 * Testing WordSig(String word, String sig) - testing getWord
	 */
	@Test
	public void WordSigTest4() {
		WordSig test = new WordSig("home", "123");
		String expected = "home";
		String result = test.getWord();
		assertEquals(expected, result);
	}
	///////////////////////////////////////////////////////////////////////
	/**
	 * Testing WordSig toString()
	 */
	@Test
	public void WordSigTest5() {
		WordSig test = new WordSig("home", "123");
		String expected = "home : 123";
		String result = test.toString();
		assertEquals(expected, result);
	}
	/**
	 * Testing WordSig equals - identical
	 */
	@Test
	public void WordSigTest6() {
		WordSig test = new WordSig("home", "123");
		WordSig test2 = new WordSig("home", "123");
		assertTrue(test.equals(test2));
	}
	/**
	 * Testing WordSig equals - same sigs, diff word
	 */
	@Test
	public void WordSigTest7() {
		WordSig test = new WordSig("hello", "123");
		WordSig test2 = new WordSig("home", "123");
		assertTrue(test.equals(test2));
	}
	/**
	 * Testing WordSig equals - same word, diff sigs
	 */
	@Test
	public void WordSigTest8() {
		WordSig test = new WordSig("home", "2345");
		WordSig test2 = new WordSig("home", "123");
		assertFalse(test.equals(test2));
	}
	/**
	 * Testing WordSig compareTo - more than
	 */
	@Test
	public void WordSigTest9() {
		WordSig test = new WordSig("home", "2345");
		WordSig test2 = new WordSig("home", "123");
		int result = test.compareTo(test2);
		int expected = 1;
		assertEquals(result, expected);
	}
	/**
	 * Testing WordSig compareTo - less than
	 */
	@Test
	public void WordSigTest10() {
		WordSig test = new WordSig("home", "23");
		WordSig test2 = new WordSig("home", "123");
		int result = test.compareTo(test2);
		int expected = -1;
		assertEquals(result, expected);
	}
	/**
	 * Testing WordSig compareTo - same
	 */
	@Test
	public void WordSigTest11() {
		WordSig test = new WordSig("home", "123");
		WordSig test2 = new WordSig("home", "123");
		int result = test.compareTo(test2);
		int expected = 0;
		assertEquals(result, expected);
	}

}
