/**
 * This class is to implement binary search tree data structure for medium data size 
 * @author 40165171 Sooah Kil & 40174913 Hyun Soo Kim
 *
 */
public class bst {
	
	/**
	 * inner class node
	 */
	private class node{
		/**
		 * the object of this class has 6 pointers to related nodes and key-value 
		 */
		private String key;
		private String value;
		private node parent;
		private node leftchild;
		private node rightchild;
		private node prev;
		private node next;
		private boolean visited;
			
		/**
		 * default constructor
		 */
		public node() {
			key = null;
			value = null;
			parent = null;
			leftchild = null;
			rightchild = null;
			prev = null;
			next = null;
			visited = false;
		}
		
		/**
		 * parameterized constructor
		 * @param k key String
		 * @param v value String
		 * @param p parent node
		 * @param l left child node
		 * @param r right child node
		 * @param pr previous node
		 * @param n next node
		 * @param vis visited boolean
		 */
		public node(String k, String v, node p, node l, node r, node pr, node n, boolean vis) {
			key = k;
			value = v;
			parent = p;
			leftchild = l;
			rightchild = r;
			prev = pr;
			next = n;
			visited = vis;
		}
		
		/**
		 * check if the node is external
		 * @return true if the node is external
		 */
		public boolean isExternal() {
			return (this.leftchild == null && this.rightchild == null);
		}
		
		/**
		 * check if the node is internal
		 * @return true if the node is internal
		 */
		public boolean isInternal() {
			return (this.leftchild != null || this.rightchild != null);
		}
		
		/**
		 * check if the node is root
		 * @return true if the node is root. root does not have parent
		 */
		public boolean isRoot() {
			return (this.parent == null);
		}
		
		/**
		 * accessor method for key
		 * @return key String
		 */
		public String getKey() {
			return this.key;
		}
		
		/**
		 * accessor method for value
		 * @return value String
		 */
		public String getValue() {
			return this.value;
		}
		
		/**
		 * accessor method for parent
		 * @return parent node
		 */
		public node getParent() {
			return this.parent;
		}
		
		/**
		 * accessor method for left child node
		 * @return left child node
		 */
		public node getLeftChild() {
			return this.leftchild;
		}
		
		/**
		 * accessor method for right child node
		 * @return right child node
		 */
		public node getRightChild() {
			return this.rightchild;
		}
	
		/**
		 * accessor method for previous node
		 * @return previous node
		 */
		public node getPrev() {
			return this.prev;
		}
		
		/**
		 * accessor method for next node
		 * @return next node
		 */
		public node getNext() {
			return this.next;
		}
		
		/**
		 * mutator method for key
		 * @param k for new key 
		 */
		public void setKey(String k) {
			this.key = k;
		}
		
		/**
		 * mutator method for value
		 * @param v for new value
		 */
		public void setValue(String v) {
			this.value = v;
		}

		/**
		 * mutator method for parent
		 * @param p for new parent
		 */
		public void setParent(node p) {
			this.parent = p;
		}
		
		/**
		 * mutator method for left child
		 * @param l for new left child
		 */
		public void setLeftChild(node l) {
			this.leftchild = l;
		}
		
		/**
		 * mutator method for right child
		 * @param r for new right child
		 */
		public void setRightChild(node r) {
			this.rightchild = r;
		}
		
		/**
		 * mutator method for previous node
		 * @param pr for new previous node
		 */
		public void setPrev(node pr) {
			this.prev = pr;
		}
		
		/**
		 * mutator method for next node
		 * @param n for new next ndoe
		 */
		public void setNext(node n)
		{
			this.next = n;
		}
		
		/**
		 * check if the node has left child
		 * @return true if it has the left child
		 */
		public boolean hasLeft() {
			return (this.leftchild != null);
		}
		
		/**
		 * check if the node has right child
		 * @return true if it has the right child
		 */
		public boolean hasRight() {
			return (this.rightchild != null);
		}
		/**
		 * for inorder traversal
		 * @return true if the node has been visited
		 */
		public boolean isVisited() {
			return (this.visited == true); 
		}
	}//end of inner class
	
