import static org.junit.Assert.*;

import org.junit.Test;

/** @author 
 * 
 * This class contains the test cases for Worksheet1 solutions.
 */
public class Worksheet1Test {
	
	@Test
	/*
	 * Testing allPositive(List a) with empty List.
	 */
	public void ex1test1(){
		List a = List.empty();
		try{
			Worksheet1.allPositive(a);
			assert(false);
		} catch (IllegalStateException e){
			assert(true);
		}
	}
	@Test
	/*
	 * Testing allPositive(List a) with value 0.
	 */
	public void ex1test2(){
		List a = List.cons(0, List.empty());
		boolean result = Worksheet1.allPositive(a);
		assertTrue(result);
	}
	@Test
	/*
	 * Testing allPositive(List a) with value 1 , 2, 3.
	 */
	public void ex1test3(){
		List a = List.cons(1,List.cons(3, List.cons(2,List.empty())));
		boolean result = Worksheet1.allPositive(a);
		assertTrue(result);
	}
	/*
	 * Testing allPositive(List a) with value 1 , -2, 3.
	 */
	public void ex1test4(){
		List a = List.cons(1,List.cons(3, List.cons(-2,List.empty())));
		boolean result = Worksheet1.allPositive(a);
		assertFalse(result);
	}
	/*
	 * Testing allPositive(List a) with value -1 , -2, 3.
	 */
	public void ex1test5(){
		List a = List.cons(-1,List.cons(3, List.cons(-2,List.empty())));
		boolean result = Worksheet1.allPositive(a);
		assertFalse(result);
	}
	/*
	 * Testing allPositive(List a) with value -1 , 0, -3.
	 */
	public void ex1test6(){
		List a = List.cons(-1,List.cons(3, List.cons(0,List.empty())));
		boolean result = Worksheet1.allPositive(a);
		assertFalse(result);
	}
	/////////////////////////////////////////////////////////////////////////
	

}
