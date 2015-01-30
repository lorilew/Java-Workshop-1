package predictive;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.Test;

public class Worksheet3ListDictionaryTest {
	ListDictionary d = new ListDictionary();
	/**
	 * Testing signatureToWords(String sig) - sig exists
	 */
	@Test
	public void ListDictionaryTest1() {
		String test = "4663";
		ArrayList<String> words = d.signatureToWords(test);
		ArrayList<String> expected = new ArrayList<String>();
		expected.add("home");
		expected.add("hoof");
		expected.add("good");
		expected.add("goof");
		expected.add("gone");
		expected.add("hood");
		expected.add("hone");
		Collections.sort(words);
		Collections.sort(expected);
		assertEquals(words, expected);
 	}
	/**
	 * Testing signatureToWords(String sig) - sig does not exists
	 */
	@Test
	public void ListDictionaryTest2() {
		String test = "1111";
		ArrayList<String> words = d.signatureToWords(test);
		System.out.println(words);
		ArrayList<String> expected = new ArrayList<String>();
		assertEquals(words, expected);
 	}

}
