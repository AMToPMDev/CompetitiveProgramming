package arrayAndMaths;

import java.util.HashMap;
import java.util.Map;

/*

Find the number which occurs more than n/2 times in an array.

Input : [3,3,4,4,4,2,2,4,4]
n:9
Output : 4 (as it occurs for 5 times)

PS: If no number's count>n/2, then return 0
*/

public class countMaxOccuringNumber {
	public static void main(String args[]) {
		HashMap<Integer, Integer> hs = new HashMap<>();
		
		int input[] = {3,3,4,4,2,2,4,4};
		int n = input.length;
		
		for(int i=0; i<n; i++) {
			if(hs.containsKey(input[i])) {
				hs.put(input[i], hs.get(input[i])+1);
			}
			else {
				hs.put(input[i], 1);
			}
		}
		
		int ans = 0;
		
		for(Map.Entry<Integer, Integer> entry : hs.entrySet()) {
			if(entry.getValue()>Math.floor(n/2)) {
				ans = entry.getKey();
				
				break;
			}
		}
		
		System.out.println("Answer : "+ans);
	}
}