	private int size;
	private node root;
	private node lastadded;
	
	/**
	 * default constructor
	 */
	public bst() {
		size = 0;
		root = null;
		lastadded = null;
	}
	
	/**
	 * parameterized constructor
	 * @param s int size
	 * @param root node root of the tree
	 * @param lastadded node last added node
	 */
	public bst(int s, node root, node lastadded) {
		this.size = s;
		this.root = root;
		this.lastadded = lastadded;
	}
	
	/**
	 * return the size of the tree -> O(1)
	 * @return
	 */
	public int size() {
		return size;
	}
	
	/**
	 * isEmpty method
	 * @return true if size is 0
	 */
	public boolean isEmpty(){
		return (size == 0);
	}
	
	/**
	 * accessor for root node
	 * @return root node
	 */
	public node root() {
		if(root == null) {
			return null;
		}
		return root;
	}

	/**
	 * method to find the most recently updated node
	 * @return lastadded node of the tree
	 */
	public node lastAdded() {
		if(isEmpty()) {
			return null;
		}
		return lastadded;
	}
	
	/**
	 * Do tree search -> O(logn)
	 * @param k key
	 * @return value of the found node
	 */
	public String get(String k) {
			
		node position = root;
		String result = null;
		
		if(root == null) {
			result = "TREE IS EMPTY";
			return result;
		}
		
		while(!k.equals(position.key)) {
			if(position.isExternal()) {
				result = "Key was not found";
				break;
			}
			if(k.compareTo(position.key) < 0) {
				
				if(position.hasLeft()) {
					position = position.getLeftChild();
				}
			}
			else if (k.compareTo(position.key) > 0){
				if(position.hasRight()) {
					position = position.getRightChild();
				}
			}
		}	
		
		if(k.equals(position.key)) {
			result = position.value;		
		}
		return result;
	}
	
	/**
	 * do tree search and try to find the previous item -> O(logn)+O(1)
	 * @param k key of target item
	 * @return the key-value information of the previous item of target
	 */
	public String getPrev(String k) {
		
		node position = root;
		String result = null;
		
		if(root == null) {
			result = "LIST IS EMPTY";
			return result;
		}
		if(root.key.equals(k)) {
			result = ("This item has no predecessor");
			return result;
		}
		
		while(!k.equals(position.key)) {
			if(position.isExternal()) {
				result = "Key was not found";
				break;
			}
			if(k.compareTo(position.key) < 0) {
				if(position.hasLeft()) {
					position = position.getLeftChild();
				}
			}
			else if(k.compareTo(position.key) > 0) {
				if(position.hasRight()) {
					position = position.getRightChild();
				}
			}
		}//end of while
		
		if(k.equals(position.key)) {
			
			position = position.getPrev();
			result = "EIN: "+position.key+"\tName: "+position.value;
		}
		return result;
	}
	
	/**
	 * do tree search to find the next item -> O(logn)+O(1)
	 * @param k key of target item
	 * @return the key-value information of the next item of target
	 */
	public String getNext(String k) {
		
		node position = root;
		String result = null;		
		
		if(root == null) {
			result = "LIST IS EMPTY";
			return result;
		}
		
		while(!k.equals(position.key)) {
			if(position.isExternal()) {
				result = "Key was not found";
				break;
			}
			if(k.compareTo(position.key) < 0) {
				if(position.hasLeft()) {
					position = position.getLeftChild();
				}
			}
			else if(k.compareTo(position.key) > 0) {
				if(position.hasRight()) {
					position = position.getRightChild();
				}
			}
		}//end of while
		
		if(k.equals(position.key)) {
			
			if(position == lastadded) {
				result = "This item has no successor";
				return result;
			}
			position = position.next;
			result = "EIN: "+position.key+"\tNAME: "+position.value;	
		}
		return result;
	}
	
