/** @author lxl667
 * 
 * This class contains the solution for Worksheet1
 */

public class Worksheet1 {
	/**
	 * Given a list of integers a,
	 * checks all values in List, if all positive (>=0) 
	 * returns a boolean true, else returns a boolean false.
	 * @param a The list to check all positive.
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
	 * Given a list of integers a
	 * @param a
	 * @param b
	 * @return
	 */
	public static List merge(List a, List b) {
		
	}
//
//	static List removeDuplicates(List a) {
//	}
//
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