
/*

Given an array, arr: [1, 2, 2, 3, 1]

arr[i] can vote to any position in array if difference between them is less than or equal to its weight.
We have to find out total number of votes that can be casted.

For eg:
Value      Possible votees
arr[0] 		arr[1]
arr[1]   	arr[0], arr[2], arr[3]
arr[2]   	arr[0], arr[1], arr[3]
arr[3] 		arr[1], arr[2], arr[4]
arr[4] 		arr[3]

Total votes : 11


Approach:
Use prefix_sum array
*/
public class NoOfVotesInPriorityArray {

	public static void main(String[] args) {
		int[] input = {1, 2, 2, 3, 1};
		int n = input.length;
		
		int[] prefix_sum = new int[n];
		
		prefix_sum[0] = input[0];
		for(int i=1; i<n; i++) {
			prefix_sum[i] = prefix_sum[i-1] + input[i];
		}
		
		int[] ans = new int[n];
			
		for(int i=0; i<n; i++) {
			
		}
	}

}
