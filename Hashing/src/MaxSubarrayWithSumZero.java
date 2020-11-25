import java.util.HashMap;

/*

Given an array [1,2,-2,4,-4]
Find the length of longest subarray whose length is zero.

*/
public class MaxSubarrayWithSumZero {

	public static void main(String[] args) {
		int[] arr = {1,2,-2,4,-4};
		
		int[] prefix_sum = new int[arr.length];
		prefix_sum[0] = arr[0];
		
		for(int i=1; i<arr.length; i++) {
			prefix_sum[i] += prefix_sum[i-1];
		}
		
		int result = 0;
		
		HashMap<Integer, Integer> hs = new HashMap<Integer, Integer>();
		int temp;
		for(int i=0; i<arr.length; i++) {
			if(hs.containsKey(prefix_sum[i])) {
				temp = i - hs.get(prefix_sum[i]);
				
				result = (result>temp)?result:temp;
			}
			else {
				hs.put(prefix_sum[i], i);
			}
		}
		System.out.println(result);
	}
}
