import java.util.HashMap;

/*
Given an array, find the number of Arithmetic subsequences that are possible from it.
Arithmetic subsequence is a subsequence of length greater than or equal to 3 and is an arithmetic progression.

Eg:
I/P: [2,4,6,8,10]
O/P: 7
(sequences -> [2,4,6],[4,6,8],[6,8,10],[2,4,6,8],[4,6,8,10],[2,4,6,8,10],[2,6,10] )

*/

public class arithmeticSubsequence {
	public static void main(String[] args) {
		int[] arr = {2,4,6,8,10};
		
		//HashMap<Integer, HashMap<Integer, Integer>> dp = new HashMap<>();
		
		int[][] dp = new int[1000][1000];
		
		int ans = 0;
		int len = arr.length;
		
		for(int i=len-3; i>=0; i--) {
			HashMap<Integer, Integer> freq = new HashMap<>();
			
			freq.put(arr[len-1], 1);
			freq.put(arr[len-2], 1);
			
			for(int j=len-2; j>i; j--) {
				dp[i][arr[i]-arr[j]] += dp[j][arr[i]-arr[j]];
				
				ans += dp[i][arr[i]-arr[j]];
			}
		}
	}
}
