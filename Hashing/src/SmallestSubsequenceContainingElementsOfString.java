 import java.util.HashMap;
import java.util.Map;

/*
There are two strings:
A = ADOBECODEBANC
B = ABC

Ans : BANC

Find a smallest subsequence in A which contains all elements of B

Hint:
Use two HashMaps(one for each string) and check character by character if it is equal. 
  
*/
public class SmallestSubsequenceContainingElementsOfString {

	public static void main(String[] args) {
		String A = "ADOBECODEBANC";
		String B = "ABC";
		
		HashMap<Character, Integer> hashA = new HashMap<Character, Integer>();
		HashMap<Character, Integer> hashB = new HashMap<Character, Integer>();
		
		for(int i=0; i<B.length(); i++) {
			if(hashB.containsKey(B.charAt(i))) {
				hashB.put(B.charAt(i), hashB.get(B.charAt(i))+1);
			}
			else {
				hashB.put(B.charAt(i), 1);
			}
		}
		
		int[] arr = new int[A.length()];
		
		int p = 0;
		boolean flag = true;
		for(int i = 0; i<A.length();) {
			if(flag) {
				if(hashA.containsKey(A.charAt(i))) {
					hashA.put(A.charAt(i), hashA.get(A.charAt(i))+1);
				}
				else {
					hashA.put(A.charAt(i), 1);
				}
			}
			
			if(!equal(hashA, hashB)) {
				flag = true;
				i++;
			}
			else {
				flag = false;
				arr[p] = i;
				
				hashA.put(A.charAt(p), hashA.get(A.charAt(p))-1);
				p++;
			}
		}
		
		int ans = Integer.MAX_VALUE;
		int temp;
		for(int i=0; i<arr.length && arr[i]!=0; i++) {
			temp = (arr[i] - i) + 1;
			System.out.println("arr[i] : "+arr[i]+" i : "+i);
			ans = (ans<temp)?ans:temp;
		}
		
		System.out.println("Answer : "+ans);
	}
	
	public static boolean equal(HashMap<Character, Integer> hashA, HashMap<Character, Integer> hashB) {
		boolean residue = true;
		
		for(Map.Entry<Character, Integer> element: hashB.entrySet()) {
			char key = element.getKey();
			
			if(!(hashA.containsKey(key) && (hashA.get(key) >= element.getValue()))) {
				residue = false;
			}
		}
		
		return residue;
	}
}