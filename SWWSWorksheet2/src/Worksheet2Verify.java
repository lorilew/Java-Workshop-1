import static org.junit.Assert.*;
import org.junit.Test;
/**
 * @author Alexandros Evangelidis
 * 
 * This class contains one simple test for each exercise,and is for
 * verification purposes only.
 * 
 * Do not change or modify this file. You should use the Worksheet2Test
 * class for your tests.
 *
 */
public class Worksheet2Verify {

	@Test
	/**
	 * Ex1 test 1 - balanced tree
	 */
	public void ex1test1() {
		Tree t1 = new Tree(15, 
						
							//left subtree
							new Tree(3,
									 new Tree(1),new Tree(4)), 
		                     
		                     //right subtree
		                     new Tree(20, 
		                    		  new Tree(17),new Tree()));
			
		assertTrue(Worksheet2.isHeightBalanced(t1));
	}	

	@Test
	/**
	 * Ex2 test 1 - search tree 
	 */
	public void ex2test1() {
		
		Tree t1 = new Tree(15, 
				
						   //left subtree
				           new Tree(3,
						            new Tree(1),new Tree(4)), 
                 
                            //right subtree
                            new Tree(20, 
                		             new Tree(17),new Tree()));

		assertTrue(Worksheet2.isSearchTree(t1));
		
	}	
	
	@Test
	/**
	 * Ex3 test 1 - insertion in AVL 
	 */
	public void ex3test1() {
		
		Tree t1 = new Tree(15, 
						
						    //left subtree    				
						    new Tree(3, 
								     new Tree(1),new Tree(4)), 
						
						    //right subtree
						    new Tree(20, 
								     new Tree(17),new Tree()));
		
		//inserting 16 violates the height-balanced property
	
		Tree t2 = Worksheet2.insertHB(16, t1);
		
		Tree expected =  new Tree(15,
				
								  //left subtree
								  new Tree(3, 
										   new Tree(1),new Tree(4)), 
													
							      //right subtree
							      new Tree(17, 
							    		  new Tree(16), new Tree(20)));
			
		
		assertEquals(expected,t2);		
	}	

	@Test
	/**
	 * Ex4 test 1 - deletion in AVL 
	 */
	public void ex4test1() {
		Tree t1 =  new Tree(15, 
							
							//left subtree
							new Tree(3, 
									new Tree(2, new Tree(1),new Tree()), 
									
									//to the right of 3
									new Tree(4)), 
							
							 //right subtree
							 new Tree(17, 
									 new Tree(16), new Tree(20)));
			
		//deleting 15 violates the height-balanced property
	
		Tree t2 = Worksheet2.deleteHB(t1, 15);
	
		Tree expected = new Tree(4,
								
								 //left subtree 
							     new Tree(2,
							    		  new Tree(1),new Tree(3)), 
							     
							     //right subtree
							     new Tree(17, 
							    		  new Tree(16), new Tree(20)));
	
		assertEquals(expected,t2);
		
	}	
}