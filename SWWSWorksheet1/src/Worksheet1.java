/** @author lxl667
 * 
 * This class contains the solution for Worksheet1
 */

public class Worksheet1 {
	/**
	 * Given a list of integers a,
	 * checks all values in List, if all positive (>=0) 
	 * returns a boolean true, else returns a boolean false.
	 * @param a The list of integers.
	 * @return A boolean true if all values are positive, else false.
	 */
	public static boolean allPositive(List a) {
		if(a.isEmpty()){
			throw new IllegalStateException();
		}
		else if(a.getTail().isEmpty()){
			if(a.getHead()>=0){
				return true;
			}
			return false;
		}
		else{
			if(a.getHead()>=0){
				return true && allPositive(a.getTail());
			}
			return false;
		}
	}
	/**
	 * Given a List of integers a, this method returns a boolean value
	 * indicating whether a is sorted in ascending order.
	 * It may contain duplicate values.
	 * @param a A list of integers.
	 * @return A boolean indicating whether list is sorted.
	 */
	public static boolean sorted(List a){
		if(a.isEmpty()){
			throw new IllegalStateException();
		}
		else if(a.getTail().isEmpty()){
			return true;
		}
		else{
			if(a.getHead()<=a.getTail().getHead()){
				return true && sorted(a.getTail());
			}
			return false;
		}
	}
	/**
	 * REQUIRED: a and b must be sorted lists of integers.
	 * Given two sorted lists a and b, the method returns a new sorted list
	 * that contains all the elements of a and b, any duplicate copies of
	 * elements in a or b or their combination are retained.
	 * Example:
	 * a: [2,5,5,8] b: [5,7,8,9]  ==> [2,5,5,5,7,8,8,9]
	 * @param a A sorted list of integers.
	 * @param b A sorted list of integers.
	 * @return A new sorted list containing all elements from a and b.
	 */
	public static List merge(List a, List b) {
		if(!a.isEmpty() && !b.isEmpty() && !sorted(a) && !sorted(b)){
			throw new IllegalStateException();
		} else {
			return auxMerge(a,b);
		}
		
		
	}
	private static List auxMerge(List a, List b){
		if(a.isEmpty()){
			return b;
		}
		else if(b.isEmpty()){
			return a;
		}
		else if(a.getHead()<b.getHead()){
			return List.cons(a.getHead(), auxMerge(a.getTail(),b));
		}
		else{
			return List.cons(b.getHead(), auxMerge(a, b.getTail()));
		}
	}
	
	
	/**
	 * Given a sorted List, this method returns a copy of the list a with all
	 * its duplicate copies removed.
	 * @param a
	 * @return
	 */
	public static List removeDuplicates(List a) {
		if(a.isEmpty()){
			throw new IllegalStateException();
		}
		else if(a.getTail().isEmpty()){
			return a;
		}
		else{
			if(a.getHead()==a.getTail().getHead()){
				return removeDuplicates(a.getTail());
			}else{
				return List.cons(a.getHead(), removeDuplicates(a.getTail()));
			}
		}
	}

//	public static Tree mirror(Tree t) {
//	}
//
//	public static String showDescending(Tree a) {
//	}
//
//	public static int max(Tree a) {
//	}
//
//	public static Tree delete(Tree a, int x) {
//	}
	

}