	/**
	 * insertion method: put new item -> in general, O(logn)+O(1)
	 * @param k the key of the new item
	 * @param v the value of the new item
	 */
	public void add(String k, String v) {
		
		node leftdummy = new node();
		node rightdummy = new node();
		
		//when the tree is empty
		if(root == null) {
					
			node newnode = new node(k, v, null, leftdummy, rightdummy, null, null, false);
			leftdummy.parent = root;
			rightdummy.parent = root;
			root = newnode;
			lastadded = newnode;
			size++;
			//System.out.println("EIN: "+newnode.key+"\tNAME: "+newnode.value+" succesfullly added.");
			return;
		}
		if(size == 1) {
			node newnode = new node(k, v, root, leftdummy, rightdummy, lastadded, null, false);
			leftdummy.parent = newnode;
			rightdummy.parent = newnode;
			if(newnode.key.compareTo(root.key)<0) {
				root.leftchild = newnode;
			}
			else {
				root.rightchild = newnode;
			}
			lastadded.next = newnode;
			lastadded = newnode;
			size++;
			//System.out.println("EIN: "+newnode.key+"\tNAME: "+newnode.value+" succesfullly added.");
			return;			
		}
		if(root.leftchild.isExternal() && k.compareTo(root.key) < 0) {
			
			node newnode = new node(k, v, root, leftdummy, rightdummy, lastadded, null, false);
			leftdummy.parent = newnode;
			rightdummy.parent = newnode;
			root.leftchild =newnode;
			lastadded.next = newnode;
			lastadded =newnode;
			size++;
			//System.out.println("EIN: "+newnode.key+"\tNAME: "+newnode.value+" succesfullly added.");
			return;
		}
		if(root.rightchild.isExternal() && k.compareTo(root.key)>0) {
			node newnode = new node(k, v, root, leftdummy, rightdummy, lastadded, null, false);
			leftdummy.parent = newnode;
			rightdummy.parent = newnode;
			root.rightchild = newnode;
			lastadded.next = newnode;
			lastadded = newnode;
			size++;
			//System.out.println("EIN: "+newnode.key+"\tNAME: "+newnode.value+" succesfullly added.");
			return;
		}
		
		// if not, do search first
		node position = root;
				
		while(!k.equals(position.key) && !position.isExternal()) {
			
			// keep going
			if(k.compareTo(position.key) < 0) {
				
				if(position.hasLeft()) {
					position = position.getLeftChild();
				}
			}
			//keep going
			else {
				if(position.hasRight()) {
					position = position.getRightChild();
				}
			}
		}// end of while loop
		
		if(position.isExternal()) {
			//if newly added node has smaller key than the parent
			if(k.compareTo(position.parent.key)<0) {
				
				node newnode = new node(k, v, position.parent, leftdummy, rightdummy, lastadded, null, false);
				leftdummy.parent = newnode;
				rightdummy.parent = newnode;
				position.parent.leftchild = newnode;
				lastadded.next = newnode;
				lastadded = newnode;
				size++;
				//System.out.println("EIN: "+newnode.key+"\tNAME: "+newnode.value+" succesfullly added.");
				return;
			}
			//if newly added node has larger key than the parent
			else {

				node newnode = new node(k, v, position.parent, leftdummy, rightdummy, lastadded, null, false);
				leftdummy.parent = newnode;
				rightdummy.parent = newnode;
				position.parent.rightchild = newnode;
				lastadded.next = newnode;
				lastadded = newnode;
				size++;
				//System.out.println("EIN: "+newnode.key+"\tNAME: "+newnode.value+" succesfullly added.");
				return;
			}
		}
	}
	
