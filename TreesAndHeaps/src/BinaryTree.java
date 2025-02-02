import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/*

Operations related to Tree Data Structure
*/

class Node {
	int key;
	Node left, right;
	
	public Node(int item) {
		key = item;
		left = right = null;
	}
}

class Height{
	int height = 0;
}

public class BinaryTree{
	Node root;
	
	public BinaryTree(int key) {
		root = new Node(key);
	}
	
	public BinaryTree() {
		root = null;
	}
	
	//checking height of node/tree
	public static int height(Node node) {
		if(node == null) {
			return -1;
		}
		else {
			return 1 + max(height(node.left),height(node.left));
		}
	}
	
	public static int max(int a, int b) {
		return (a>b)?a:b;
	}
	
	//checking node is Balanced or not in O(n) time
	public static boolean check(Node node, Height height) {
		if(node==null) {
			height.height = 0;
			return true;
		}
		
		Height lh = new Height();
		Height rh = new Height();
		
		
		boolean l = check(node.left, lh);
		boolean r = check(node.right, rh);
		
		height.height = 1 + max(lh.height, rh.height);
		
		if(Math.abs(lh.height-rh.height)>1) {
			return false;
		} 
		
		return l&&r;
	}
	
	//traversing tree in Inorder fashion
	public static void inorderTraversal(Node node) {
		if(node == null)
			return;
		
		
		//order of these operations will change for preorder and postorder traversals
		inorderTraversal(node.left);
		System.out.print(node.key+", ");
		inorderTraversal(node.right);
	}
	
	//level order traversal for a tree (without recursion)
	public static void levelOrderTraversal(Node node) {
		Queue<Node> q = new LinkedList<Node>();
		Node temp;
		
		q.add(node);
		
		while(!q.isEmpty()) {
			temp = q.remove();
			
			System.out.print(temp.key+", ");
			
			if(temp.left!=null)
				q.add(temp.left);
			if(temp.right!=null)
				q.add(temp.right);
		}
	}
	
	//counting elements at each level using DFS
	public static HashMap<Integer, Integer> countElementsAtEachLevel(int level, HashMap<Integer, Integer> hs, Node node){
		
		if(hs.containsKey(level))
			hs.put(level, hs.get(level)+1);
		else
			hs.put(level,1);
		
		if(node.left!=null) {
			countElementsAtEachLevel(level+1, hs, node.left);
		}
		if(node.right!=null) {
			countElementsAtEachLevel(level+1, hs, node.right);
		}
		
		return hs;
	}
	
	//counting elements at each level using BFS without recursion
	public static void countElementsAtEachLevelBFS(Node node){
		Queue<Node> q = new LinkedList<Node>();
		int level = 0;
		
		System.out.println("level "+level);
		q.add(node);
		q.add(null);
		
		Node temp;
		int count=0;
		
		while(!q.isEmpty() && count<2) {
			temp = q.remove();
			//count is used to check the end of tree, two consecutive nulls will mean end of tree
			if(temp==null) {
				level++;
				count++;
				q.add(null);
				System.out.println();
				System.out.println("level "+level);
			}
			else {
				count=0;
				System.out.print(temp.key+", ");
				
				if(temp.left!=null)
					q.add(temp.left);
				if(temp.right!=null)
					q.add(temp.right);
			}
		}
	}
	
	//count number of nodes in a tree
	public static int countNodes(Node root) {
		if(root == null) {
			return 0;
		}
		else {
			int temp = countNodes(root.left) + countNodes(root.right);
			return temp+1;
		}
	}
	
	//Check if the tree can be divided in two equal parts containing n/2 nodes
	public static boolean flag = false;
	public static int isDivisible(Node root, int count) {
		
		if(root == null) {
			return 0;
		}
		
		int temp = 1 + isDivisible(root.left, count) + isDivisible(root.right, count);
		
		if(temp == count/2) {
			flag = true;
		}
		
		return temp;
	}
	
	//Given two keys, find the smallest subtree having both the keys part of it.
	
	
	public static void main(String args[]) {
		BinaryTree tree = new BinaryTree();
		
		tree.root = new Node(1);
		
		tree.root.left = new Node(2);
		
		tree.root.right = new Node(3);
		
		tree.root.left.left = new Node(4);
		
		tree.root.left.right = new Node(5);
		
		tree.root.right.left = new Node(6);
		
		tree.root.left.left.left = new Node(7);
		
		tree.root.left.left.right = new Node(8);
		
		System.out.println(height(tree.root));
		Height h = new Height();
		System.out.println(check(tree.root, h));
		
		inorderTraversal(tree.root);
		System.out.println();
		levelOrderTraversal(tree.root);
		
		HashMap<Integer, Integer> hs = new HashMap<Integer, Integer>();
		
		hs = countElementsAtEachLevel(0, hs, tree.root);
		System.out.println();
		for(Map.Entry<Integer, Integer> element: hs.entrySet()) {
			System.out.println("Key: "+element.getKey()+", Value: "+element.getValue());
		}
		
		
		System.out.println();
		
		countElementsAtEachLevelBFS(tree.root);
		
		System.out.println("Number of Nodes : " + countNodes(tree.root));
		
		isDivisible(tree.root, countNodes(tree.root));
		
		System.out.println("Is Tree Divisible in two parts : "+flag);
	}
}
