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
	//////////////////////////////////////////////////////////////
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
	///////////////////////////////////////////////////////////////
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
		
		List expected = List.cons(1, List.cons(2, List.cons(3, 
				List.cons(4, List.empty()))));
		List result = Worksheet1.merge(a,b);
		//System.out.println(Worksheet1.merge(a,b));
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
	//////////////////////////////////////////////////////////////////
	/*
	 * Testing removeDuplicates(List a) - empty list
	 */
	@Test
	public void ex4test1(){
		List a = List.empty();
		try{
			Worksheet1.removeDuplicates(a);
			assert(false);
		} catch (IllegalStateException e){
			assert(true);
		}
	}
	/*
	 * Testing removeDuplicates(List a) - single value list
	 */
	@Test
	public void ex4test2(){
		List a = List.cons(1,List.empty());
		List expected = List.cons(1,List.empty());
		List result = Worksheet1.removeDuplicates(a);
		assertEquals(expected, result);
	}
	/*
	 * Testing removeDuplicates(List a) - two duplicate values
	 */
	@Test
	public void ex4test3(){
		List a = List.cons(1, List.cons(1,List.empty()));
		String expected = List.cons(1,List.empty()).toString();
		String result = Worksheet1.removeDuplicates(a).toString();
		assertEquals(expected, result);
	}
	/*
	 * Testing removeDuplicates(List a) - three duplicate values
	 */
	@Test
	public void ex4test4(){
		List a =  List.cons(2, List.cons(5, List.cons(5, 
				List.cons(5, List.empty()))));
		List expected = List.cons(2, List.cons(5, List.empty()));
		List result = Worksheet1.removeDuplicates(a);
		assertEquals(expected, result);
	}
	/*
	 * Testing removeDuplicates(List a) - no duplicates
	 */
	@Test
	public void ex4test5(){
		List a =  List.cons(1, List.cons(2, List.cons(3, 
				List.cons(4, List.empty()))));
		List expected = List.cons(1, List.cons(2, List.cons(3, 
				List.cons(4, List.empty()))));
		List result = Worksheet1.removeDuplicates(a);
		assertEquals(expected, result);
	}
	/////////////////////////////////////////////////////////////////
	/*
	 * Testing mirror(Tree t) with empty tree
	 */
	@Test
	public void ex5test1(){
		Tree t = new Tree();
		Tree expected = new Tree();
		Tree result = Worksheet1.mirror(t);
		assertEquals(expected, result);
	}
	/*
	 * Testing mirror(Tree t) with single node tree
	 */
	@Test
	public void ex5test2(){
		Tree t = new Tree(1);
		Tree expected = new Tree(1);
		Tree result = Worksheet1.mirror(t);
		assertEquals(expected, result);
	}
	/*
	 * Testing mirror(Tree t) with balanced tree
	 */
	@Test
	public void ex5test3(){
		Tree t = new Tree(7, new Tree(4, new Tree(2), new Tree(5)),
				new Tree(10, new Tree(8), new Tree(15)));
		Tree expected = new Tree(7, new Tree(10, new Tree(15), new Tree(8)),
				new Tree(4, new Tree(5), new Tree(2)));
		Tree result = Worksheet1.mirror(t);
		
		assertEquals(expected, result);
	}
	/*
	 * Testing mirror(Tree t) with unbalanced tree right
	 */
	@Test
	public void ex5test4(){
		Tree t = new Tree(7, new Tree(4, new Tree(2), new Tree(5)),
				new Tree(10));
		Tree expected = new Tree(7, new Tree(10),
				new Tree(4, new Tree(5), new Tree(2)));
		Tree result = Worksheet1.mirror(t);
		
		assertEquals(expected, result);
	}
	/*
	 * Testing mirror(Tree t) with unbalanced tree left
	 */
	@Test
	public void ex5test5(){
		Tree t = new Tree(7, new Tree(4),
				new Tree(10, new Tree(8), new Tree(15)));
		Tree expected = new Tree(7, new Tree(10, new Tree(15), new Tree(8)),
				new Tree(4));
		Tree result = Worksheet1.mirror(t);
		
		assertEquals(expected, result);
	}
	////////////////////////////////////////////////////////////////////////
	/*
	 * Testing showDescending(Tree t) with empty tree
	 */
	@Test
	public void ex6test1(){
		Tree t1 = new Tree();
		try{
			Worksheet1.showDescending(t1);
			assert(false);
		} catch (IllegalStateException e){
			assert(true);
		}
	}
	/*
	 * Testing showDescending(Tree t) single value tree
	 */
	@Test
	public void ex6test2(){
		Tree t2 = new Tree(2);
		String expected = "2";
		String result = Worksheet1.showDescending(t2);
		assertEquals(expected, result);
	}
	/*
	 * Testing showDescending(Tree t) with left subtree
	 */
	@Test
	public void ex6test3(){
		Tree t3 = new Tree(10, new Tree(7, new Tree(3), new Tree(8)), 
				new Tree());
		String expected = "10 8 7 3";
		String result = Worksheet1.showDescending(t3);
		assertEquals(expected, result);
	}
	/*
	 * Testing showDescending(Tree t) with left subtree
	 */
	@Test
	public void ex6test4(){
		Tree t4 = new Tree(10, new Tree(7, new Tree(3), new Tree(8)), 
				new Tree(15, new Tree(14), new Tree(20, new Tree(), 
						new Tree(90))));
		String expected = "90 20 15 14 10 8 7 3";
		String result = Worksheet1.showDescending(t4);
		assertEquals(expected, result);
	}
	//////////////////////////////////////////////////////////////////////
	/*
	 * Testing max(Tree t) exception with empty tree.
	 */
	@Test
	public void ex7test1(){
		Tree t = new Tree();
		try{
			Worksheet1.max(t);
			assert(false);
		} catch (IllegalStateException e){
			assert(true);
		}
	}
	/*
	 * Testing max(Tree t) exception with single value tree.
	 */
	@Test
	public void ex7test2(){
		Tree t = new Tree(1);
		try{
			Worksheet1.max(t);
			assert(true);
		} catch (IllegalStateException e){
			assert(false);
		}
	}
	/*
	 * Testing max(Tree t) with single value tree.
	 */
	@Test
	public void ex7test3(){
		Tree t = new Tree(1);
		int result = Worksheet1.max(t);
		int expected = 1;
		assertEquals(result, expected);
	}
	/*
	 * Testing max(Tree t) .
	 */
	@Test
	public void ex7test4(){
		Tree t = new Tree(20, new Tree(10), new Tree(30));
		int result = Worksheet1.max(t);
		int expected = 30;
		assertEquals(result, expected);
	}
	/*
	 * Testing max(Tree t) .
	 */
	@Test
	public void ex7test5(){
		Tree t = new Tree(20, new Tree(10), new Tree(30, new Tree(25), 
				new Tree(40)));
		int result = Worksheet1.max(t);
		int expected = 40;
		assertEquals(result, expected);
	}
	/*
	 * Testing max(Tree t) .
	 */
	@Test
	public void ex7test6(){
		Tree t = new Tree(20, new Tree(10), new Tree(30, new Tree(25, 
				new Tree(21), new Tree(26)), new Tree(40)));
		int result = Worksheet1.max(t);
		int expected = 40;
		assertEquals(result, expected);
	}
	////////////////////////////////////////////////////////////////////
	/*
	 * Testing delete(Tree a, int x) empty tree
	 */
	@Test
	public void ex8test1(){
		Tree t = new Tree();
		try{
			Worksheet1.delete(t, 1);
			assert(false);
		} catch (IllegalStateException e){
			assert(true);
		}
	}
	/*
	 * Testing delete(Tree a, int x) invalid x
	 */
	@Test
	public void ex8test2(){
		Tree t = new Tree(3);
		try{
			Worksheet1.delete(t, 1);
			assert(false);
		} catch (IllegalStateException e){
			assert(true);
		}
	}
	/*
	 * Testing delete(Tree a, int x) valid x
	 */
	@Test
	public void ex8test3(){
		Tree t = new Tree(3);
		try{
			Worksheet1.delete(t, 3);
			assert(true);
		} catch (IllegalStateException e){
			assert(false);
		}
	}
	/*
	 * Testing delete(Tree a, int x) childless leaf node maximum
	 */
	@Test
	public void ex8test4(){
		Tree t = new Tree(20, new Tree(10), new Tree(30, new Tree(25, 
				new Tree(21), new Tree(26)), new Tree(40)));
		Tree expected = new Tree(20, new Tree(10), new Tree(30, new Tree(25, 
				new Tree(21), new Tree(26)), new Tree()));
		assertEquals(Worksheet1.delete(t,40), expected);
		
	}
	/*
	 * Testing delete(Tree a, int x) childless leaf node
	 */
	@Test
	public void ex8test5(){
		Tree t = new Tree(20, new Tree(10), new Tree(30, new Tree(25, 
				new Tree(21), new Tree(26)), new Tree(40)));
		Tree expected = new Tree(20, new Tree(10), new Tree(30, new Tree(25, 
				new Tree(21), new Tree()), new Tree(40)));
		assertEquals(Worksheet1.delete(t,26), expected);
		
	}
	/*
	 * Testing delete(Tree a, int x) single child leaf node
	 */
	@Test
	public void ex8test6(){
		Tree t = new Tree(20, new Tree(10), new Tree(30, new Tree(25, 
				new Tree(21), new Tree()), new Tree(40)));
		Tree expected = new Tree(20, new Tree(10), new Tree(30, new Tree(21), new Tree(40)));
		assertEquals(Worksheet1.delete(t,25), expected);
		
	}
	/*
	 * Testing delete(Tree a, int x) double child leaf node
	 */
	@Test
	public void ex8test7(){
		Tree t = new Tree(20, new Tree(10), new Tree(30, new Tree(25, 
				new Tree(21), new Tree(26)), new Tree(40)));
		
		Tree expected =  new Tree(20, new Tree(10), new Tree(30, new Tree(21, 
				new Tree(), new Tree(26)), new Tree(40)));
		
		assertEquals(Worksheet1.delete(t,25), expected);
		
	}
	/*
	 * Testing delete(Tree a, int x) double child leaf node
	 */
	@Test
	public void ex8test8(){
		Tree t = new Tree(20, new Tree(10), new Tree(30, new Tree(25, 
				new Tree(21), new Tree(26)), new Tree(40)));
		
		Tree expected =  new Tree(20, new Tree(10), new Tree(26, new Tree(25, new Tree(21), new Tree()), new Tree(40)));
		
		assertEquals(Worksheet1.delete(t,30), expected);
		
	}
	
}