	/**
	 * deletion method -> O(logn)+O(1)
	 * @param k the key of the target item
	 * @return the key-value pair of removed item
	 */
	public String remove(String k) {
			
		node position = root;
		String result = null;
			
		//if the tree is empty
		if(root == null) {
			result = "TREE IS EMPTY.";
			return result;
		}
			
		//if there is root only or root is the target
		if(root.key.equals(k)) {
			
			result = "EIN: "+position.key+"\tNAME: "+position.value;
			
			if(size == 1) {
				lastadded = null;
				root = null;
				size--;
				return result;
			}
			if(size == 2) {
				if(position.hasLeft()) {
					position.leftchild.parent = null;
					root = position.leftchild;
				}
				else if(position.hasRight()) {
					position.rightchild.parent = null;
					root = position.rightchild;
				}
				size--;
				return result;
			}
			
			if (position.prev != null) {
				position.prev.next = position.next;
				position.next.prev = position.prev;
			}
			
			position = position.rightchild;
			
			while(!position.isExternal()) {
				position = position.leftchild;
			}
			position = position.parent;
			
			root.key = position.key;
			root.value = position.value;
			
			position.rightchild.parent = position.parent;
			position.parent.leftchild = position.rightchild;
			size--;
			return result;
		}
			
		//otherwise, go search
		while (!k.equals(position.key)) {
			if(position.isExternal()) {
				result = "key was not found";
				return result;
			}
				
			if(k.compareTo(position.key)<0) {
				if(position.hasLeft()) {
					position = position.getLeftChild();
				}
			}
			else if (k.compareTo(position.key) > 0){
				if(position.hasRight()) {
					position = position.getRightChild();
				}
			}
		}
		//if both children are external
		if(position.leftchild.isExternal() && position.rightchild.isExternal()) {
		
			result = "EIN: "+position.key+"\tNAME: "+position.value;
			if(lastadded==position) {
				position.prev.next = null;
				lastadded = position.prev;
			}
			else {
				
				position.prev.next = position.next;
				position.next.prev = position.prev;
			}
				
			if(position.parent.leftchild == position) {
				position.rightchild.parent = position.parent;
				position.parent.leftchild = position.rightchild;
				
			}
			else if(position.parent.rightchild == position) {
				position.rightchild.parent = position.parent;
				position.parent.rightchild = position.rightchild;
				
			}

		}
		//if only left child is external
		else if(position.leftchild.isExternal() && !position.rightchild.isExternal()) {
			
			result = "EIN: "+position.key+"\tNAME: "+position.value;
					
			if(lastadded==position) {
				position.prev.next = null;
				lastadded = position.prev;
			}
			else {
				position.prev.next = position.next;
				position.next.prev = position.prev;
			}
				
			if(position.parent.leftchild == position) {
				position.rightchild.parent = position.parent;
				position.parent.leftchild = position.rightchild;
			
			}
			else if(position.parent.rightchild == position){
				position.rightchild.parent = position.parent;
				position.parent.rightchild = position.rightchild;					
			}
		}
		// if only right child is external
		else if(!position.leftchild.isExternal() && position.rightchild.isExternal()) {
			
			result = "EIN: "+position.key+"\tNAME: "+position.value;
			
			if(lastadded==position) {
				position.prev.next = null;
				lastadded = position.prev;
			}
			else {
				position.prev.next = position.next;
				position.next.prev = position.prev;
			}
			if(position.parent.leftchild == position) {
				position.leftchild.parent = position.parent;
				position.parent.leftchild = position.leftchild;
				
			}
			else if(position.parent.rightchild == position) {
				position.leftchild.parent = position.parent;
				position.parent.rightchild = position.leftchild;
			}
		}
		//both children are internal	
		else {
			
			result = "EIN: "+position.key+"\tNAME: "+position.value;
			
			if(lastadded==position) {
				position.prev.next = null;
				lastadded = position.prev;
			}
			else {
				position.prev.next = position.next;
				position.next.prev = position.prev;
			}
					
			node temp = position;
			temp = temp.rightchild;
			
			while (!temp.isExternal()) {
				temp = temp.leftchild;
			}
			temp = temp.parent;
			
			
			position.key = temp.key;
			position.value = temp.value;
			
			temp.rightchild.parent = temp.parent;
			temp.parent.leftchild = temp.rightchild;
		}
	
		size--;
		return result;
	}
	
	/**
	 * deletion method -> O(1ogn)
	 * @return the key-value pair of removed item
	 */
	public String removeLastAdded() {
		String result = lastadded.key+"_"+lastadded.value;
		remove(lastadded.key);
		return result;
	}
		
