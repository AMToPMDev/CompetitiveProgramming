package arrayAndMaths;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/*

Given an array [4,8,10]  (no numbers will repeat)

We have been given array containing GCD of every possible pair

i.e. [4,4,2,4,8,2,2,2,10]

Eg: output array [A1, A2, A3]

input is gcd of : [A1A1, A1A2, A1A3, A2A1, A2A2, A2A3, A3A1, A3A2, A3A3] (order can be interchanges

Deduce original array given gcd array
*/

public class findOriginalArrayFromGcdArray {
	public static void main(String args[]) {
		int[] input = {4,4,2,4,8,2,2,2,10};
		
		HashMap<Integer, Integer> hs = new HashMap<>();
		
		for(int i=0; i<input.length; i++) {
			if(hs.containsKey(input[i])) {
				hs.put(input[i], hs.get(input[i])+1);
			}
			else {
				hs.put(input[i], 1);
			}
		}
		
		ArrayList<Integer> result = new ArrayList<>();
		
		for(Map.Entry<Integer, Integer> entry : hs.entrySet()) {
			if(entry.getValue()%2 != 0) {
				result.add(entry.getKey());
			}
		}
		
		for(Integer item : result) {
			System.out.print(item + ",");
		}
	}
}
