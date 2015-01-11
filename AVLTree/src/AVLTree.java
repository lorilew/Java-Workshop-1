
public class AVLTree {
	private Person root;
	private boolean isEmpty;
	private AVLTree left;
	private AVLTree right;
	/**
	 * Create a new AVL tree with a root of Person root. 
	 * Left and Right refer to empty AVL trees.
	 * @param root
	 */
	public AVLTree(Person root){
		this.isEmpty = false;
		this.root = root;
		this.left = empty();
		this.right = empty();
	}
	/**
	 * Creates an empty AVLTree with isEmpty set to true, 
	 * and all other instance variables default values.
	 */
	public AVLTree(){
		this.isEmpty = true;
	}
	public static AVLTree empty(){
		return new AVLTree();
	}
	public Person getRoot() {
		return root;
	}
	public void setRoot(Person root) {
		this.root = root;
	}
	public boolean isEmpty() {
		return isEmpty;
	}
	public void setEmpty(boolean isEmpty) {
		this.isEmpty = isEmpty;
	}
	public AVLTree getLeft() {
		return left;
	}
	public void setLeft(AVLTree left) {
		this.left = left;
	}
	public AVLTree getRight() {
		return right;
	}
	public void setRight(AVLTree right) {
		this.right = right;
	}
	public boolean rootEquals(AVLTree other){
		if(this.getRoot()==other.getRoot()){
			return true;
		}
		return false;
	}
	public String toString(){
		return toStringAux(this,0);
	}
	public static String toStringAux(AVLTree tree, int n){
		if(tree.isEmpty() == true){
			return "\nnull";
		} else {
			return "\n" + bar(n) + tree.getRoot() + toStringAux(tree.getLeft(), n+1) + toStringAux(tree.getRight(), n+1);
		}
	}
	public static String bar(int n){
		String bar = "";
		for(int i=0; i<n; i++){
			bar += "|";
		}
		return bar;
	}
	public void add(Person p){
		addAux(this,p);
	}
	public static void addAux(AVLTree tree, Person p){
		if(tree.isEmpty()){
			tree = new AVLTree(p);
			
		} 
		else if(p.getName().compareToIgnoreCase(tree.getRoot().getName())<0){
			if(tree.getLeft().isEmpty()){
				tree.setLeft(new AVLTree(p));
				
			} else {
				addAux(tree.getLeft(), p);
				
			}
		}
		else {
			if(tree.getRight().isEmpty()){
				tree.setRight(new AVLTree(p));
			} else {
				addAux(tree.getRight(), p);
			}
		}
	}
	public static void main(String[] args) {
		Person p = new Person("Lauren", 27);
		Person p1 = new Person("Will", 25);
		Person p2 = new Person("David", 23);
		Person p3 = new Person("Lou", 52);
		AVLTree t = new AVLTree(p);
		t.add(p1);
		t.add(p2);
		t.add(p3);
		System.out.println(t);
	}
}