	/**
	 * for sorted sequence -> inorder traversal O(n)
	 * @param size the size of the tree
	 * @return String array of lexicographically sorted item (key-value pair)
	 */
	public String[] printTree() {
		
			resetVisited(root);
			String[] result = new String[size];
			String[] temp = new String[size];
			node position = root;
					
			int i = -1;
			int j = 0;

			while(countArray(temp)!=0||!position.isExternal()) {
				
				if(!position.isExternal()) {
				
					if (position.hasLeft() && !position.leftchild.isVisited()) {
					
						i++;
						temp[i] = position.key+"_"+position.value;
						position.visited = true;
						position = position.leftchild;
					}
					else if(position.isVisited() && keyexist(temp, position.key) && !keyexist(result, position.key)) {
						
						i--;
						result[j] = temp[i+1];
						temp[i+1] = null;
						j++;
					}
					else if(position.hasRight() && !position.rightchild.isVisited()) {
						
						position = position.getRightChild();
					}
					else if(position.isVisited() && position.leftchild.isVisited() && position.rightchild.isVisited()) {
						
						position = position.parent;
					}
				}
				else {
						position.visited = true;
						position = position.parent;
						if(keyexist(temp, position.key) && !keyexist(result, position.key)) {
							
							i--;
							result[j] = temp[i+1];
							temp[i+1] = null;
							j++;
						}
						if(position.hasRight() && !position.rightchild.isVisited()) {
							
							position = position.rightchild;
						}
						else if(j == size) {
							
							break;
						}
						else {
						
							position = position.parent;
						}
				}		
				
		}
			
			return result;
	}
	
	/**
	 * iterative method: for rangekey -> O(logn)+O(1)
	 * @param k1 key String type / Item with k1 is always predecessor of key2 item
	 * @param k2 key String type
	 * @return the number of keys in range between key1 and key2
 	 */
	public int iterNext(String k1, String k2) {
		
		int count = 0;
		node position1 = root;
		
		while(!k1.equals(position1.key)) {
			if(position1.isExternal()) {
				System.out.println("BST ITERNEXT ERROR: Key1 not found");
				return 0;
			}
			if(k1.compareTo(position1.key)<0) {
				position1 = position1.leftchild;
			}
			else if(k1.compareTo(position1.key)>0) {
				position1 = position1.rightchild;
			}
			else {
				break;
			}
		}
		
		while(!k2.equals(position1.key)) {
			position1 = position1.next;
			if(position1 == null){
				System.out.println("BST ITERNEXT ERROR: Key2 not found");
				return 0;
			}
			count++;
		}
		return count;
	}
	
	/**
	 * @param size size of tree-> O(n)
	 * @return the String array of key-value pair. Unsorted but chronological order
	 */
	public String[] returnAllFromFirst() {
		node position = lastadded;
		
		String[] s = new String[size];
				
		for (int i = size-1; i >= 0; i--) {
			s[i] = position.key+"_"+position.value;
			position = position.prev;
		}
		return s;
	}
	
	/**
	 * helping method -> do inorder traversal in recursion and reset visited
	 * @param n starting from node n
	 */
	private static void resetVisited(node n) {
		
		if(n == null) {
			return;
		}
		if(n.isExternal()) {
			n.visited = false;
			return;
		}
		if(n.hasLeft()) {
			resetVisited(n.leftchild);
		}
		n.visited = false;
		if(n.hasRight()) {
			resetVisited(n.rightchild);
		}		
	}
	
	/**
	 * helping method 
	 * @param s String array
	 * @return the actual number of occupied index
	 */
	private int countArray(String[] s) {
		int count = 0;
		for(int i = 0; i < s.length; i++) {
			if(s[i]==null) {
				continue;
			}
			count++;
		}
		return count;
	}
	
	/**
	 * helping method
	 * @param s String array 
	 * @param k key
	 * @return boolean true if key exists in the sequence
	 */
	private boolean keyexist(String[] s, String k) {
		for(int i = countArray(s)-1; i >= 0; i--) {
			if(s[i]!= null && k.equals(s[i].substring(0,8)))
					return true;
		}
		return false;
	}
	
}//end of bst class


