/** @author lxl667
 * 
 * This class contains the solution for Worksheet2
 */

public class Worksheet2 
{
	/**
	 * Given a tree of integers a, this method returns a boolean value
	 * indicating whether a is a binary search tree.
	 * A binary search tree is one in which all value lower than the root are
	 * inserted in the left subtree and all higher values are inserted in the
	 * right subtree. And there are no duplicate values;
	 * @param a A tree of integers.
	 * @return A boolean true is 'a' is a binary search tree, else false.
	 */
    public static boolean isSearchTree(Tree a) {
    	// empty tree
    	if(a.empty){
    		return true;
    	}
    	// leaf node
    	else if(a.getLeft().empty && a.getRight().empty){
    		return true;
    	}
    	// only has right subtree
    	else if(a.getLeft().empty){
    		if(a.getRight().getValue()>a.getValue()){
    			return isSearchTree(a.getRight());
    		}else{
    			return false;
    		}
    	}
    	// only as left subtree
    	else if(a.getRight().empty){
    		if(a.getLeft().getValue()<a.getValue()){
    			return isSearchTree(a.getLeft());
    		}else{
    			return false;
    		}
    	}
    	// has both left and right subtrees
    	else{
    		if(a.getLeft().getValue()<a.getValue() &&
    				a.getRight().getValue()>a.getValue()){
    			return isSearchTree(a.getRight()) && isSearchTree(a.getLeft());
    		}else{
    			return false;
    		}
    	}
    }
	/**
	 * Given a tree of integers a, check to see if 
	 * it is height-balanced, returning a boolean value.
	 * @param a A tree of integer values.
	 * @return A boolean value.
	 */
    public static boolean isHeightBalanced(Tree a) {
	    if(a.empty){
			return true;
		}else{
			if(Math.abs(a.getLeft().getHeight()-a.getRight().getHeight())>1){
				return false;
			}else{
				return isHeightBalanced(a.getLeft()) && isHeightBalanced(a.getRight());
			}
//			if(Math.abs(a.getLeft().getHeight()-a.getRight().getHeight())>1){
//				return false;
//			}else{
//				return true;
//			}
		}
    }

    /**
     * Assuming that Tree a is a height-balance tree and that integer x does not
     * already exist in Tree a.
     * This method returns a height-balance tree consisting of all values in Tree a and x.
     * @param x An integer that does not already exist in Tree a.
     * @param a A height-balance tree.
     * @return A height-balance tree.
     */
    public static Tree insertHB(int x, Tree a) {
    	return insert(x,a);
    }
    /**
     * Given a height balance  tree a and a value x that does not already exist in tree.
     * This method will return a new height-balance tree with all values from Tree a including x.
     * @param x An integer value that does not already exist in Tree a.
     * @param a A binary search tree.
     * @return A binary search tree.
     */
    public static Tree insert(int x, Tree a){
    	if(a.empty){
    		return new Tree(x);
    	}
    	else if(x<a.getValue()){
    		return rebalanceTree(new Tree(a.getValue(), insertHB(x, a.getLeft()), a.getRight()));
    	}else{
    		return rebalanceTree( new Tree(a.getValue(), a.getLeft(), insertHB(x,a.getRight())));
    		
    	}
    }
    /**
     * When inserting into a height balance tree, this method is called to check to 
     * see if any subtrees have become unbalanced in the process. Then the method
     * re-balances the tree, and returns the new balanced tree.
     * @param t A height-balance tree that has just had a new value inserted.
     * @return A height-balance tree.
     */
    private static Tree rebalanceTree(Tree t){
    	if(Math.abs(t.getLeft().getHeight()-t.getRight().getHeight())>1){
    		// then unbalanced - needs balancing.
			if(t.getLeft().getHeight()<t.getRight().getHeight()){
				// the right subtree is causing unbalance.
				if(t.getRight().getLeft().getHeight()<t.getRight().getRight().getHeight()){
					// the right subtree of the right subtree is the cause of the unbalance.
					return rightRightRotation(t);
				} else {
					// the left subtree of the right subtree is the cause of the unbalance.
					return rightLeftRotation(t);
				}
			}else{
				// the left subtree is causing the unbalance.
				if(t.getLeft().getLeft().getHeight()<t.getLeft().getRight().getHeight()){
					// the right subtree of the left subtree is the cause of the unbalance.
					return leftRightRotation(t);
				} else {
					// the left subtree of the left subtree is the cause of the unbalance.
					return leftLeftRotation(t);
				}
			}
		}
    	return t;
    }
//    public static Tree deleteHB(Tree a, int x) {
//    }
    /**
     * When inserting into an AVL Tree:
     * If a new value is inserted into the left subtree of the the left subtree and
     * the tree and this causes the tree to be unbalanced use this method. 
     * This method does a single rotation to the right and returns the new rotated tree.
     * Example:
     *      6               2
     *     / \            /   \
     *    2   10   -->   1     6
     *   / \            / \   / \
     *  1   4          0   2 4   10
     * / \     
     *0   2
     * @param a A binary search tree of at least height 3.
     * @return A binary search tree.
     */
    public static Tree leftLeftRotation(Tree a){
    	return new Tree(a.getLeft().getValue(), a.getLeft().getLeft(), new Tree(a.getValue(), a.getLeft().getRight(), a.getRight()));		
    }
    /**
     * When inserting into an AVL Tree:
     * If a new value is inserted into the right subtree of the the right subtree and
     * the tree and this causes the tree to be unbalanced use this method. 
     * This method does a single rotation to the left and returns the new rotated tree.
     * Example:
     *     6          	    10    
     *    / \             /    \  
     *   2   10   -->    6      15
     *      /  \        / \    /  \    
     *     7    15     2   7 13    20
     *          / \ 
     *         13  20
     * @param a A binary search tree of at least height 3.
     * @return A binary search tree.
     */
  
    public static Tree rightRightRotation(Tree a){
    	return new Tree(a.getRight().getValue(), new Tree(a.getValue(), a.getLeft(), a.getRight().getLeft()) , a.getRight().getRight());		
    }
    /**
     * When inserting into an AVL Tree:
     * If a new value is inserted into the right subtree of the the left subtree
     * and this causes the tree to be unbalanced use this method. 
     * This method does a double rotation. First rotates the left subtree left, then the
     * whole tree to the right.
     * Example:
     *      6              6             4
     *     / \            / \          /   \
     *    2   10   -->   4   10  -->  2     6
     *   / \            / \          / \   / \
     *  1   4          2   5        1   3 5  10
     *     / \        / \
     *    3   5      1   3
     * @param a A binary search tree of at least height 3.
     * @return A binary search tree.
     */
    public static Tree leftRightRotation(Tree a){
    	return leftLeftRotation(new Tree(a.getValue(), rightRightRotation(a.getLeft()), a.getRight()));		
    }
    /**
     * When inserting into an AVL Tree:
     * If a new value is inserted into the left subtree of the right subtree and
     * this causes the tree to be unbalanced use this method. 
     * This method does a double rotation. First rotates the right subtree right, then the
     * whole tree to the left.
     * Example:
     *     6             6                 8
     *    / \           / \              /   \  
     *   2   10    --> 2   8      -->   6     10
     *      /  \          / \          / \   /  \
     *     8    20       7  10        2   7 9    20
     *    / \              /  \    
     *   7   9            9    20
     * @param a A binary search tree of at least height 3.
     * @return A binary search tree .
     */
    public static Tree rightLeftRotation(Tree a){
    	return rightRightRotation(new Tree(a.getValue(), a.getLeft(), leftLeftRotation(a.getRight())));		
    }
    
    
}