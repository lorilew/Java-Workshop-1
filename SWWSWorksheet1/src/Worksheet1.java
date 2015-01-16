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
	/**
	 * Given a Tree t, constructs a new Tree that is the mirror image of t
	 * along the left-right axis.
	 * @param t A Tree of integers.
	 * @return A new Tree that is the mirror image of t.
	 */
	public static Tree mirror(Tree t) {
		if(t.getEmpty()){
			return new Tree();
		} else {
			return new Tree(t.getValue(),mirror(t.getRight()), mirror(t.getLeft()));
		}
	}
	/**
	 * REQUIRED: The tree is a binary search tree, lower values on the left
	 * and higher values on the right.
	 * Given a Binary Search Tree a, this methods writes a string containing all
	 * the values of the tree in descending order.
	 * Example: 5 4 3 2 1
	 * @param a A binary search tree of integer values.
	 * @return A string of all values stored in tree, in descending order.
	 */
	public static String showDescending(Tree a) {
		if(a.empty){
			return "";
		} else {
			return "" + showDescending(a.getRight()) + a.getValue() + " "  + showDescending(a.getLeft());
		}
	}
	/**
	 * REQUIRED: The tree is a binary search tree, lower values on the left
	 * and higher values on the right.
	 * Assuming the Tree a is a binary search tree, this method returns the max
	 * value of the tree.
	 * @param a A binary search tree of integer values.
	 * @return The max value in tree.
	 */
	public static int max(Tree a) {
		if(a.empty){
			throw new IllegalStateException();
		}
		else if(a.getRight().empty){
			return a.getValue();
		}else{
			return Math.max(a.getValue(), max(a.getRight()));
		}
	}
	/**
	 * REQUIRED: The tree is a binary search tree, lower values on the left
	 * and higher values on the right.
	 * Assuming a is a binary search tree, this method deletes the value x
	 * from a and returns the resulting tree. 
	 * If the value x does not exist in tree, an exception is thrown.
	 * @param a A binary search tree of integer values.
	 * @param x an integer value to be removed from tree a.
	 * @return A new tree of the results of removing x from a.
	 */
	public static Tree delete(Tree a, int x) {
		if(a.empty){
			throw new IllegalStateException(x + " does not exist in tree " + a);
		}
		else if(x<a.getValue()){
			return new Tree(a.getValue(), delete(a.getLeft(), x), a.getRight());
		}
		else if(x>a.getValue()){
			return new Tree(a.getValue(), a.getLeft(), delete(a.getRight(), x));
		}else{
			// found x!
			// if x has no children
			if(a.getLeft().empty && a.getRight().empty){
				return new Tree();
			}
			// if x has one child
			else if(a.getLeft().empty){
				return a.getRight();
			}
			else if(a.getRight().empty){
				return a.getLeft();
			}
			// if x has two children
			else{
				return new Tree(max(a), a.getLeft(), 
						delete(a.getRight(), max(a)));
			}
		}
	}
	

}