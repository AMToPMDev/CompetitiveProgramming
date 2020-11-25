import java.util.HashMap;
import java.util.Map;

/*
Given a string S, find is it is possible to re-order the characters of the string S so that it can be
represented as a concatenation of K similar strings.

Eg: If S=aabb and k=2, then it is possible to rearrange the string as 'abab', which is a
	concatenation of two similar string 'ab'.
	
If it is possible, return 1 else return -1.

*/
public class BreakingStringIntoConcatenationOfSimilarString {

	public static void main(String[] args) {
		int k = 4;
		String str = "bbaabbaacccc";
		
		HashMap<Character, Integer> hs = new HashMap<>();
		
		for(int i=0; i<str.length(); i++) {
			if(hs.containsKey(str.charAt(i))) {
				hs.put(str.charAt(i), hs.get(str.charAt(i))+1);
			}
			else {
				hs.put(str.charAt(i), 1);
			}
		}
		
		boolean ans = true;
		
		for(Map.Entry<Character, Integer> element: hs.entrySet()) {
			if(element.getValue()%k != 0) {
				ans = false;
			}
		}
		
		if(ans) {
			System.out.println("Possible");
		}
		else {
			System.out.println("Not Possible");
		}
	}

}
