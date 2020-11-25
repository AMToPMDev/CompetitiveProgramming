import java.util.Currency;
import java.util.HashMap;

import javax.print.attribute.standard.Finishings;

class TrieNode{
	HashMap<Character, TrieNode> hs;
	int count;
	char value;
	
	public TrieNode() {
		this.value = '*';
		count = 0;
		hs = new HashMap<Character, TrieNode>();
	}
	
	public TrieNode(char value) {
		this.value = value;
		count = 1;
		hs = new HashMap<Character, TrieNode>();
	}
}

public class Trie {
	TrieNode root;
	
	public Trie() {
		root = new TrieNode();
	}
	
	public static Trie insert(Trie trie, String str) {
		int len = str.length();
		
		TrieNode curr = trie.root;  
		
		for(int i=0; i<len; i++) {
			char key = str.charAt(i);
			
			if(curr.hs.containsKey(key)) {
				curr = curr.hs.get(key);
				curr.count++;
			}
			else {
				TrieNode temp = new TrieNode(key);
				curr.hs.put(key, temp);
				curr = temp;
			}
		}
		
		return trie;
	}
	
	public static boolean search(Trie trie, String str) {
		int len = str.length();
		boolean flag = true;
		
		TrieNode curr = trie.root;
		
		for(int i=0; i<len; i++) {
			char key = str.charAt(i);
			
			if(curr.hs.containsKey(key)) {
				curr = curr.hs.get(key);
				System.out.println("Count "+curr.value+" : "+curr.count);
			}
			else {
				flag = false;
				break;
			}
		}
		
		return flag;
	}
	
	//Given a Trie containing some strings, given the prefix for a String which uniquely identifies that String
	//If Trie contains ["act","desk","debt","dusk","dust"]
	//For "act", output will be a
	//For "desk", output will be des
	public static String onlyPrefix(Trie trie, String str) {
		int len = str.length();
		int i=0;
		
		TrieNode curr = trie.root;
		
		while(i<len) {
			char key = str.charAt(i);
			
			if(curr.hs.containsKey(key)) {
				curr = curr.hs.get(key);
				
				if(curr.count == 1) {
					return str.substring(0, i+1);
				}
			}
			else {
				return "";
			}
			i++;
		}
		
		return "";
	}
	
	//Find two numbers with maximum XOR from a given array
	//<<<<<------------------IMPORTANT CONCEPT AND IMPORTANT QUESTION------------------>>>>>>
	public static String formBinary(int value, int n) {
		String str = "";
		
		while(value>0) {
			str = String.valueOf(value%2) + str;
			
			value = value/2;
		}
		
		if(str.length() < n) {
			while(str.length() < n) {
				str = "0" + str;
			}
		}
		
		return str;
	}
	
	public static int maxValue(int[] arr) {
		int ret = Integer.MIN_VALUE;
		
		for(int i=0; i<arr.length; i++) {
			if(arr[i] > ret) ret = arr[i];
		}
		
		return ret;
	}
	
	public static int calculateXor(String a, String b) {
		int res = 0;
		int c = 1;
		for(int i=a.length()-1; i>=0; i--) {
			if(a.charAt(i) != b.charAt(i)) {
				res = c + res;
			}
			c = c*2;
		}
		
		return res;
	}
	
	public static void maxXor(int[] arr) {
		Trie trie = new Trie();
		int max = maxValue(arr);
		
		int len = formBinary(max, 0).length();
		
		String[] values = new String[arr.length];
		
		for(int i=0; i<arr.length; i++) {
			values[i] = formBinary(arr[i], len);
			trie = insert(trie, values[i]);
		}
		
		String v1="";
		String v2="";
		int maxValue=-1;
		
		for(int i=0; i<values.length; i++) {
			String a = values[i];
			String b = "";
			TrieNode curr = trie.root;
			
			for(int j=0; j<a.length(); j++) {
				char key = (a.charAt(j)=='1')?'0':'1';
				if(curr.hs.containsKey(key)) {
					curr = curr.hs.get(key);
					b = b + key;
				}
				else {
					b = b + a.charAt(j);
				}
			}
			
			if(calculateXor(a, b) > maxValue) {
				maxValue = calculateXor(a, b);
				v1=a;
				v2=b;
			}
		}
		
		System.out.println("Max Xor : "+maxValue);
		System.out.println("Number1 : "+v1);
		System.out.println("Number2 : "+v2);
	}
	
	public static void main(String[] args) {
		Trie trie = new Trie();
		
		insert(trie, "act");
		insert(trie, "desk"); 
		insert(trie, "debt");
		insert(trie, "dusk");
		insert(trie, "dust");
		
		System.out.println("Contains dust : "+search(trie, "dust"));
		System.out.println("Contains dusty : "+search(trie, "dusty"));
		System.out.println("Only Prefix : "+onlyPrefix(trie, "dust"));
		
		int[] arr = {3, 4, 1, 5, 7};
		
		maxXor(arr);
	}
}
