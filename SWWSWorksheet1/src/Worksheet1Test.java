import static org.junit.Assert.*;

import org.junit.Test;

/** @author 
 * 
 * This class contains the test cases for Worksheet1 solutions.
 */
public class Worksheet1Test {
	
	
	/*
	 * Testing allPositive(List a) with empty List.
	 */
	@Test
	public void ex1test1(){
		List a = List.empty();
		try{
			Worksheet1.allPositive(a);
			assert(false);
		} catch (IllegalStateException e){
			assert(true);
		}
	}
	
	/*
	 * Testing allPositive(List a) with value 0.
	 */
	@Test
	public void ex1test2(){
		List a = List.cons(0, List.empty());
		boolean result = Worksheet1.allPositive(a);
		assertTrue(result);
	}
	
	/*
	 * Testing allPositive(List a) with value 1 , 2, 3.
	 */
	@Test
	public void ex1test3(){
		List a = List.cons(1,List.cons(3, List.cons(2,List.empty())));
		boolean result = Worksheet1.allPositive(a);
		assertTrue(result);
	}
	/*
	 * Testing allPositive(List a) with value 1 , -2, 3.
	 */
	@Test
	public void ex1test4(){
		List a = List.cons(1,List.cons(3, List.cons(-2,List.empty())));
		boolean result = Worksheet1.allPositive(a);
		assertFalse(result);
	}
	/*
	 * Testing allPositive(List a) with value -1 , -2, 3.
	 */
	@Test
	public void ex1test5(){
		List a = List.cons(-1,List.cons(3, List.cons(-2,List.empty())));
		boolean result = Worksheet1.allPositive(a);
		assertFalse(result);
	}
	/*
	 * Testing allPositive(List a) with value -1 , 0, -3.
	 */
	@Test
	public void ex1test6(){
		List a = List.cons(-1,List.cons(3, List.cons(0,List.empty())));
		boolean result = Worksheet1.allPositive(a);
		assertFalse(result);
	}
	/////////////////////////////////////////////////////////////////////////
	/*
	 * Testing sorted(List a) with empty list
	 */
	@Test
	public void ex2test1(){
		List a = List.empty();
		try{
			Worksheet1.sorted(a);
			assert(false);
		} catch (IllegalStateException e){
			assert(true);
		}
	}
	/*
	 * Testing sorted(List a) with single value list.
	 */
	@Test
	public void ex2test2(){
		List a = List.cons(1, List.empty());
		boolean result = Worksheet1.sorted(a);
		assertTrue(result);
	}
	/*
	 * Testing sorted(List a) with sorted value list.
	 */
	@Test
	public void ex2test3(){
		List a = List.cons(1, List.cons(3, List.empty()));
		boolean result = Worksheet1.sorted(a);
		assertTrue(result);
	}
	/*
	 * Testing sorted(List a) with unsorted value list.
	 */
	@Test
	public void ex2test4(){
		List a = List.cons(3, List.cons(1, List.cons(5,List.empty())));
		boolean result = Worksheet1.sorted(a);
		assertFalse(result);
	}
	/*
	 * Testing sorted(List a) with sorted value list with negatives.
	 */
	@Test
	public void ex2test5(){
		List a = List.cons(-3, List.cons(-1, List.cons(5,List.empty())));
		boolean result = Worksheet1.sorted(a);
		assertTrue(result);
	}
	/*
	 * Testing sorted(List a) with sorted value list with duplicates.
	 */
	@Test
	public void ex2test6(){
		List a = List.cons(-3, List.cons(-3, List.cons(5,List.empty())));
		boolean result = Worksheet1.sorted(a);
		assertTrue(result);
	}
	///////////////////////////////////////////////////////////////////////////
	/*
	 * Testing merge(List a, List b) with two empty lists.
	 */
	@Test
	public void ex3test1(){
		List a = List.empty();
		List b = List.empty();
		List expected = List.empty();
		List result = Worksheet1.merge(a,b);
		assertEquals(expected, result);
	}
	/*
	 * Testing merge(List a, List b) with one empty list.
	 */
	@Test
	public void ex3test2(){
		List a = List.cons(1,List.cons(2,List.empty()));
		List b = List.empty();
		List expected = a;
		List result = Worksheet1.merge(a,b);
		assertEquals(expected, result);
	}
	/*
	 * Testing merge(List a, List b) with one empty list.
	 */
	@Test
	public void ex3test3(){
		List b = List.cons(1,List.cons(2,List.empty()));
		List a = List.empty();
		List expected = b;
		List result = Worksheet1.merge(a,b);
		assertEquals(expected, result);
	}
	/*
	 * Testing merge(List a, List b).
	 */
	@Test
	public void ex3test4(){
		
		List b = List.cons(1, List.cons(3,List.empty()));
		List a = List.cons(2, List.cons(4,List.empty()));
		
		List expected = List.cons(1, List.cons(2, List.cons(3, List.cons(4, List.empty()))));
		List result = Worksheet1.merge(a,b);
		System.out.println(Worksheet1.merge(a,b));
		assertEquals(expected, result);
	}
	/*
	 * Testing merge(List a, List b). UNSORTED LIST
	 */
	@Test
	public void ex3test5(){
		
		List b = List.cons(7, List.cons(3,List.empty()));
		List a = List.cons(2, List.cons(4,List.empty()));
		try{
			Worksheet1.merge(a, b);
			assert(false);
		} catch (IllegalStateException e) {
			assert(true);
		}
	}
}
