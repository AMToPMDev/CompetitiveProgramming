import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import javax.xml.transform.Source;

/*

Operations related to Binary Search Tree are performed in this program.
*/

class Pair{
	int min;
	int max;
	int size;
	boolean flag;
	
	public Pair() {
		this.min = Integer.MAX_VALUE;
		this.max = Integer.MIN_VALUE;
		this.flag = true;
		this.size = 0;
	}
}

public class BinarySearchTree {
	Node root;
	
	public BinarySearchTree() {
		root = null;
	}
	
	public BinarySearchTree(int key) {
		root = new Node(key);
	}
	
	//Printing in Inorder Fashion
	public static void print(Node root) {
		if(root == null) {
			return;
		}
		
		print(root.left);
		System.out.print(root.key+", ");
		print(root.right);
	}
	
	//Converting sorted Array to Balanced Binary Search Tree
	public static Node arrayToBST(int[] arr, int i, int j) {
		if(i>j) {
			return null;
		}
		
		int mid = (i+j)/2;
		Node curr = new Node(arr[mid]);
		
		curr.left = arrayToBST(arr, i, mid-1);
		curr.right = arrayToBST(arr, mid+1, j);
		
		return curr;
	}
	
	//Check whether given Tree is a BST or not
	public static Pair isBST(Node root) {
		if(root == null) {
			return new Pair();
		}
		
		Pair residue = new Pair();
		Pair temp1, temp2;
		
		temp1 = isBST(root.left);
		temp2 = isBST(root.right);
		
		if(temp1.min == Integer.MAX_VALUE)
			residue.min = root.key;
		else
			residue.min = temp1.min;
		
		if(temp2.max == Integer.MIN_VALUE)
			residue.max = root.key;
		else
			residue.max = temp2.max;
		
		if(temp1.flag && temp2.flag && (temp1.max <= root.key && root.key <= temp2.min)) {
			residue.flag = true;
		}
		else {
			residue.flag = false;
		}
		
		return residue;
	}
	
	
	//Finding maximum size of BST in a  Binary tree
	//Procedure is similar to isBST, adding size to it only
	public static Pair maxBST(Node root) {
		if(root == null) {
			return new Pair();
		}
		
		Pair residue = new Pair();
		Pair temp1, temp2;
		
		temp1 = maxBST(root.left);
		temp2 = maxBST(root.right);
		
		if(temp1.min == Integer.MAX_VALUE) {
			residue.min = root.key;
		}
		else {
			residue.min = temp1.min;
		}
		
		if(temp2.max == Integer.MIN_VALUE) {
			residue.max = root.key;
		}
		else {
			residue.max = temp2.max;
		}
		
		if(temp1.flag && temp2.flag && (temp1.max <= root.key && root.key <= temp2.min)) {
			residue.flag = true;
		}
		else {
			residue.flag = false;
		}
		
		if(temp1.flag && temp2.flag && residue.flag) {
			residue.size = temp1.size + temp2.size + 1;
		}
		else {
			residue.size = (temp1.size>temp2.size)?temp1.size:temp2.size;
		}
		
		return residue;
	}
	
	
	//Kth smallest value in BST
	static int value = 0;
	static int c = 0;
	public static void kSmallest(Node root, int k) {
		if(root == null) {
			return;
		}
		
		if(c<k)
			kSmallest(root.left, k);
		
		c++;
		
		if(c == k) 
			value = root.key;
		
		if(c<k)
			kSmallest(root.right, k);
	}
	
	//Convert array having pre order traversal to Binary Search Tree using iterative approach
	public static BinarySearchTree preToBst(int arr[]){
		BinarySearchTree tree = new BinarySearchTree();
		Stack<Node> stk = new Stack<Node>();
		
		tree.root = new Node(arr[0]);
		Node curr = tree.root;
		stk.push(curr);
		
		for(int i=1; i<arr.length; i++) {
			Node temp = new Node(arr[i]);
			
			if(arr[i] < stk.peek().key) {
				curr.left = temp;
				stk.push(temp);
			}
			else {
				Node prev = null;
				
				while((!stk.isEmpty()) && (stk.peek().key < temp.key)) {
					prev = stk.pop();
				}
				prev.right = temp;
				stk.push(temp);
			}
			curr = temp;
		}
		
		return tree;
	}
	
	//VERY VERY IMPORTANT CONCEPT
	//Convert array having pre order traversal to Binary Search Tree using recursive approach
	static int i=0;
	public static Node preToBstRecursive(int[] arr, int min, int max, int sizeOfArr) {
		if(i>=sizeOfArr) {
			return null;
		}
		
		Node root = null;
		
		if((arr[i] > min) && (arr[i] < max)){
			root = new Node(arr[i]);
			i++;
			
			root.left = preToBstRecursive(arr, min, arr[i-1], sizeOfArr);
			root.right = preToBstRecursive(arr, arr[i-1], max, sizeOfArr);
			
			//to get all the leaf nodes in a BST from given preOrder traversal
			if(root.left == null && root.right == null) {
				System.out.println("leaf: "+arr[i-1]);
			}
		}
		
		return root;
	}
	
	//Given a level traversal of a tree, check if it is BST or not
	public static boolean isLevelOrderBST(int[] arr) {
		return false;
	}
	
	//Given two BSTs, find values from both tree which sum up to k
	//Use Inorder on 1st BST and Reverse Inorder on 2nd key (approach is similar to 2 pointers)
	public static void findPairSum() {
		
	}
	
	
	
	public static void main(String[] args) {
		//Sample Tree
		BinarySearchTree tree = new BinarySearchTree();
		
		tree.root = new Node(7);
		tree.root.left = new Node(3);
		tree.root.right = new Node(10);
		tree.root.left.left = new Node(2);
		tree.root.left.right = new Node(6);
		tree.root.right.left = new Node(9);
		tree.root.right.right = new Node(15);
//		print(tree.root);
//		System.out.println();
		
		//Sorted Array to Balanced Binary Search Tree
		BinarySearchTree tree2 = new BinarySearchTree();
		
		int[] arr = {3, 7, 8, 9, 10, 13};
		tree2.root = arrayToBST(arr, 0, arr.length-1);
//		print(tree2.root);
//		System.out.println();
		
		
		//Check BST or Not
		Pair result = isBST(tree.root);
		System.out.println("Is BST : "+result.flag);
		
		//Find size of maximum BST tree in a Binary Tree
		Pair maxBst = maxBST(tree.root);
		System.out.println("Is BST : "+maxBst.size);
		
		//Finding kth smallest in BST
		c = 0;
		value = 0;
		kSmallest(tree.root, 3);
		System.out.println("kth Smallest : "+value);
		System.out.println("\n----------------------------------------\n");
		
		int[] preOrder = {7, 3, 2, 4, 8};
		BinarySearchTree bst = preToBst(preOrder);
		System.out.println("BST tree formed from Preorder traversal array: ");
		print(bst.root);
		System.out.println("\n----------------------------------------\n");
		
		i = 0;
		bst.root = preToBstRecursive(preOrder, Integer.MIN_VALUE, Integer.MAX_VALUE, preOrder.length);
		System.out.println("BST tree formed from Preorder traversal array with recursive approach: ");
		print(bst.root);
		
	}
}
